package com.umang.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long EmpId;
	private String EmpName;
	private String EmpDesignation;
	private long EmpNumber;
	
	public long getEmpId() {
		return EmpId;
	}
	public void setEmpId(long empId) {
		EmpId = empId;
	}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public String getEmpDesignation() {
		return EmpDesignation;
	}
	public void setEmpDesignation(String empDesignation) {
		EmpDesignation = empDesignation;
	}
	public long getEmpNumber() {
		return EmpNumber;
	}
	public void setEmpNumber(long empNumber) {
		EmpNumber = empNumber;
	}
	
	@Override
	public String toString() {
		return "Employee [EmpId=" + EmpId + ", EmpName=" + EmpName + ", EmpDesignation=" + EmpDesignation
				+ ", EmpNumber=" + EmpNumber + "]";
	}
	
	

}
