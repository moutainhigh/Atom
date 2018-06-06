package com.maven.payment.lfdf;

/**
 * 乐付代付
 * @author Administrator
 *
 */
public class LfDFMerchantConfig {

	/**
	 * 存款交易请求地址
	 */
	private String payUrl;
	/**
	 * 商户号
	 */
	private String merNo;
	/**
	 * 商户密钥
	 */
	private String merKey;
	
	/**
	 * 商户公钥
	 */
	private String merPubKey;
	
	/**
	 * 乐付公钥
	 */
	private String pubKey;
	
	/**
	 * 商户接收支付成功数据的地址
	 */
	private String notiUrl;
	
	
	private String inputCharset = "UTF-8";

	public LfDFMerchantConfig() {
		super();
		// TODO Auto-generated constructor stub
	}


	public LfDFMerchantConfig(String payUrl, String merNo, String merKey, String merPubKey, String pubKey, String md5Key,
			String notiUrl) {
		super();
		this.payUrl = payUrl;
		this.merNo = merNo;
		this.merKey = merKey;
		this.merPubKey = merPubKey;
		this.pubKey = pubKey;
		this.notiUrl = notiUrl;
	}


	public String getPayUrl() {
		return payUrl;
	}

	public void setPayUrl(String payUrl) {
		this.payUrl = payUrl;
	}

	public String getMerNo() {
		return merNo;
	}

	public void setMerNo(String merNo) {
		this.merNo = merNo;
	}

	public String getMerKey() {
		return merKey;
	}

	public void setMerKey(String merKey) {
		this.merKey = merKey;
	}

	public String getNotiUrl() {
		return notiUrl;
	}

	public void setNotiUrl(String notiUrl) {
		this.notiUrl = notiUrl;
	}


	public String getInputCharset() {
		return inputCharset;
	}

	public void setInputCharset(String inputCharset) {
		this.inputCharset = inputCharset;
	}

	public String getMerPubKey() {
		return merPubKey;
	}

	public void setMerPubKey(String merPubKey) {
		this.merPubKey = merPubKey;
	}

	public String getPubKey() {
		return pubKey;
	}

	public void setPubKey(String pubKey) {
		this.pubKey = pubKey;
	}

	
	
}
