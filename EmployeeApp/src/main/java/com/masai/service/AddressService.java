package com.masai.service;

import java.util.List;

import com.masai.entity.Address;

public interface AddressService{
	
	public List<Address> getAddressByEmpId(Integer empId) throws Exception;
	
	public Address getAddressByEmpIdAndAddId(Integer empId, Integer address_id) throws  Exception;
	
	public String saveAddressByEmpId(Address ad,Integer empId) throws Exception;
	
	public String updateAddressByEmpId(Address ad,Integer empId) throws Exception;
	
	public String deleteAddressByEmpId(Integer address_Id,Integer empId) throws Exception;

}
