package com.iiifi.framework.server.manager.modules.send;

import com.iiifi.framework.server.manager.common.mapper.JsonMapper;
import com.iiifi.framework.server.manager.common.utils.JedisUtils;
import com.iiifi.framework.server.manager.modules.send.entity.SendCodeBean;


public class SendCodeCache {

	private static final String SMS_CACHE_KEY = "smscode";
	
	/**
	 * 注册标志
	 */
	public static final String SMS_REGISTER_CODE = "register";
	/**
	 * 忘记密码标志
	 */
	public static final String SMS_RESET_LOGIN_PWD_CODE = "resetLoginPwd";
	/**
	 * 支付密码标志
	 */
	public static final String SMS_RESET_PAY_PWD_CODE = "resetPayPwd";
	/**
	 * 设置缓存
	 * @param sms
	 */
	public static void setSMSCache(SendCodeBean sendCode){
		JedisUtils.hset(SMS_CACHE_KEY, sendCode.getBizcode() + sendCode.getTel(), sendCode);
	}
	
	/**
	 * 获取缓存
	 * @param tel
	 * @return
	 */
	public static SendCodeBean getSMSCache(String tel,String bizcode){
		String smscache = JedisUtils.hget(SMS_CACHE_KEY, bizcode + tel);
		if (smscache == null || "".equals(smscache)) {
			return null;
		}
		return (SendCodeBean) JsonMapper.fromJsonString(smscache, SendCodeBean.class);
//		return (SMSBean) JSONUtils.parseJson2Object(smscache, SMSBean.class);
	}
	
	/**
	 * 删除缓存
	 * @param tel
	 */
	public static void delSMSCache(String tel,String bizcode){
		JedisUtils.hdel(SMS_CACHE_KEY, bizcode + tel);
	}
}
