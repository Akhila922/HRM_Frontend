package com.cg.sprint.controller;

import com.cg.sprint.dto.DepartmentDTO;
import com.cg.sprint.dto.EmployeeDTO;
import com.cg.sprint.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<DepartmentDTO> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public DepartmentDTO getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

    @GetMapping("/{id}/employees")
    public List<EmployeeDTO> getEmployeesByDepartment(@PathVariable Long id) {
        return departmentService.getEmployeesByDepartment(id);
    }
}