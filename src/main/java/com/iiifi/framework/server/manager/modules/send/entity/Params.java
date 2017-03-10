package com.iiifi.framework.server.manager.modules.send.entity;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Params {
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	private Map<String, String> data = new LinkedHashMap<String, String>();
	private Params() {}
	
	public static Params create() {
		return new Params();
	}
	
	public static Params create(String key, String value) {
		return create().put(key, value);
	}
	
	public Params put(String key, String value) {
		data.put(key, value);
		return this;
	}
	
	public Map<String, String> getDataMap() {
		return data;
	}
	
	public String getDataJson() throws JsonGenerationException, JsonMappingException, IOException{
		return objectMapper.writeValueAsString(data);
	}
}
