package com.amaris.tech.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:dummysvc.properties")
@ConfigurationProperties(prefix = "employees.service")
public class DummyServiceProperties {
	
	private String apiBaseURL;
	private String apiPathGetEmployees;
	private String apiPathGetEmployee;
	
	public String getApiBaseURL() {
		return apiBaseURL;
	}
	public void setApiBaseURL(String apiBaseURL) {
		this.apiBaseURL = apiBaseURL;
	}
	public String getApiPathGetEmployees() {
		return apiBaseURL + apiPathGetEmployees;
	}
	public void setApiPathGetEmployees(String apiPathGetEmployees) {
		this.apiPathGetEmployees = apiPathGetEmployees;
	}
	public String getApiPathGetEmployee() {
		return apiBaseURL + apiPathGetEmployee;
	}
	public void setApiPathGetEmployee(String apiPathGetEmployee) {
		this.apiPathGetEmployee = apiPathGetEmployee;
	}
	
	
	

}
