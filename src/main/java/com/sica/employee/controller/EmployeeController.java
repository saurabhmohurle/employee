package com.sica.employee.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sica.employee.entity.EmployeeEntity;
import com.sica.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService service;
	String response;
	
	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody EmployeeEntity entity) {
		return service.addEmployee(entity);
	}
	
	@GetMapping("/getEmployee")
	public List<EmployeeEntity> getEmployees(){
		return service.getEmployees();
	}
	
	@GetMapping("getEmployeeById")
	public Optional<EmployeeEntity> getEmployeeById(@RequestParam int id) {
		return service.getEmployeeById(id);
	}
	
	@GetMapping("getEmployeeByDesignation")
	public List<EmployeeEntity> findByDesignation(@RequestParam String designation) {
		return service.findByDesignation(designation);
	}
	
	@GetMapping("getEmployeeByDesignationAndSalary")
	public List<EmployeeEntity> findByDesignationAndSalary(@RequestParam String designation,int salary) {
		return service.findByDesignation(designation,salary);
	}
	
	@DeleteMapping("deleteEmployeeById")
	public String deleteEmployeeById(@RequestParam int id) {
		return service.deleteEmployeeById(id);
	}
	
	@PutMapping("/updateEmployee")
	public String updateEmployee(@RequestBody EmployeeEntity entity) {
		return service.updateEmployee(entity);
	}
}
