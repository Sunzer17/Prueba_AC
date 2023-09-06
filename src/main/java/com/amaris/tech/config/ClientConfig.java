package com.amaris.tech.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.jayway.jsonpath.spi.json.JacksonJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;

@Configuration
public class ClientConfig {
	
	@Bean
	public RestTemplate initializeRestTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public com.jayway.jsonpath.Configuration initializeJsonParser(){
		return com.jayway.jsonpath.Configuration.builder().mappingProvider(new JacksonMappingProvider())
				.jsonProvider(new JacksonJsonProvider()).build();
	}

}
