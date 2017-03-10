package com.iiifi.framework.server.manager.modules.send.impl;

import com.iiifi.framework.server.manager.common.config.Global;
import com.iiifi.framework.server.manager.common.utils.HttpKitUtils;
import com.iiifi.framework.server.manager.modules.send.SendCode;
import com.iiifi.framework.server.manager.modules.send.entity.Params;



/**
 * 和信通 短信发送实现类
 */
public class HXTSmsImpl implements SendCode {
	
	protected static final String SMS_URL = Global.getConfig("sms.sms_url");
	protected static final String SMS_ACTION = Global.getConfig("sms.sms_action");
	protected static final String SMS_USERID = Global.getConfig("sms.sms_userid");
	protected static final String SMS_ACCOUNT = Global.getConfig("sms.sms_account");
	protected static final String SMS_PASSWORD = Global.getConfig("sms.sms_pwd");
	
	/**
	 * Demo 
	 * http://123.57.51.191:8888/sms.aspx?action=send&userid=用户ID号
	 * &account=登陆账号&password=登陆密码&mobile=13900000000,13911111111&
	 * content=短信内容&sendTime=&extno=
	 */
	@Override
	public String send(String tel, String content) {
		Params params = Params.create();
		params.put("action", SMS_ACTION);
		params.put("userid", SMS_USERID);
		params.put("account", SMS_ACCOUNT);
		params.put("password", SMS_PASSWORD);
		params.put("mobile", tel);
		params.put("content", content);
		params.put("sendTime", "");
		params.put("extno", "");
		String resp = HttpKitUtils.post(SMS_URL, params.getDataMap());
		return resp;
	}

}
