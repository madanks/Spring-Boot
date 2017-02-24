package com.madan.sb.service;

import java.util.List;

import com.madan.sb.domain.Employee;

public interface EmployeeService {

	public void save(Employee employee);

	public void update(Employee employee);

	public void delete(Integer id);

	public Employee find(Integer id);

	public List<Employee> findAll();

	public List<Employee> findByLastName(String lastname);

}
