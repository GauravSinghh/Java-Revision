package com.masai.service;

import java.util.List;

import com.masai.entity.Employee;
import com.masai.exceptions.EmployeeNotfoundException;

public interface EmployeeService {

	public List<Employee> getAllEmp();
	
	public Employee getEmployeeById(Integer id) throws EmployeeNotfoundException;
	
	public Employee saveEmployee(Employee emp) throws EmployeeNotfoundException;
	
	public Employee updateEmployee(Employee emp) throws EmployeeNotfoundException;
	
	public String deleteEmployeeById(Integer id) throws EmployeeNotfoundException;
	
	
	
}
