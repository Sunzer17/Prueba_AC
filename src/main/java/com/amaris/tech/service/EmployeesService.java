package com.amaris.tech.service;

import java.util.List;

import com.amaris.tech.model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public interface EmployeesService {
	
	List<Employee> listEmployees();

	Employee getEmployee(Integer id) throws JsonMappingException, JsonProcessingException;

}
