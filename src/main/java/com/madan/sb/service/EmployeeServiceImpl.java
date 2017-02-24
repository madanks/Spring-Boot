package com.madan.sb.service;

import org.springframework.stereotype.Service;

import com.madan.sb.domain.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	public Employee find() {
		// TODO Auto-generated method stub
		return new Employee(101, "Madan", "Siwakoti", "Jhapa,Nepal", "Developer");
	}

}
