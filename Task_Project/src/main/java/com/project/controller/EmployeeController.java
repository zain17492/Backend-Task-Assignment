package com.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.EmployeeDto;
import com.project.exception.ApiResponse;
import com.project.service.EmployeeService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/Employees")
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeservice;

	
	
	@PostMapping("/addemployees")
	public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody EmployeeDto employeedto)
	{
		EmployeeDto  createEmployee = this.employeeservice.createEmployee(employeedto);
		return new ResponseEntity<EmployeeDto>(createEmployee,HttpStatus.CREATED);
	}
	
	
	
	//get all Employees
	@GetMapping("/getallEmployees")
	public ResponseEntity<List<EmployeeDto>> getAllEmployees()
	{
		List<EmployeeDto> allEmployees = this.employeeservice.getAllEmployees();
		return new ResponseEntity<List<EmployeeDto>>(allEmployees,HttpStatus.OK);
		
	}
	// get Employee details by id
	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable int id)
	{
		EmployeeDto employeedto=this.employeeservice.getEmployeeById(id);
		return new ResponseEntity<EmployeeDto>(employeedto,HttpStatus.OK);
		
	}
	
	//update Employee
	@PutMapping("/updateEmployees/{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeedto,
			                                        @PathVariable int id)
	{
		EmployeeDto updateEmployee = this.employeeservice.updateEmployee(employeedto, id);
		return new ResponseEntity<EmployeeDto>(updateEmployee,HttpStatus.OK);
	}
	
	//delete Employee
	@DeleteMapping("/deleteEmployees/{id}")
	public ApiResponse deleteEmployee(@PathVariable int id)
	{
		this.employeeservice.deleteEmployee(id);
		return new ApiResponse();
	}
}
