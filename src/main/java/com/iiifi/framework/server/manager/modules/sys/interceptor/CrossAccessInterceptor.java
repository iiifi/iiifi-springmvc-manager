package com.iiifi.framework.server.manager.modules.sys.interceptor;

import com.iiifi.framework.server.manager.common.config.Global;
import com.iiifi.framework.server.manager.common.service.BaseService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.OutputStream;

/**
 * 跨域请求拦截器
 */
public class CrossAccessInterceptor extends BaseService implements HandlerInterceptor {

    private static final boolean allowCrossAccess = Boolean.parseBoolean(Global.getConfig("allowCrossAccess"));

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //解决跨域请求时，触发回调函数
        if (allowCrossAccess){
            String callback = request.getParameter("callback");
            if(StringUtils.isNotEmpty(callback)){
                response.setContentType("application/json; charset=UTF-8");
                response.setContentType("application/javascript");
                logger.debug(request.getRemoteAddr() + "success respones callback: " + callback + " start");
                response.getOutputStream().write(new String(callback + "(").getBytes("UTF-8"));
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        if (allowCrossAccess){
            String callback = request.getParameter("callback");
            if(StringUtils.isNotEmpty(callback)){
                OutputStream out = response.getOutputStream();
                out.write(");".getBytes("UTF-8"));
                logger.debug(request.getRemoteAddr() + "success respones callback: " + callback + " end");
                out.flush();
                out.close();
            }
        }
    }
}
