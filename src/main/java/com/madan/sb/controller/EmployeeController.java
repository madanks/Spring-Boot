package com.madan.sb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madan.sb.domain.Employee;
import com.madan.sb.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/test")
	public String test() {
		return "Success";
	}

	@GetMapping("/find")
	public Employee findEmployee() {
		return employeeService.find();
	}

}
