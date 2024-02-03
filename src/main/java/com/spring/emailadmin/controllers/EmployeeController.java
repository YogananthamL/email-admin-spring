package com.spring.emailadmin.controllers;

import com.spring.emailadmin.entity.Employee;
import com.spring.emailadmin.service.EmployeeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/form")
    public String showForm(Model model){
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        return "employee-form";
    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employee.setEmail(service.emailGenerate(employee));
        employee.setPassword(service.passwordSet(employee));
        service.save(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/update")
    public String updateEmployee(@RequestParam("employeeId") int id, Model model){
        Employee employee=service.findById(id);
        model.addAttribute("employee",employee);
        return "employee-form";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int id){
        service.delete(id);
        return "redirect:/employees/list";
    }
}
