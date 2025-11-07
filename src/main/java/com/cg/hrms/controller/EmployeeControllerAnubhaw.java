package com.cg.hrms.controller;

import org.springframework.web.bind.annotation.*;

import com.cg.hrms.entity.Employee;
import com.cg.hrms.service.EmployeeServiceAnubhaw;

import java.util.List;

@RestController
@RequestMapping("/anubhaw/employees")
public class EmployeeControllerAnubhaw {

    private final EmployeeServiceAnubhaw employeeService;

    public EmployeeControllerAnubhaw(EmployeeServiceAnubhaw employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
