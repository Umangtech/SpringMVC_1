package com.umang.spring.service;

import java.util.List;

import com.umang.spring.model.Employee;

public interface EmployeeService {

	//save record
	long save(Employee employee);
	
	//get a single record
	Employee get(long EmpId);
	
	//get all record
	List<Employee> list();
	
	//update a record
	void update(long EmpId,Employee employee);
	
	//delete a record
	void delete(long EmpId);
	
}
