package com.amaris.tech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ExceptionController {

	@ExceptionHandler(Exception.class)
	public ModelAndView handleInputError(HttpServletRequest httpServletRequest,Exception exception) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("hola");
		return modelAndView;
	}

}
