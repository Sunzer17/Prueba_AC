package com.amaris.tech;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.amaris.tech.model.Employee;
import com.amaris.tech.properties.DummyServiceProperties;
import com.amaris.tech.service.EmployeesService;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	EmployeesService employeesService;

	@Autowired
	DummyServiceProperties dummyServiceProperties;

	@MockBean
	RestTemplate restTemplate;

	private static final String API_DUMMY_RESPONSE_ALL_BODY_PATH = "src/test/resources/DummyAPI/GetAll.json";
	private static final String API_DUMMY_RESPONSE_ONE_BODY_PATH = "src/test/resources/DummyAPI/GetOne.json";

	@Test
	void getAllEmployeesTest() throws IOException {
		String apiResponseBody = new String(Files.readAllBytes(Paths.get(API_DUMMY_RESPONSE_ALL_BODY_PATH)));
		Mockito.when(restTemplate.exchange(Mockito.eq(dummyServiceProperties.getApiPathGetEmployees()),
				Mockito.eq(HttpMethod.GET), Mockito.any(HttpEntity.class), Mockito.eq(String.class)))
				.thenReturn(new ResponseEntity<String>(apiResponseBody, HttpStatus.OK));
		List<Employee> employees = employeesService.listEmployees();
		Assertions.assertEquals(7, employees.size());

	}

	@Test
	void getEmployeeTest() throws IOException {
		String apiResponseBody = new String(Files.readAllBytes(Paths.get(API_DUMMY_RESPONSE_ONE_BODY_PATH)));
		Mockito.when(restTemplate.exchange(Mockito.eq(dummyServiceProperties.getApiPathGetEmployee()),
				Mockito.eq(HttpMethod.GET), Mockito.any(HttpEntity.class), Mockito.eq(String.class), Mockito.anyInt()))
				.thenReturn(new ResponseEntity<String>(apiResponseBody, HttpStatus.OK));
		Employee employees = employeesService.getEmployee(1);
		Assertions.assertEquals(1, employees.getIdentifier());

	}

}
