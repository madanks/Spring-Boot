package com.madan.sb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madan.sb.dao.EmployeeDAO;
import com.madan.sb.domain.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	public List<Employee> findAll() {
		List<Employee> empList = new ArrayList<>();
		employeeDAO.findAll().forEach(empList::add);
		return empList;
	}

	@Override
	public void save(Employee employee) {
		employeeDAO.save(employee);

	}

	@Override
	public void update(Employee employee) {
		employeeDAO.save(employee);

	}

	@Override
	public void delete(Integer id) {
		employeeDAO.delete(id);

	}

	@Override
	public Employee find(Integer id) {

		return employeeDAO.findOne(id);
	}

	@Override
	public List<Employee> findByLastName(String lastname) {
		return employeeDAO.findByLastName(lastname);
	}

}
