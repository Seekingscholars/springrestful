package com.cn.core.sms.entity;

import javax.persistence.Entity;


/**
 * 短信验证码
 */
@Entity
public class AuthCode {
	
	/**手机号*/
	private String 	mobileTel;
	/**验证码*/
	private String 	authCode;
	/**发送时间*/
	private String 	sendTime;
	/**到期（分钟）*/
	private Integer	expires;
	/**是否已经验证过(默认false，验证成功后改为true)*/
	private Boolean	used;
	/**验证时间*/
	private String 	usedTime;
	/**验证码类型*/
	private Integer	path;
	/**流水号*/
	private String 	serialNumber;
	/**短信内容*/
	private String 	smsContent;
	/**客户端IP*/
	private String 	clientIp;
	
	public String getMobileTel() {
		return mobileTel;
	}
	public void setMobileTel(String mobileTel) {
		this.mobileTel = mobileTel;
	}
	public String getAuthCode() {
		return authCode;
	}
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public Boolean getUsed() {
		return used;
	}
	public void setUsed(Boolean used) {
		this.used = used;
	}
	public String getUsedTime() {
		return usedTime;
	}
	public void setUsedTime(String usedTime) {
		this.usedTime = usedTime;
	}
	public Integer getPath() {
		return path;
	}
	public void setPath(Integer path) {
		this.path = path;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public Integer getExpires() {
		return expires;
	}
	public void setExpires(Integer expires) {
		this.expires = expires;
	}
	public String getSmsContent() {
		return smsContent;
	}
	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}
	public String getClientIp() {
		return clientIp;
	}
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
	@Override
	public String toString() {
		return "AuthCode [mobileTel=" + mobileTel + ", authCode=" + authCode + ", sendTime=" + sendTime + ", expires="
				+ expires + ", used=" + used + ", usedTime=" + usedTime + ", path=" + path + ", serialNumber="
				+ serialNumber + ", smsContent=" + smsContent + ", clientIp=" + clientIp + "]";
	}

}
