package com.comprehensiveJava.springbootcrud.controller;

import java.util.Collections;
import java.util.List;

import org.hibernate.cache.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.comprehensiveJava.springbootcrud.entity.Employee;
import com.comprehensiveJava.springbootcrud.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}

	// @PostMapping("/addEmployees")
	// public List<Employee> addEmployees(@RequestBody List<Employee> employees) {
	// return service.saveEmployees(employees);
	// }
	@GetMapping("/employees")
	public List<Employee> findAllEmployees() {
		List<Employee> employeelist=service.getAllEmployees();
		Collections.sort(employeelist, new EmpNameComp());
		return service.getAllEmployees();
	}

	@GetMapping("/employee/{id}")
	public Employee findEmployeeById(@PathVariable int id) {
		return service.getEmployeeById(id);
	}

	@PutMapping("/update/{id}/{salary}")
	public Employee updateEmployeeSal(@RequestBody Employee employee, @PathVariable int id,
			@PathVariable double salary) {
		return service.updateEmployeeSal(employee, id, salary);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return service.deleteEmployee(id);
	}
}
