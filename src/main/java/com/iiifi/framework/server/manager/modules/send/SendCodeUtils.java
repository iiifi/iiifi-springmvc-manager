package com.iiifi.framework.server.manager.modules.send;

import com.iiifi.framework.server.manager.common.utils.SpringContextHolder;

/**
 * 发送短信的工具类
 * 
 * @author vill
 *
 */
public class SendCodeUtils {

	public static SendCode sms = null;

	public static final String SMS_SERVICE = "smsImpl";

	public static boolean sendSMS(String tel, String content) {
		if (sms == null) {
			sms = SpringContextHolder.getBean(SMS_SERVICE);
		}
		String resp = sms.send(tel, content);
		if(resp.indexOf("Success")>0){
			return true;
		}else {
			return false;
		}
	}
}
