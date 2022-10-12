package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Employee;
import com.masai.exceptions.EmployeeNotfoundException;
import com.masai.repositary.EmployeeDao;


@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	public List<Employee> getAllEmp() {
		
		return employeeDao.findAll();
	}

	@Override
	public Employee getEmployeeById(Integer id) throws EmployeeNotfoundException {
		Optional<Employee> opt = employeeDao.findById(id);
		if(opt.isEmpty()) {
			
			throw new EmployeeNotfoundException ("Employee not found ");
		}
		return opt.get();
		 //throw new RuntimeException("Employee already exist");
	}

	@Override
	public Employee saveEmployee(Employee emp) throws EmployeeNotfoundException {
//		Optional<Employee> opt = employeeDao.findById(emp.getEmployee_id());
//		if(opt.isEmpty()) {
//			
			return employeeDao.save(emp);
//		}
//		throw new EmployeeNotfoundException ("Employee already exist");
		//throw new RuntimeException("Employee already exist");
	}

	@Override
	public Employee updateEmployee(Employee emp) throws EmployeeNotfoundException {
		Optional<Employee> opt = employeeDao.findById(emp.getEmployee_id());
		if(opt.isEmpty()) {
			throw new EmployeeNotfoundException ("Employee not found ");
		}
		
		return employeeDao.save(emp);

	}

	@Override
	public String deleteEmployeeById(Integer id) throws EmployeeNotfoundException {
		Optional<Employee> opt = employeeDao.findById(id);
		if(opt.isEmpty()) {
			throw new EmployeeNotfoundException ("Employee not found ");
		}
		Employee emp = opt.get();
		 employeeDao.delete(emp);
		 return "Employee details deleted successfully";
	}

}
