package com.iiifi.framework.server.manager.modules.send.entity;

/**
 * 短信实体类
 */
public class SendCodeBean {
	
	private String tel;
	private String bizcode;
	private String smscode; //短信验证码
	private String smscontent; // 短信内容
	private Long startTime;
	private Long vailTime;
	
	public Long getStartTime() {
		return startTime;
	}
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
	public Long getVailTime() {
		return vailTime;
	}
	public void setVailTime(Long vailTime) {
		this.vailTime = vailTime;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getBizcode() {
		return bizcode;
	}
	public void setBizcode(String bizcode) {
		this.bizcode = bizcode;
	}
	public String getSmscode() {
		return smscode;
	}
	public void setSmscode(String smscode) {
		this.smscode = smscode;
	}
	public String getSmscontent() {
		return smscontent;
	}
	public void setSmscontent(String smscontent) {
		this.smscontent = smscontent;
	}
}
