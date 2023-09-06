package com.amaris.tech.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.amaris.tech.model.Employee;
import com.amaris.tech.service.EmployeesService;
import com.fasterxml.jackson.core.JsonProcessingException;

@Controller
@RequestMapping(path = "/employees")
public class EmployeesController {

	@Autowired
	EmployeesService employeesService;

	private static final String HTML_FILE = "employees.html";

	@GetMapping
	public String showEmployeesPage() {
		return HTML_FILE;
	}

	@GetMapping("list")
	public String listEmployees(Model model) {
		model.addAttribute("listEmp", employeesService.listEmployees());
		return HTML_FILE;
	}

	@GetMapping("get")
	public String getEmployees(Model model, @RequestParam(name = "employeeId", defaultValue = "-1") Integer id)
			throws JsonProcessingException {
		List<Employee> employees = new ArrayList<>();
		if (id == -1) {
			employees.addAll(employeesService.listEmployees());
		} else {
			Employee employee = employeesService.getEmployee(id);
			if (employee != null) {
				employees.add(employee);
			}
		}
		model.addAttribute("listEmp", employees);
		return HTML_FILE;
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public String handleInputError(Model model) {
		model.addAttribute("listEmp", new ArrayList<>());
		model.addAttribute("messageError", "El Id Ingresado no es Valido");
		return HTML_FILE;
	}

	@ExceptionHandler(Exception.class)
	public String handleErrors(Model model) {
		model.addAttribute("messageError", "Ha sucedio un error. Intente mas tarde");
		return HTML_FILE;
	}

}
