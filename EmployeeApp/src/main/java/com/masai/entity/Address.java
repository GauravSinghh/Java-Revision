package com.masai.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer address_id;
	@NotNull
	
	private String street;
	@NotNull
	
	private String city;
	@NotNull
	
	private String state;
	@NotNull
	
	private String country;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Employee employee;
	
}
