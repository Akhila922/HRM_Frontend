package com.cg.sprint.service;

import com.cg.sprint.dto.DepartmentDTO;
import com.cg.sprint.dto.EmployeeDTO;
import java.util.List;

public interface DepartmentService {
    List<DepartmentDTO> getAllDepartments();
    DepartmentDTO getDepartmentById(Long id);
    List<EmployeeDTO> getEmployeesByDepartment(Long departmentId);
}