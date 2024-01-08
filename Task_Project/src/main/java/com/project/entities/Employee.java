package com.project.entities;


import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee
{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

	@NotBlank(message = "Employee Name can't be empty")
    @NotNull(message = "Employee Name  can't be  null")	
    private String ename;

    @Email(message ="Invalid Email Id.")
	private String email; // Employee email
    
    @NotNull(message ="Contact no should'nt be null.")
	private String phone;
	
    @NotNull(message ="Gender should'nt be null.")
	private String gender;
    
	@NotNull(message ="Salary should'nt be null.")
	private int salary; // Employee Salary
	
	@NotNull(message ="Designation should'nt be null.")
	private String des; // Employee Designation
	
	@NotNull(message ="Department should'nt be null.")
    private String department;
}
