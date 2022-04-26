package com.cloud.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cloud.client.service.DynamicConfigService;
import com.cloud.client.service.StaticConfigService;

@RestController
public class ConfigController {

	private final StaticConfigService staticConfigService;
	private final DynamicConfigService dynamicConfigService;
	
	public ConfigController(StaticConfigService staticConfigService, DynamicConfigService dynamicConfigService) {
		this.staticConfigService = staticConfigService;
		this.dynamicConfigService = dynamicConfigService;
	}
	
	@GetMapping("/static")
	public Object getConfigFromStatic() {
		return staticConfigService.getConfig();
	}
	
	@GetMapping("/dynamic")
	public Object getConfigFromDynamic() {
		return dynamicConfigService.getConfig();
	}
	
	@Value("${spring.datasource.url}")
	private String datasourceUrl;
	
	@GetMapping("/test")
	public String getDataSourceUrl() {
		return datasourceUrl;
	}
	
	
}
