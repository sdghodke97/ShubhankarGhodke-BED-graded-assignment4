package com.gl.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.employee.Entity.Employee;
import com.gl.employee.service.EmployeeService;
//import com.gl.employee.serviceImpl.EmployeeServiceImpl;

@RestController
@RequestMapping("/employeeController")
public class EmployeeController {

	@Autowired
	EmployeeService employeeController;

	@PostMapping("/addEmployee")
	public String addEmployee(Employee employee) {
		employeeController.addEmployee(employee);
		return "Employee added";
	}

	@PostMapping("/updateEmployee")
	public String updateEmployee(Employee employee) {
		employeeController.updateEmployee(employee);
		return "Employee Details Updated";
	}

	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees(){
		return employeeController.getAllEmployees();
	}
	@GetMapping("/getEmployeeById")
	public Optional<Employee> getEmployeeById(Integer id) {
		 return employeeController.getEmployeeById(id);
//		return "Employee details fetched";
	}

	@DeleteMapping("/deleteEmployeeById")
	public String deleteEmployeeByid( int id) {
		employeeController.deleteEmployeeByid(id);
		 return "Employee Deleted successfully";
		
	}
}
