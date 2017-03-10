package com.iiifi.framework.server.manager.modules.send;

/**
 * 短信协议接口
 *
 */
public interface SendCode {
	
	/**
	 * 发送短信
	 * @param tel 手机号
	 * @param content 短信内容
	 * @return
	 */
	public String send(String tel, String content);

}
