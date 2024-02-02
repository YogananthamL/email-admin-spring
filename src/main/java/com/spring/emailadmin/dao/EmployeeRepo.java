package com.spring.emailadmin.dao;

import com.spring.emailadmin.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
}
