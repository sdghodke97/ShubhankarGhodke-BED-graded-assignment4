package com.gl.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.gl.employee.Entity.Employee;
//import com.gl.employee.serviceImpl.List;

public interface EmployeeService {

	void addEmployee(Employee employee);

	String updateEmployee(Employee employee);

	Optional<Employee> getEmployeeById(Integer id);

	String deleteEmployeeByid(int id);

	List<Employee> getAllEmployees();

}