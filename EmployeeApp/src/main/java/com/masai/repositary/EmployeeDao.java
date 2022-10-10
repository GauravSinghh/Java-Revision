package com.masai.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee	, Integer>{

}
