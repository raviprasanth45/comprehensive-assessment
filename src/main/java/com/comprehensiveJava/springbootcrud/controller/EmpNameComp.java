package com.comprehensiveJava.springbootcrud.controller;

import java.util.Comparator;

import com.comprehensiveJava.springbootcrud.entity.Employee;

public class EmpNameComp implements Comparator<Employee> {
	public int compare(Employee e1, Employee e2) {
		if(e1.getSalary()==e2.getSalary()) {
		return e1.getName().compareTo(e2.getName());
		}
		return 0;
	}
}
