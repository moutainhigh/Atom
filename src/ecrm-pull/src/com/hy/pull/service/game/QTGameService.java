package com.hy.pull.service.game;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hy.pull.common.util.DateUtil;
import com.hy.pull.common.util.GameHttpUtil;
import com.hy.pull.common.util.MoneyHelper;
import com.hy.pull.common.util.SGSUtil;
import com.hy.pull.common.util.game.AOIGame;
import com.hy.pull.common.util.game.IDNGame;
import com.hy.pull.common.util.game.M88Game;
import com.hy.pull.common.util.game.QTGame;
import com.hy.pull.common.util.game.SGSGame;
import com.hy.pull.mapper.AoiGameinfoMapper;
import com.hy.pull.mapper.ApiIdnGameinfoMapper;
import com.hy.pull.mapper.ApiM88GameinfoMapper;
import com.hy.pull.mapper.ApiQtGameinfoMapper;
import com.hy.pull.mapper.ApiSgsGameinfoMapper;
import com.hy.pull.mapper.DataHandleLogsMapper;
import com.hy.pull.mapper.DataHandleMapper;
import com.hy.pull.mapper.TbProxyKeyMapper;
import com.hy.pull.service.BaseService;
import com.hy.pull.service.BaseService.Enum_flag;

/**
 * QT游戏服务类
 * 创建日期 2016-10-13
 * @author temdy
 */
@Service
public class QTGameService extends BaseService {
	
	Logger logger = LogManager.getLogger(QTGameService.class.getName());  
	
	@Autowired
	private ApiQtGameinfoMapper apiQtGameinfoMapper;
	
	@Autowired
	private TbProxyKeyMapper tbProxyKeyMapper;
	
	@Autowired
	private DataHandleMapper dataHandleMapper;
	@Autowired
	private DataHandleLogsMapper dataHandleLogsMapper;
	
	
	private static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
	/**
	 * 按条件拉取数据的方法
	 * @param entity 条件集合{GAME_ID:游戏编号,PROXY_ID:代理编号,MAX_VALUE:上次拉取的最大值}
	 * @return 数据行数
	 */
	@Override
	public Integer pullData(Map<String, Object> entity) throws Exception {
		
		/**********************获取上次拉取的最大值***********************/
		Map<String, Object> dataHandle = dataHandleMapper.selectByPrimaryKey(LogUtil.HANDLE_QT);
		dataHandle.put("lastnum", "0");
		String updatetime = dataHandle.get("updatetime").toString();
		
		
		int count = 0;//累计执行总数量
		//System.out.println("东方游戏数据拉取开始，参数列表："+entity);
		List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
		if(entity==null){//判断是否为空，空则创建一个新的对象
			entity = new HashMap<String,Object>();
		}
		if(!entity.containsKey("GAME_ID")){//判断是否存在游戏编号，没则默认初始化为东方游戏
			entity.put("GAME_ID", "21");//设置所属游戏编号
		}
		//获取东方游戏的所有代理密钥列表
		List<Map<String,Object>> list = tbProxyKeyMapper.selectByEntity(entity);
		int size = list.size();		
		if(size > 0){
			String API_URL = null;//接口URL
			String agentname = null;//
			String agentpwd = null;//
			
			String stardate = null;//开始日期
			String enddate = null;//开始日期
			
			if(entity.get("BEGIN_DATE") != null){//判断是否存在开始日期
				stardate = entity.get("BEGIN_DATE").toString();
			}
			if(entity.get("END_DATE") != null){//判断是否存在结束日期
				enddate = entity.get("END_DATE").toString();
			}
			
			
			//间隔分钟数（不得超过12小时）
			int intervalnum = 60;
			intervalnum = Integer.valueOf(dataHandle.get("intervalnum").toString());
			
			
			
			/***********************设定开始结束时间，每次只拉取6分钟内的数据*****************************/
			stardate = DateUtil.parse(DateUtil.add(DateUtil.parse(updatetime, "yyyy-MM-dd HH:mm:ss"), Calendar.MINUTE, -30), "yyyy-MM-dd HH:mm:ss");//后退一分钟
			enddate =  DateUtil.parse(DateUtil.add(DateUtil.parse(stardate, "yyyy-MM-dd HH:mm:ss"), Calendar.MINUTE, intervalnum), "yyyy-MM-dd HH:mm:ss");//
			if(DateUtil.parse(enddate, "yyyy-MM-dd HH:mm:ss").getTime() > new Date().getTime()) {
				//最后时间不能超过当前时间
				enddate = DateUtil.parse(new Date(), "yyyy-MM-dd HH:mm:ss");
			}
			
			boolean flag = true;
			
			int len = 0;
			for(int i = 0; i < size; i++){
				entity = list.get(i);
				API_URL = entity.get("PROXY_API_URL").toString();//API_URL
				agentname = entity.get("PROXY_KEY1").toString();//agentname
				agentpwd = entity.get("PROXY_KEY2").toString();//agentpwd
				
				data = QTGame.getQTData(API_URL, agentname, agentpwd, stardate, enddate);
				if(data != null){
					len = data.size();
					count += len;//累计执行结果
					if(len > 0){//如果有数据就入库
						
						apiQtGameinfoMapper.batchInsert(data);//批量入库
						
						
						dataHandle.put("lastnum", Integer.parseInt(dataHandle.get("lastnum").toString()) + len);
						dataHandle.put("allnum", Integer.parseInt(dataHandle.get("allnum").toString()) + len);
					}
					
					//dataHandleLogsMapper.insert(LogUtil.saveLog(LogUtil.HANDLE_QT, null, len+"个", agentname, Enum_flag.正常.value));
					
					
				} else {
					//为null表示出现异常
					flag = false;
					
					dataHandleLogsMapper.insert(LogUtil.saveLog(LogUtil.HANDLE_QT, null, "返回NULL数据", agentname, Enum_flag.异常.value));
					
					
					break;
				}
				
			}
			
			/***************更新配置管理库****************/
			if(flag) {
				dataHandle.put("updatetime", enddate);
				dataHandle.put("lasttime", DateUtil.parse(new Date(), "yyyyMMddHHmmss"));
				dataHandleMapper.update(dataHandle);
			}
			
			/***************更新配置管理库****************/
			
		}
		logger.debug("QT游戏数据拉取结束。。。");
		return count;
	}
	
	
	/**
	 * 每日补单
	 * 
	 * 
	 */
	public Integer pullDataPatch(Map<String, Object> entity) throws Exception {
		int count = 0;
		
		/**********每次拉一天的（北京时间昨日）**************/
		List<String> listTime = getListStartEndTime( "yyyy-MM-dd HH:mm:ss", 4, Calendar.HOUR_OF_DAY);
		for (String string : listTime) {
			String stardate = string.split("=")[0];
			String enddate = string.split("=")[1];
			count += pullDataPatch(entity, stardate, enddate);
		}
		
		return count;
	}
	
