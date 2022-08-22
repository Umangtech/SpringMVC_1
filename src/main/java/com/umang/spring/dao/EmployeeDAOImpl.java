package com.umang.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.umang.spring.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);
		return employee.getEmpId();
	}

	@Override
	public Employee get(long empid) {
		return sessionFactory.getCurrentSession().get(Employee.class, empid);
	}

	@Override
	public List<Employee> list() {
		List<Employee> list=sessionFactory.getCurrentSession().createQuery("from Employee order by EmpId").list();
		return list;
	}

	@Override
	public void update(long empid, Employee employee) {
		Session session=sessionFactory.getCurrentSession();
		Employee oldemployee=session.byId(Employee.class).load(empid);
		oldemployee.setEmpName(employee.getEmpName());
		oldemployee.setEmpDesignation(employee.getEmpDesignation());
		oldemployee.setEmpNumber(employee.getEmpNumber());
		//System.out.println(employee.getEmpNumber());
		session.flush();
	}

	@Override
	public void delete(long empid) {
		Session session=sessionFactory.getCurrentSession();
		Employee employee=session.byId(Employee.class).load(empid);
		session.delete(employee);
	}

}
