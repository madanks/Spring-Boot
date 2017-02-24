package com.madan.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@GetMapping("/test")
	public String test() {
		return "Success";
	}

	@PostMapping("/save")
	public void saveEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
	}

	@PutMapping("/update")
	public void updateEmployee(@RequestBody Employee employee) {
		employeeService.update(employee);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteEmployee(@PathVariable Integer id) {
		employeeService.delete(id);
	}

	@GetMapping("/findall")
	public List<Employee> findEmployee() {
		return employeeService.findAll();
	}

	@GetMapping("/find/{id}")
	public Employee findOneEmployee(@PathVariable Integer id) {
		return employeeService.find(id);
	}

	@GetMapping("/findbylastname/{lastName}")
	public List<Employee> findByLastName(@PathVariable String lastName){
		return employeeService.findByLastName(lastName);
	}
}
