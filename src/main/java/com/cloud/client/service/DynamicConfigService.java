package com.cloud.client.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@Service
@RefreshScope
public class DynamicConfigService {
	
	@Value("${spring.datasource.url}")
	private String datasourceUrl;
	
	@Value("${spring.datasource.username}")
	private String datasourceUsername;
	
	@Value("${spring.datasource.password}")
	private String datasourcePassword;
	
	public Map<String, Object> getConfig() {
		Map<String, Object> configMap = new HashMap<>();
		
		configMap.put("datasourceUsername"	, datasourceUsername);
		configMap.put("datasourceUrl"		, datasourceUrl);
		configMap.put("datasourcePassword"	, datasourcePassword);
		
		return configMap;
	}
}