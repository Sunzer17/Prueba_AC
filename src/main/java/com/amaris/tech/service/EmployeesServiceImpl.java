package com.amaris.tech.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.amaris.tech.model.Employee;
import com.amaris.tech.properties.DummyServiceProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.TypeRef;

@Service
public class EmployeesServiceImpl implements EmployeesService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	DummyServiceProperties dummyServiceProperties;
	
	@Autowired
	Configuration configurationJsonParser;
	
	private static TypeRef<Employee> employeetypeRef = new TypeRef<Employee>(){};
	private static TypeRef<List<Employee>> employeeListTypeRef = new TypeRef<List<Employee>>(){};

	@Override
	public List<Employee> listEmployees() {
		String apiResponse = restTemplate.exchange(dummyServiceProperties.getApiPathGetEmployees(),HttpMethod.GET,buildHttpEntity(),String.class).getBody();
		return JsonPath.using(configurationJsonParser).parse(apiResponse).read("$['data']",employeeListTypeRef);
	}
	
	@Override
	public Employee getEmployee(Integer id) throws  JsonProcessingException {
		String apiResponse = restTemplate.exchange(dummyServiceProperties.getApiPathGetEmployee(),HttpMethod.GET,buildHttpEntity(),String.class,id).getBody();
		return JsonPath.using(configurationJsonParser).parse(apiResponse).read("$['data']",employeetypeRef);
	}
	
	private HttpEntity<String> buildHttpEntity() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		return new HttpEntity<>(headers);
	}

}
