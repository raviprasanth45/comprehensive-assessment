package com.comprehensiveJava.springbootcrud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.comprehensiveJava.springbootcrud.entity.Employee;

public interface UserRepository extends JpaRepository<Employee,Integer> {
      List<Employee> findEmployeesByName(String name);
	
      Employee findById(int id);
}
