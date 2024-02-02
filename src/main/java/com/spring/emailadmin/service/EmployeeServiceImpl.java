package com.spring.emailadmin.service;

import com.spring.emailadmin.dao.EmployeeRepo;
import com.spring.emailadmin.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements employeeService {

    private final EmployeeRepo repo;

    public EmployeeServiceImpl(EmployeeRepo repo){
        this.repo=repo;
    }

    @Override
    public List<Employee> list() {
        return repo.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> employee=repo.findById(id);
        Employee employee1=null;
        if(employee.isPresent()){
            employee1=employee.get();
        }else{
            throw new RuntimeException("Employee is not found at id: "+id);
        }
        return employee1;
    }

    @Override
    public void save(Employee employee) {
        repo.save(employee);
    }

    @Override
    public void delete(int id) {
    repo.deleteById(id);
    }
}