	/**
	 * 补单数据
	 * 
	 * 
	 * @return 数据行数
	 */
	private Integer pullDataPatch(Map<String, Object> entity,String stardate,String enddate) throws Exception {
		
		/**********************获取上次拉取的最大值***********************/
		
		int count = 0;//累计执行总数量
		//System.out.println("东方游戏数据拉取开始，参数列表："+entity);
		List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
		if(entity==null){//判断是否为空，空则创建一个新的对象
			entity = new HashMap<String,Object>();
		}
		if(!entity.containsKey("GAME_ID")){//判断是否存在游戏编号，没则默认初始化为东方游戏
			entity.put("GAME_ID", "21");//设置所属游戏编号
		}
		//获取东方游戏的所有代理密钥列表
		List<Map<String,Object>> list = tbProxyKeyMapper.selectByEntity(entity);
		int size = list.size();		
		if(size > 0){
			String API_URL = null;//接口URL
			String agentname = null;//
			String agentpwd = null;//
			
			
			
			boolean flag = true;
			
			int len = 0;
			for(int i = 0; i < size; i++){
				entity = list.get(i);
				API_URL = entity.get("PROXY_API_URL").toString();//API_URL
				agentname = entity.get("PROXY_KEY1").toString();//agentname
				agentpwd = entity.get("PROXY_KEY2").toString();//agentpwd
				
				data = QTGame.getQTData(API_URL, agentname, agentpwd, stardate, enddate);
				if(data != null){
					len = data.size();
					count += len;//累计执行结果
					if(len > 0){//如果有数据就入库
						
						apiQtGameinfoMapper.batchInsert(data);//批量入库
						
					}
					
					//dataHandleLogsMapper.insert(LogUtil.saveLog(LogUtil.HANDLE_QT, null, len+"个", agentname, Enum_flag.正常.value));
					
					
				} else {
					//为null表示出现异常
					flag = false;
					
					dataHandleLogsMapper.insert(LogUtil.saveLog(LogUtil.HANDLE_QT, null, "返回NULL数据", agentname, Enum_flag.异常.value));
					
					
					break;
				}
				
			}
			
			/***************更新配置管理库****************/
			/***************更新配置管理库****************/
			
		}
		logger.debug("QT游戏数据拉取结束。。。");
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(DateUtil.parse(new Date(), "yyyyMMddHHmmss"));
	}
}
