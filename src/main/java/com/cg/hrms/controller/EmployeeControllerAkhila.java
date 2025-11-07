package com.cg.hrms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cg.hrms.entity.Employee;
import com.cg.hrms.repositories.EmployeeRepositoryAkhila;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/akhila/employees")
@Tag(name = "Employee API - Akhila", description = "Endpoints managed by Akhila")
public class EmployeeControllerAkhila {

    @Autowired
    private EmployeeRepositoryAkhila employeeRepository;

    @Operation(summary = "Get all employees")
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Operation(summary = "Get employee by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        return employeeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Search employees by first name")
    @GetMapping("/search")
    public List<Employee> searchEmployees(@RequestParam("name") String name) {
        return employeeRepository.findByFirstNameContainingIgnoreCase(name);
    }
}
