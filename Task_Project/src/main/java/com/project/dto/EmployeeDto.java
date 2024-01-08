package com.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto 
{
	private int id;
    private String ename;
	private String email; 
	private int salary; 
	private String des; 
    private String phone;
	private String gender;
    private String department;
    

    
}
