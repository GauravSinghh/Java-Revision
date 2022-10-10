package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Address;
import com.masai.entity.Employee;
import com.masai.exceptions.AddressNotfoundException;
import com.masai.exceptions.EmployeeNotfoundException;
import com.masai.repositary.AddressDao;
import com.masai.repositary.EmployeeDao;


@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	EmployeeServiceImpl employeeServiceImpl;
	
	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	AddressDao addressDao;
	
	@Override
	public List<Address> getAddressByEmpId(Integer empId) throws EmployeeNotfoundException {
		Employee emp = employeeServiceImpl.getEmployeeById(empId);
		if(emp==null) {
			throw new EmployeeNotfoundException("Employee not found");
		}
		return emp.getAddress();
	}

	@Override
	public Address getAddressByEmpIdAndAddId(Integer empId, Integer address_id) throws Exception {
		Employee emp = employeeServiceImpl.getEmployeeById(empId);
		if(emp==null) {
			throw new EmployeeNotfoundException("Employee not found");
		}
		for(Address a: emp.getAddress()) {
			if(a.getAddress_id()==address_id) {
				return a;
			}
		}
		 throw new AddressNotfoundException("Address not found");
	}

	@Override
	public String saveAddressByEmpId(Address ad,Integer empId) throws Exception {
		
		//Employee emp = employeeServiceImpl.getEmployeeById(empId);
		Optional<Employee> opt = employeeDao.findById(empId);
//		if(emp==null) {
//			throw new EmployeeNotfoundException("Employee not found");
//		}
		Employee emp = opt.get();
			List<Address> aList = emp.getAddress();
			aList.add(ad);
			emp.setAddress(aList);
		 //employeeServiceImpl.saveEmployee(emp);
		 employeeDao.save(emp);
		 return "Address saved "+ad;
	}

	@Override
	public String updateAddressByEmpId(Address ad,Integer empId) throws Exception {
		String msg = null;
		Employee emp = employeeServiceImpl.getEmployeeById(empId);
		if(emp==null) {
			throw new EmployeeNotfoundException("Employee not found");
		}
		Optional<Address> opt = addressDao.findById(ad.getAddress_id());
		if(opt.isEmpty()) {
			 throw new AddressNotfoundException("Address not found");
		}
		List<Address> aList = emp.getAddress();
		if(aList.remove(opt.get())) {
			aList.add(ad);
			msg ="Address Updated "+ad;
		}
		return msg;
	}

	@Override
	public String deleteAddressByEmpId(Integer address_Id,Integer empId) throws Exception {
		String msg = null;
		Employee emp = employeeServiceImpl.getEmployeeById(empId);
		if(emp==null) {
			throw new EmployeeNotfoundException("Employee not found");
		}
		Optional<Address> opt = addressDao.findById(address_Id);
		if(opt.isEmpty()) {
			 throw new AddressNotfoundException("Address not found");
		}
		List<Address> aList = emp.getAddress();
		if(aList.remove(opt.get())) {
			
			msg ="Address Deleted";
		}
		return msg;
		
	}

}
