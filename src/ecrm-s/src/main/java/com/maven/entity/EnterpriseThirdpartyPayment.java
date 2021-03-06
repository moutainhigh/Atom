package com.maven.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Model class of enterprise_thirdparty_payment.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class EnterpriseThirdpartyPayment implements Serializable {
	
	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** 企业第三方支付编码. */
	private String enterprisethirdpartycode;

	/** 账号描述. */
	private String dscription;
	
	/** 显示名称. */
	private String displayname;

	/** 企业编码. */
	private String enterprisecode;
	
	/** 企业名称. */
	private String enterprisename;

	/** 第三方支付类型编码. */
	private String thirdpartypaymenttypecode;

	/** PC状态（1：启用 2：禁用). */
	private String status;
	
	/** H5状态（1：启用 2：禁用）*/
	private String h5status;
	
	/** 是否为默认出款卡（0：否  1：是). */
	private String isdefualttakecard;
	
	/** 当前余额 */
	private BigDecimal currentbalance;

	/** 数据状态. */
	private String datastatus;
	
	/** 是否启用银行卡支付，默认启用.（如有） */
	private Boolean isbanks;
	/** 是否启用微信支付，默认启用. （如有）*/
	private Boolean isweixin;
	/** 是否启用支付宝支付，默认启用. （如有）*/
	private Boolean iszhifubao;
	
	/** 最小充值金额，默认0 */
	private BigDecimal minmoney;
	/** 最大充值金额 ，默认0，表示无上限*/
	private BigDecimal maxmoney;
	
	/**
	 * 排序，升序
	 */
	private String ord;
	
	/**
	 * 支付域名
	 */
	private String callbackurl;
	
	
	/* 关联属性：第三方支付类型名称. */
	private String thirdpartypaymenttypename;
	
	/* 组织对象：第三方支付支持银行	 */
	private List<ThirdpartyPaymentBank> banks;
	
	//支付域名（旧的，弃用）
	private String paycallbackurl;

	/**
	 * Constructor.
	 */
	public EnterpriseThirdpartyPayment() {
	}
	
	
	
	public enum Enum_status{
		启用("1","启用"),
		禁用("2","禁用");
		public String value;
		public String desc;
		private Enum_status(String value ,String desc) {
        	this.value = value;
        	this.desc = desc;
        }
	}
	
	public enum Enum_isdefualttakecard{
		是("1","是"),
		否("0","否");
		public String value;
		public String desc;
		private Enum_isdefualttakecard(String value ,String desc) {
        	this.value = value;
        	this.desc = desc;
        }
	}
	
	public enum Enum_type{
		PC("PC","PC端支付"),
		H5("H5","H5端支付");
		public String value;
		public String desc;
		private Enum_type(String value ,String desc) {
        	this.value = value;
        	this.desc = desc;
        }
	}
	
	public String getIsdefualttakecard() {
		return isdefualttakecard;
	}

	public void setIsdefualttakecard(String isdefualttakecard) {
		this.isdefualttakecard = isdefualttakecard;
	}
	
	public String getThirdpartypaymenttypename() {
		return thirdpartypaymenttypename;
	}

	public void setThirdpartypaymenttypename(String thirdpartypaymenttypename) {
		this.thirdpartypaymenttypename = thirdpartypaymenttypename;
	}
	
	public String getEnterprisename() {
		return enterprisename;
	}

	public void setEnterprisename(String enterprisename) {
		this.enterprisename = enterprisename;
	}

	/**
	 * Set the 企业第三方支付编码.
	 * 
	 * @param enterprisethirdpartycode
	 *            企业第三方支付编码
	 */
	public void setEnterprisethirdpartycode(String enterprisethirdpartycode) {
		this.enterprisethirdpartycode = enterprisethirdpartycode;
	}

	/**
	 * Get the 企业第三方支付编码.
	 * 
	 * @return 企业第三方支付编码
	 */
	public String getEnterprisethirdpartycode() {
		return this.enterprisethirdpartycode;
	}

	/**
	 * Set the 账号描述.
	 * 
	 * @param dscription
	 *            账号描述
	 */
	public void setDscription(String dscription) {
		this.dscription = dscription;
	}

	/**
	 * Get the 账号描述.
	 * 
	 * @return 账号描述
	 */
	public String getDscription() {
		return this.dscription;
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
	 * Set the 第三方支付类型编码.
	 * 
	 * @param thirdpartypaymenttypecode
	 *            第三方支付类型编码
	 */
	public void setThirdpartypaymenttypecode(String thirdpartypaymenttypecode) {
		this.thirdpartypaymenttypecode = thirdpartypaymenttypecode;
	}

	/**
	 * Get the 第三方支付类型编码.
	 * 
	 * @return 第三方支付类型编码
	 */
	public String getThirdpartypaymenttypecode() {
		return this.thirdpartypaymenttypecode;
	}

	public BigDecimal getCurrentbalance() {
		return currentbalance;
	}

	public void setCurrentbalance(BigDecimal currentbalance) {
		this.currentbalance = currentbalance;
	}

	/**
	 * Set the 状态（1：启用 2：禁用).
	 * 
	 * @param status
	 *            状态（1：启用 2：禁用)
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Get the 状态（1：启用 2：禁用).
	 * 
	 * @return 状态（1：启用 2：禁用)
	 */
	public String getStatus() {
		return this.status;
	}

	public String getH5status() {
		return h5status;
	}
	/**
	 * Get the 状态（1：启用 2：禁用).
	 * 
	 * @return 状态（1：启用 2：禁用)
	 */
	public void setH5status(String h5status) {
		this.h5status = h5status;
	}

	/**
	 * Set the 数据状态.
	 * 
	 * @param datastatus
	 *            数据状态
	 */
	public void setDatastatus(String datastatus) {
		this.datastatus = datastatus;
	}

	/**
	 * Get the 数据状态.
	 * 
	 * @return 数据状态
	 */
	public String getDatastatus() {
		return this.datastatus;
	}

	public List<ThirdpartyPaymentBank> getBanks() {
		return banks;
	}

	public void setBanks(List<ThirdpartyPaymentBank> banks) {
		this.banks = banks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datastatus == null) ? 0 : datastatus.hashCode());
		result = prime * result + ((dscription == null) ? 0 : dscription.hashCode());
		result = prime * result + ((enterprisecode == null) ? 0 : enterprisecode.hashCode());
		result = prime * result + ((enterprisename == null) ? 0 : enterprisename.hashCode());
		result = prime * result + ((enterprisethirdpartycode == null) ? 0 : enterprisethirdpartycode.hashCode());
		result = prime * result + ((isdefualttakecard == null) ? 0 : isdefualttakecard.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((thirdpartypaymenttypecode == null) ? 0 : thirdpartypaymenttypecode.hashCode());
		result = prime * result + ((thirdpartypaymenttypename == null) ? 0 : thirdpartypaymenttypename.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnterpriseThirdpartyPayment other = (EnterpriseThirdpartyPayment) obj;
		if (datastatus == null) {
			if (other.datastatus != null)
				return false;
		} else if (!datastatus.equals(other.datastatus))
			return false;
		if (dscription == null) {
			if (other.dscription != null)
				return false;
		} else if (!dscription.equals(other.dscription))
			return false;
		if (enterprisecode == null) {
			if (other.enterprisecode != null)
				return false;
		} else if (!enterprisecode.equals(other.enterprisecode))
			return false;
		if (enterprisename == null) {
			if (other.enterprisename != null)
				return false;
		} else if (!enterprisename.equals(other.enterprisename))
			return false;
		if (enterprisethirdpartycode == null) {
			if (other.enterprisethirdpartycode != null)
				return false;
		} else if (!enterprisethirdpartycode.equals(other.enterprisethirdpartycode))
			return false;
		if (isdefualttakecard == null) {
			if (other.isdefualttakecard != null)
				return false;
		} else if (!isdefualttakecard.equals(other.isdefualttakecard))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (thirdpartypaymenttypecode == null) {
			if (other.thirdpartypaymenttypecode != null)
				return false;
		} else if (!thirdpartypaymenttypecode.equals(other.thirdpartypaymenttypecode))
			return false;
		if (thirdpartypaymenttypename == null) {
			if (other.thirdpartypaymenttypename != null)
				return false;
		} else if (!thirdpartypaymenttypename.equals(other.thirdpartypaymenttypename))
			return false;
		return true;
	}

	public String getPaycallbackurl() {
		return paycallbackurl;
	}

	public void setPaycallbackurl(String paycallbackurl) {
		this.paycallbackurl = paycallbackurl;
	}

	public String getDisplayname() {
		return displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	public Boolean getIsbanks() {
		return isbanks;
	}

	public void setIsbanks(Boolean isbanks) {
		this.isbanks = isbanks;
	}

	public Boolean getIsweixin() {
		return isweixin;
	}

	public void setIsweixin(Boolean isweixin) {
		this.isweixin = isweixin;
	}

	public Boolean getIszhifubao() {
		return iszhifubao;
	}

	public void setIszhifubao(Boolean iszhifubao) {
		this.iszhifubao = iszhifubao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public BigDecimal getMinmoney() {
		return minmoney;
	}

	public void setMinmoney(BigDecimal minmoney) {
		this.minmoney = minmoney;
	}

	public BigDecimal getMaxmoney() {
		return maxmoney;
	}

	public void setMaxmoney(BigDecimal maxmoney) {
		this.maxmoney = maxmoney;
	}

	public String getOrd() {
		return ord;
	}

	public void setOrd(String ord) {
		this.ord = ord;
	}

	public String getCallbackurl() {
		return callbackurl;
	}

	public void setCallbackurl(String callbackurl) {
		this.callbackurl = callbackurl;
	}

	

}
