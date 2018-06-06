package com.maven.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.maven.base.dao.BaseDao;
import com.maven.entity.ActivityBetRecord;
import com.maven.entity.ApiSoltGametypeEnterprise;

@Repository
public interface ApiSoltGametypeEnterpriseDao extends BaseDao<ApiSoltGametypeEnterprise>{
	
	List<ApiSoltGametypeEnterprise> selectTypes(Map<String, Object> parameter) throws Exception;
	
	void deleteByEnterprisecode(String enterprisecode) throws Exception;
	
	/**
	 * 查询需要打码的记录
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	List<ApiSoltGametypeEnterprise> selectAdd(Map<String, Object> parameter) throws Exception;
	
	/**
	 * 查询需要打码的记录总数
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	int selectAddCount(Map<String, Object> parameter) throws Exception;
	
	
	/**
	 * 查询需要打码的记录
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	List<ApiSoltGametypeEnterprise> selectBetRecord(Map<String, Object> parameter) throws Exception;
	
	/**
	 * 查询需要打码的记录总数
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	int selectBetRecordCount(Map<String, Object> parameter) throws Exception;
	
	/**
	 * 查询需要打码的记录
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	List<ApiSoltGametypeEnterprise> select(Map<String, Object> parameter) throws Exception;
	
	
	/**
	 * 增加打码记录
	 * @param betrecord
	 * @throws Exception
	 */
	void addBetRecord(ApiSoltGametypeEnterprise betrecord) throws Exception;
}
