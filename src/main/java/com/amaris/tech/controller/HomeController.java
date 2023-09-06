package com.amaris.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.amaris.tech.service.EmployeesService;

@Controller
public class HomeController {
	
	@Autowired
	EmployeesService employeesService;
	
	@GetMapping
	public String listEmployees(Model model) {
		return "index.html";
	}

}
