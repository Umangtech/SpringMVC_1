package com.umang.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.umang.spring.model.Employee;
import com.umang.spring.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeservice;

	@GetMapping("/")
	public ResponseEntity<String> getWelcomeMsg() {
		return ResponseEntity.ok().body("Hello I am Employee Controller");
	}

	@GetMapping("/get")
	public ResponseEntity<List<Employee>> list() {
		List<Employee> list = employeeservice.list();
		return ResponseEntity.ok().body(list);
	}
	
	//get single employee
	@GetMapping("/get/{empid}")
	public ResponseEntity<Employee> get(@PathVariable("empid") long empid)
	{
		Employee employee=employeeservice.get(empid);
		return ResponseEntity.ok().body(employee);
	}

	// save employee
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Employee employee) {
		System.out.println("Employee Number"+employee.getEmpNumber());
		long EmpId = employeeservice.save(employee);
		return ResponseEntity.ok().body("Employee is created with id:" + EmpId);
	}

	//Delete a book record
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<String> delete(@PathVariable("empId") long empId) {
		employeeservice.delete(empId);
		return ResponseEntity.ok().body("Employee is Deleted");
	}

	// Update employee
/*	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestParam long empId, @RequestBody Employee employee) {
		employeeservice.update(empId, employee);
		return ResponseEntity.ok().body("success");
	}
*/	
	@PutMapping("/update/{empId}")
	public ResponseEntity<?> update(@PathVariable("empId") long empid, @RequestBody Employee employee) {
		employeeservice.update(empid, employee);
		return ResponseEntity.ok().body("Updated Successfully");
	}

}
