package com.comprehensiveJava.springbootcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.comprehensiveJava.springbootcrud.entity.Employee;

public interface UserRepository extends JpaRepository<Employee,Integer> {

	

}
