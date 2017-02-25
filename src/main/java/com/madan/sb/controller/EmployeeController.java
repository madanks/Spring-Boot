package com.madan.sb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.madan.sb.domain.Employee;
import com.madan.sb.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);


	@GetMapping("/test")
	public String test() {
		logger.info("--------------> Inside test() method ");
		return "Success";
	}

	@PostMapping("/save")
	public void saveEmployee(@RequestBody Employee employee) {
		logger.info("--------------> Inside saveEmployee() method ");
		employeeService.save(employee);
	}

	@PutMapping("/update")
	public void updateEmployee(@RequestBody Employee employee) {
		logger.info("--------------> Inside updateEmployee() method ");
		employeeService.update(employee);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteEmployee(@PathVariable Integer id) {
		logger.info("--------------> Inside deleteEmployee() method ");
		employeeService.delete(id);
	}

	@GetMapping("/findall")
	public List<Employee> findEmployee() {
		logger.info("--------------> Inside findEmployee() method ");
		return employeeService.findAll();
	}

	@GetMapping("/find/{id}")
	public Employee findOneEmployee(@PathVariable Integer id) {
		logger.info("--------------> Inside findOneEmployee() method ");
		return employeeService.find(id);
	}

	@GetMapping("/findbylastname/{lastName}")
	@PreAuthorize("hasRole('ROLE_USER')")
	public List<Employee> findByLastName(@PathVariable String lastName) {
		logger.info("--------------> Inside findByLastName() method ");
		return employeeService.findByLastName(lastName);
	}
}
