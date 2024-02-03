package com.spring.emailadmin.service;

import com.spring.emailadmin.entity.Employee;

import java.util.List;

public interface employeeService {

    public List<Employee> list();

    public Employee findById(int id);

    public void save(Employee employee);

    public void delete(int id);

    public String emailGenerate(Employee employee);

    public String passwordSet(Employee employee);

    public String passwordGenerate();


}
