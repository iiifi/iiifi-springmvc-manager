package com.iiifi.framework.server.manager.modules.send;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iiifi.framework.server.manager.common.config.Global;
import com.iiifi.framework.server.manager.common.result.ResultConstant;
import com.iiifi.framework.server.manager.common.result.ResultWrapper;
import com.iiifi.framework.server.manager.common.utils.NumberUtils;
import com.iiifi.framework.server.manager.common.utils.SendMailUtil;
import com.iiifi.framework.server.manager.common.web.BaseController;
import com.iiifi.framework.server.manager.modules.send.entity.SendCodeBean;


/**
 * 短信服务controller
 *
 */
@Controller
@RequestMapping(value="${sysApi}/sms")
public class SendCodeController extends BaseController{

	/**
	 * 发送验证码验证码接口
	 * @param bizcode 业务id，可以是登录验证码，注册验证码，忘记密码验证码等 {register, resetLoginPwd,resetPayPwd}
	 * @param tel
	 * @return
	 */
	@RequestMapping(value = "sendCode")
	@ResponseBody
	public String sendCode(
			@RequestParam(value="bizcode") String bizcode, 
			@RequestParam(value="loginName") String loginName){
		ResultWrapper resultWrapper = ResultWrapper.getInstance();
		SendCodeBean sendCode = null;
		sendCode = SendCodeCache.getSMSCache(loginName,bizcode);
		boolean newSendCode = false; //是否需要重新发送新的验证码的标识，超时需要重新发送
		String code = null;
		if (sendCode != null) {
			if(System.currentTimeMillis() > (sendCode.getStartTime() + sendCode.getVailTime())){//如果超时，重新发送
				newSendCode = true;
			} else {
				code = sendCode.getSmscode();
			}
		} else {
			newSendCode = true;
		}
		if (newSendCode) {
			SendCodeCache.delSMSCache(loginName,bizcode);
			sendCode = new SendCodeBean();
			sendCode.setBizcode(bizcode);
			sendCode.setTel(loginName);
			sendCode.setStartTime(System.currentTimeMillis());
			sendCode.setVailTime((long) 300000);//设置有效时间五分钟
			code = NumberUtils.generateSixShortMsgCode();
			sendCode.setSmscode(code);
			sendCode.setSmscontent("");
			SendCodeCache.setSMSCache(sendCode);
		}
		//TODO 后期加上短信模版管理功能，与actionType挂上，签名已报备的签名为准，不变
		String smsCodeTemplate = Global.getConfig("sms.smscode.template");
		String content = smsCodeTemplate.replace("smscode", code);
		if(loginName!=null&&loginName.lastIndexOf("@")>0){
			SendMailUtil.sendCommonMail(loginName, "大捷国际导航网站注册验证码", "欢迎您注册大捷国际导航网站<br/>您的注册验证码为:"+code+"!");
			resultWrapper.setCode(ResultConstant.APP_RETURN_SUCESS);
			resultWrapper.setMessage("验证码已发送至您的邮箱："+loginName+"!请注意查收");
		}else if(loginName!=null&&loginName.length()==11){
			if(SendCodeUtils.sendSMS(loginName, content)){
				logger.debug("给 {} 用户发送短信成功，短信内容 {}", loginName,content);
				resultWrapper.setCode(ResultConstant.APP_RETURN_SUCESS);
				resultWrapper.setMessage("短信验证码已发送至"+loginName.substring(0, 3)+"****"+loginName.substring(8,11)+"!请注意查收");
			} else {
				//若发送失败尝试重新发送一次
				if(SendCodeUtils.sendSMS(loginName, content)){
					resultWrapper.setCode(ResultConstant.APP_RETURN_SUCESS);
					resultWrapper.setMessage("短信验证码已发送至"+loginName.substring(0, 3)+"****"+loginName.substring(8,11));
				} else {
					resultWrapper.setCode(ResultConstant.APP_RETURN_EXCEPTION);
					resultWrapper.setMessage("短信发送失败，请重新尝试！");
				}
			}
		}
		return resultWrapper.getResultJson();
	}
}
