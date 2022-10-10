package com.masai.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer employee_id;
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	@NotNull
	
	@Pattern(regexp = "(0/91)?[7-9][0-9]{9}", message = "Invalid Mobile Number")
	private String cellphone;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "employee")
	private List<Address> address;
}
