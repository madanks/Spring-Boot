package com.madan.sb.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.madan.sb.domain.Employee;
@Repository
public interface EmployeeDAO extends CrudRepository<Employee, Integer> {
	
	public List<Employee> findByLastName(String lastname);

}
