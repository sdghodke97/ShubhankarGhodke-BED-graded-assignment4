package com.gl.employee.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.employee.Entity.Employee;
import com.gl.employee.repository.EmployeeRepository;
import com.gl.employee.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public void addEmployee(Employee employee) {
		employeeRepository.saveAndFlush(employee);

	}

	@Override
	public String updateEmployee(Employee employee) {
		boolean exist = employeeRepository.existsById(employee.getId());
		if (exist) {
			employeeRepository.saveAndFlush(employee);
		}else {
			throw new RuntimeException("There is no Employee with Id "+ employee.getId() + "exists");
		}
		return "Employee Details Updated";
	}

	@Override
	public Optional<Employee> getEmployeeById(Integer id) {
		return employeeRepository.findById(id);
	}

	@Override
	public String deleteEmployeeByid(int id) {
		 employeeRepository.deleteById(id);
		 return "Employee Record Deleted Successfully";
	}
	
	
}
