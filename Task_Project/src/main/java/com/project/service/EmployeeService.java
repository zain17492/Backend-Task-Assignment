package com.project.service;

import java.util.List;

import com.project.dto.EmployeeDto;



public interface EmployeeService
{
	//create
	EmployeeDto createEmployee(EmployeeDto employeedto);
		
		//get single employee
	EmployeeDto getEmployeeById(int id);
		
		//Get all Employee
		List<EmployeeDto> getAllEmployees();
		
		//update
		EmployeeDto updateEmployee(EmployeeDto employeedto,int id);
		
		//delete
		void deleteEmployee(int id);
		

}

