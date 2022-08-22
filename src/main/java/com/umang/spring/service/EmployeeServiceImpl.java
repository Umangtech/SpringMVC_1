package com.umang.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umang.spring.dao.EmployeeDAO;
import com.umang.spring.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeedao;

	@Override
	@Transactional
	public long save(Employee employee) {
		return employeedao.save(employee);
	}

	@Override
	@Transactional
	public Employee get(long empid) {
		return employeedao.get(empid);
	}

	@Override
	@Transactional
	public List<Employee> list() {
		return employeedao.list();
	}

	@Override
	@Transactional
	public void update(long empid, Employee employee) {

		//long empId = employee.getEmpId();
		employeedao.update(empid, employee);

	}

	@Override
	@Transactional
	public void delete(long empid) {
		employeedao.delete(empid);

	}

}
