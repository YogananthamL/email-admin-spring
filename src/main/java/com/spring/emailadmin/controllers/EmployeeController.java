package com.spring.emailadmin.controllers;

import com.spring.emailadmin.entity.Employee;
import com.spring.emailadmin.service.EmployeeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeServiceImpl service;

    public EmployeeController(EmployeeServiceImpl service){
        this.service=service;
    }
    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("employees",service.list());
        return "employee-list";
    }
}
