package com.comprehensiveJava.springbootcrud.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comprehensiveJava.springbootcrud.entity.Employee;
import com.comprehensiveJava.springbootcrud.repository.UserRepository;

@Service
public class EmployeeService {
	@Autowired
	private UserRepository repository;
	
	public Employee saveEmployee(Employee employee){ 
		Employee storedDetails=repository.findById(employee.getId());
				if(storedDetails!=null) throw new RuntimeException("Already exists");
			return repository.save(employee);
	}
	//public List<Employee> saveEmployees(List<Employee> employees) {
		//return repository.saveAll(employees);
	//}
    //public List<Employee> getAllEmployees(){
    	//return repository.findAll();
    //}
    public Employee getEmployeeById(int id) {
    	return repository.findById(id);
    }
    public String deleteEmployee(int id) {
    	repository.deleteById(id);
    	return "Employee removed successfully !"+id;
    }
   // public Employee updateEmployee(Employee employee) {
    //	Employee existingEmployee=repository.findById(employee.getId()).orElse(null);
    	//existingEmployee.getId()employee;
    	//existingEmployee.setName(employee.getName());
    	//existingEmployee.setSalary(employee.getSalary());
    	//existingEmployee.setDesignation(employee.getDesignation());
    	//return repository.save(existingEmployee);
    	
    //}
	public Employee updateEmployeeSal(Employee employee,int id, double salary) {
		Employee existingEmployee=repository.findById(employee.getId());
		existingEmployee.setSalary(employee.getSalary());
		return repository.save(existingEmployee);
	}
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}
}

