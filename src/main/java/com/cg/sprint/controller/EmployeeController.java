package com.cg.sprint.controller;

import com.cg.sprint.dto.EmployeeDTO;
import com.cg.sprint.dto.EmployeeSummaryDto;
import com.cg.sprint.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }
    @GetMapping("/country/{countryName}/summary")
    @Operation(summary = "By country → location, dept, emp name/id/email/phone")
    public List<EmployeeSummaryDto> byCountrySummary(@PathVariable String countryName) {
      return employeeService.getEmployeeSummariesByCountry(countryName);
    }
}

