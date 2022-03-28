package com.comprehensiveJava.springbootcrud.controller;

import java.util.Comparator;

import com.comprehensiveJava.springbootcrud.entity.Employee;

public class EmpNameComparator implements Comparator<Employee> {
    public int compare(Employee employee1, Employee employee2) {
    	return employee1.getName().compareTo(employee2.getName());
    }
}
