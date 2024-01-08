package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entities.Employee;



public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{


}