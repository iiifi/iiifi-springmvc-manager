package com.iiifi.framework.server.manager.modules.send.impl;

import org.springframework.stereotype.Component;

import com.iiifi.framework.server.manager.common.config.Global;
import com.iiifi.framework.server.manager.common.utils.HttpKitUtils;
import com.iiifi.framework.server.manager.modules.send.SendCode;
import com.iiifi.framework.server.manager.modules.send.entity.Params;


/**
 * 创蓝短信通道
 * @author vill
 *
 */
@Component("smsImpl")
public class RBPSmsImpl implements SendCode{
	
	protected static final String SMS_URL = Global.getConfig("sms.sms_url");
	protected static final String SMS_ACCOUNT = Global.getConfig("sms.sms_account");
	protected static final String SMS_PASSWORD = Global.getConfig("sms.sms_pwd");
	protected static final String USERID = Global.getConfig("sms.sms.userid");
	/**
	 * demo
	 * http://222.73.117.158/msg/HttpBatchSendSM?
	 * account=jiekou-cs-01
	 * &pswd=Tch147256
	 * &mobile=13482416860
	 * &msg=【创蓝文化】您的注册验证码是：1131.请完成注册
	 * &needstatus=true
	 */
	@Override
	public String send(String tel, String content) {
		Params params = Params.create();
		params.put("action", "send");
		params.put("userid", USERID);
		params.put("account", SMS_ACCOUNT);
		params.put("password", SMS_PASSWORD);
		params.put("mobile", tel);
		params.put("content", content);
		String resp = HttpKitUtils.get(SMS_URL, params.getDataMap());
		return resp;
	}

}
