package com.sica.employee.service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sica.employee.entity.EmployeeEntity;
import com.sica.employee.entity.EmployeeRepository;

@Service
public class EmployeeService {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	EmployeeRepository repository;
	
	String Response;
	public String addEmployee(EmployeeEntity entity) {
		System.out.println(entity.toString());
		logger.info(entity.toString());
		repository.save(entity);
		Response = "Employee added successfully";
		logger.info(Response);
		return Response;
	}
	
	public List<EmployeeEntity> getEmployees(){
		return repository.findAll();
	}

	public Optional<EmployeeEntity> getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	public List<EmployeeEntity> findByDesignation(String designation) {
		// TODO Auto-generated method stub
		return repository.findByDesignation(designation);
	}

	public List<EmployeeEntity> findByDesignation(String designation, int salary) {
		// TODO Auto-generated method stub
		return repository.findByDesignationAndSalary(designation, salary);
	}

	public String deleteEmployeeById(int id) {
		// TODO Auto-generated method stub
		try {
			repository.deleteById(id);
			Response = "Record has been deleted..!!";
			logger.info(Response);
			return Response;
		} catch (Exception e) {
			// TODO: handle exception
			Response = "Invalid ID: "+id;
			logger.error(Response);
			return Response;
		}
	}
 
	public String updateEmployee(EmployeeEntity entity) {
		// TODO Auto-generated method stub
		System.out.println(entity.toString());
		logger.info(entity.toString());
		repository.save(entity);
		Response = "Employee updated successfully";
		logger.info(Response);
		return Response;
	}
}
