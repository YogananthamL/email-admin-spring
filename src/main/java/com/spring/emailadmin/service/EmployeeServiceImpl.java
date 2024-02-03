package com.spring.emailadmin.service;

import com.spring.emailadmin.dao.EmployeeRepo;
import com.spring.emailadmin.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements employeeService {

    private final EmployeeRepo repo;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepo repo, PasswordEncoder passwordEncoder){
        this.repo = repo;
        this.passwordEncoder=passwordEncoder;
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

    @Override
    public String emailGenerate(Employee employee) {
        String email=employee.getFirstName()+"."+employee.getLastName()+"@gmail.com";
        employee.setEmail(email);
        return email;
    }

    @Override
    public String passwordSet(Employee employee) {
        String password=passwordGenerate();
        String encodedPassword=passwordEncoder.encode(password);
        employee.setPassword(encodedPassword);
        return encodedPassword;
    }

    @Override
    public String passwordGenerate() {
        int length=8;
            String passwordSet="ABCEFGHIJKLMNOPQRSTUVWXYZ1234567890!@$%&";
            char[] password=new char[length];
            for(int i=0;i<length;i++) {
                int rand=(int)(Math.random()*passwordSet.length());
                password[i]=passwordSet.charAt(rand);
            }
            return new String (password);

    }


}
//password generation method
