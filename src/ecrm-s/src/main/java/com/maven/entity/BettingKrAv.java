package com.maven.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Model class of betting_kr_av.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class BettingKrAv implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** 注单ID. */
	private String tid;

	/** 企业编码. */
	private String enterprisecode;

	/** 品牌编码. */
	private String brandcode;

	/** 员工编码. */
	private String employeecode;

	/** 上级员工编码. */
	private String parentemployeecode;

	/** 登陆用户名. */
	private String loginaccount;

	/** 投注标识. */
	private String transtype;

	/** 下注金额. */
	private Double amount;

	/** 结果标识. */
	private String transtype2;

	/** 输赢金额. */
	private Double amount2;

	/** 游戏大类. */
	private String provider;

	/** 循环序号. */
	private String roundid;

	/** 游戏信息. */
	private String gameinfo;

	/** 游戏大类. */
	private String gamebigtype;

	/** 游戏历史名称. */
	private String history;

	/** 完成信息. */
	private String isroundfinished;

	/** 下注时间. */
	private Date time;

	/** 用户名. */
	private String userid;

	/** 数据生成时间. */
	private Date createtime;

	/**
	 * Constructor.
	 */
	public BettingKrAv() {
	}

	/**
	 * Set the 注单ID.
	 * 
	 * @param tid
	 *            注单ID
	 */
	public void setTid(String tid) {
		this.tid = tid;
	}

	/**
	 * Get the 注单ID.
	 * 
	 * @return 注单ID
	 */
	public String getTid() {
		return this.tid;
	}

	/**
	 * Set the 企业编码.
	 * 
	 * @param enterprisecode
	 *            企业编码
	 */
	public void setEnterprisecode(String enterprisecode) {
		this.enterprisecode = enterprisecode;
	}

	/**
	 * Get the 企业编码.
	 * 
	 * @return 企业编码
	 */
	public String getEnterprisecode() {
		return this.enterprisecode;
	}

	/**
	 * Set the 品牌编码.
	 * 
	 * @param brandcode
	 *            品牌编码
	 */
	public void setBrandcode(String brandcode) {
		this.brandcode = brandcode;
	}

	/**
	 * Get the 品牌编码.
	 * 
	 * @return 品牌编码
	 */
	public String getBrandcode() {
		return this.brandcode;
	}

	/**
	 * Set the 员工编码.
	 * 
	 * @param employeecode
	 *            员工编码
	 */
	public void setEmployeecode(String employeecode) {
		this.employeecode = employeecode;
	}

	/**
	 * Get the 员工编码.
	 * 
	 * @return 员工编码
	 */
	public String getEmployeecode() {
		return this.employeecode;
	}

	/**
	 * Set the 上级员工编码.
	 * 
	 * @param parentemployeecode
	 *            上级员工编码
	 */
	public void setParentemployeecode(String parentemployeecode) {
		this.parentemployeecode = parentemployeecode;
	}

	/**
	 * Get the 上级员工编码.
	 * 
	 * @return 上级员工编码
	 */
	public String getParentemployeecode() {
		return this.parentemployeecode;
	}

	/**
	 * Set the 登陆用户名.
	 * 
	 * @param loginaccount
	 *            登陆用户名
	 */
	public void setLoginaccount(String loginaccount) {
		this.loginaccount = loginaccount;
	}

	/**
	 * Get the 登陆用户名.
	 * 
	 * @return 登陆用户名
	 */
	public String getLoginaccount() {
		return this.loginaccount;
	}

	/**
	 * Set the 投注标识.
	 * 
	 * @param transtype
	 *            投注标识
	 */
	public void setTranstype(String transtype) {
		this.transtype = transtype;
	}

	/**
	 * Get the 投注标识.
	 * 
	 * @return 投注标识
	 */
	public String getTranstype() {
		return this.transtype;
	}

	/**
	 * Set the 下注金额.
	 * 
	 * @param amount
	 *            下注金额
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * Get the 下注金额.
	 * 
	 * @return 下注金额
	 */
	public Double getAmount() {
		return this.amount;
	}

	/**
	 * Set the 结果标识.
	 * 
	 * @param transtype2
	 *            结果标识
	 */
	public void setTranstype2(String transtype2) {
		this.transtype2 = transtype2;
	}

	/**
	 * Get the 结果标识.
	 * 
	 * @return 结果标识
	 */
	public String getTranstype2() {
		return this.transtype2;
	}

	/**
	 * Set the 输赢金额.
	 * 
	 * @param amount2
	 *            输赢金额
	 */
	public void setAmount2(Double amount2) {
		this.amount2 = amount2;
	}

	/**
	 * Get the 输赢金额.
	 * 
	 * @return 输赢金额
	 */
	public Double getAmount2() {
		return this.amount2;
	}

	/**
	 * Set the 游戏大类.
	 * 
	 * @param provider
	 *            游戏大类
	 */
	public void setProvider(String provider) {
		this.provider = provider;
	}

	/**
	 * Get the 游戏大类.
	 * 
	 * @return 游戏大类
	 */
	public String getProvider() {
		return this.provider;
	}

	/**
	 * Set the 循环序号.
	 * 
	 * @param roundid
	 *            循环序号
	 */
	public void setRoundid(String roundid) {
		this.roundid = roundid;
	}

	/**
	 * Get the 循环序号.
	 * 
	 * @return 循环序号
	 */
	public String getRoundid() {
		return this.roundid;
	}

	/**
	 * Set the 游戏信息.
	 * 
	 * @param gameinfo
	 *            游戏信息
	 */
	public void setGameinfo(String gameinfo) {
		this.gameinfo = gameinfo;
	}

	/**
	 * Get the 游戏信息.
	 * 
	 * @return 游戏信息
	 */
	public String getGameinfo() {
		return this.gameinfo;
	}

	/**
	 * Set the 游戏大类.
	 * 
	 * @param gamebigtype
	 *            游戏大类
	 */
	public void setGamebigtype(String gamebigtype) {
		this.gamebigtype = gamebigtype;
	}

	/**
	 * Get the 游戏大类.
	 * 
	 * @return 游戏大类
	 */
	public String getGamebigtype() {
		return this.gamebigtype;
	}

	/**
	 * Set the 游戏历史名称.
	 * 
	 * @param history
	 *            游戏历史名称
	 */
	public void setHistory(String history) {
		this.history = history;
	}

	/**
	 * Get the 游戏历史名称.
	 * 
	 * @return 游戏历史名称
	 */
	public String getHistory() {
		return this.history;
	}

	/**
	 * Set the 完成信息.
	 * 
	 * @param isroundfinished
	 *            完成信息
	 */
	public void setIsroundfinished(String isroundfinished) {
		this.isroundfinished = isroundfinished;
	}

	/**
	 * Get the 完成信息.
	 * 
	 * @return 完成信息
	 */
	public String getIsroundfinished() {
		return this.isroundfinished;
	}

	/**
	 * Set the 下注时间.
	 * 
	 * @param time
	 *            下注时间
	 */
	public void setTime(Date time) {
		this.time = time;
	}

	/**
	 * Get the 下注时间.
	 * 
	 * @return 下注时间
	 */
	public Date getTime() {
		return this.time;
	}

	/**
	 * Set the 用户名.
	 * 
	 * @param userid
	 *            用户名
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * Get the 用户名.
	 * 
	 * @return 用户名
	 */
	public String getUserid() {
		return this.userid;
	}

	/**
	 * Set the 数据生成时间.
	 * 
	 * @param createtime
	 *            数据生成时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	/**
	 * Get the 数据生成时间.
	 * 
	 * @return 数据生成时间
	 */
	public Date getCreatetime() {
		return this.createtime;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tid == null) ? 0 : tid.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		BettingKrAv other = (BettingKrAv) obj;
		if (tid == null) {
			if (other.tid != null) {
				return false;
			}
		} else if (!tid.equals(other.tid)) {
			return false;
		}
		return true;
	}

}
