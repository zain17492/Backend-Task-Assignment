package com.project.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.project.dao.EmployeeRepository;
import com.project.dto.EmployeeDto;
import com.project.entities.Employee;
import com.project.exception.ResourceNotFoundException;
import com.project.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired
	private EmployeeRepository emprepo;

	
	@Autowired
	private ModelMapper modelmapper;
	
	//create Employee
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeedto) 
	{
		
		Employee employee = this.modelmapper.map(employeedto, Employee.class);
		Employee newEmployee= this.emprepo.save(employee);
		return this.modelmapper.map(newEmployee, EmployeeDto.class);
	}
	
	
	
	//get all Employees
	@Override
	public List<EmployeeDto> getAllEmployees()
	{
		List<Employee> allEmployees = this.emprepo.findAll();
		List<EmployeeDto> employeedtos= allEmployees.stream().map((employee) -> this.modelmapper.map(employee, EmployeeDto.class))
		                                           .collect(Collectors.toList());
		return employeedtos;
	}
	
	//get Employee by id
	@Override
	public EmployeeDto getEmployeeById(int id) 
	{
		Employee employee = this.emprepo.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Employee", "employee Id", id));
		
		return this.modelmapper.map(employee, EmployeeDto.class);
	}

	
	//update Employee details
	@Override
	public EmployeeDto updateEmployee(EmployeeDto employeedto, int id)
	{
		Employee employee = this.emprepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "employee Id", id));
		employee.setEname(employeedto.getEname());
		employee.setSalary(employeedto.getSalary());
		employee.setDes(employee.getDes());
		employee.setPhone(employeedto.getPhone());
		employee.setGender(employeedto.getGender());;
		employee.setEmail(employeedto.getEmail());
		employee.setDepartment(employeedto.getDepartment());
		
		Employee updatedEmployee = this.emprepo.save(employee);
		return this.modelmapper.map(updatedEmployee, EmployeeDto.class);
	}
	
	//delete Employee
		@Override
		public void deleteEmployee(int id) 
		{
			Employee employee= this.emprepo.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Employee", "employee Id", id));
			
			this.emprepo.delete(employee);	
		}
		
		//convert Employee to Dto
		public Employee dtoToEmployee(EmployeeDto employeedto)
		{
			Employee employee= this.modelmapper.map(employeedto, Employee.class);
			return employee;	
		}
		
		//convert Dto to Employee
		public EmployeeDto employeeToDto(Employee employee)
		{
			EmployeeDto employeedto = this.modelmapper.map(employee, EmployeeDto.class);
//			
			return employeedto;
			
			
		}

}
