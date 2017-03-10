package com.iiifi.framework.server.manager.common.utils;

import com.iiifi.framework.server.manager.common.config.Global;

/**
 * 密码验证
 * @author birkhoffliu
 *
 */
public class EncryptionUtil {
	
	public static final String secretValue = Global.getConfig("password.secret");
	
	/**
	 * @param password 输入的密码
	 * @param mdPassword 库中保存的密码
	 * @return
	 */
	public static boolean compareSHA(String password,String mdPassword){
//		String secretValue = Global.getConfig("secret_key");////盐值
		password = MD5Util.MD5(password + "_" + secretValue);
		if(password.equals(mdPassword)){
			return true;
		}
		return false;
	}
	/**
	 * 生成密码平台默认密码
	 * @return
	 */
	public static String productSHA(){
//		String secretValue = Global.getConfig("secret_key");//盐值
		String password = Global.getConfig("password.default");//配置的默密码
		return MD5Util.MD5(password.trim() + "_" + secretValue).trim();
	}
	/**
	 * 生成密码平台默认
	 * @return
	 */
	public static String productSHA(String password){
//		String secretValue = Global.getConfig("secret_key");//盐值
		return MD5Util.MD5(password.trim() + "_" + secretValue).trim();
	}
	
}
