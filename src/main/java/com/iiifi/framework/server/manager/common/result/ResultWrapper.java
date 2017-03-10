package com.iiifi.framework.server.manager.common.result;

import java.util.Map;

import com.google.common.collect.Maps;
import com.iiifi.framework.server.manager.common.mapper.JsonMapper;

/**
 * 单例实现返回结果封装
 */
public class ResultWrapper {

    private final static String WRAPPER_DATAS_KEY = "datas";
    private final static String WRAPPER_CODE_KEY = "code";
    private final static String WRAPPER_MSG_KEY = "message";


    private String code = ResultConstant.APP_RETURN_SUCESS;
    private String message = "success";
    private Object datas = null;

    private static ResultWrapper instance = new ResultWrapper();

    public static ResultWrapper getInstance() {
        instance.setCode(ResultConstant.APP_RETURN_SUCESS);
        instance.setMessage(ResultConstant.APP_RETURN_SUCESS_MESSAGE);
        instance.setDatas(null);
        return instance;
    }

    private ResultWrapper() {
    }

    /**
     * 获取返回后的json
     * @return
     * 2014年11月4日
     */
    public String getResultJson() {
        Map<String, Object> map = Maps.newLinkedHashMap();
        map.put(WRAPPER_CODE_KEY, code);
        map.put(WRAPPER_MSG_KEY, message);
        if(datas != null){
            map.put(WRAPPER_DATAS_KEY, datas);
        }
        return JsonMapper.toJsonString(map);
    }

    public Map<String, Object> getResultMap(){
        Map<String, Object> map = Maps.newLinkedHashMap();
        map.put(WRAPPER_CODE_KEY, code);
        map.put(WRAPPER_MSG_KEY, message);
        if(datas != null){
            map.put(WRAPPER_DATAS_KEY, datas);
        }
        return map;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getDatas() {
        return datas;
    }

    public void setDatas(Object datas) {
        this.datas = datas;
    }
}
