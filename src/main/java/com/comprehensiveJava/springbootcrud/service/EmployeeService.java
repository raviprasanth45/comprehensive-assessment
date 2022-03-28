package com.comprehensiveJava.springbootcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comprehensiveJava.springbootcrud.entity.Employee;
import com.comprehensiveJava.springbootcrud.repository.UserRepository;

@Service
public class EmployeeService {
	@Autowired
	private UserRepository repository;
	
	public Employee saveEmployee(Employee employee){ 
		return repository.save(employee);
	}
	public String existsEmployee(int id) throws Exception {
		repository.existsById(id);
		return "ID exits already !"+id;
	}
	public List<Employee> saveEmployees(List<Employee> employees) {
		return repository.saveAll(employees);
	}
    public List<Employee> getEmployees(){
    	return repository.findAll();
    }
    public Employee getEmployeeById(int id) {
    	return repository.findById(id).orElse(null);
    }
    public String deleteEmployee(int id) {
    	repository.deleteById(id);
    	return "Employee removed successfully !"+id;
    }
    public Employee updateEmployee(Employee employee) {
    	Employee existingEmployee=repository.findById(employee.getId()).orElse(null);
    	//existingEmployee.setName(employee.getName());
    	existingEmployee.setSalary(employee.getSalary());
    	//existingEmployee.setDesignation(employee.getDesignation());
    	return repository.save(existingEmployee);
    	
    }
}
