package com.cg.sprint.serviceimpl;

import com.cg.sprint.dto.DepartmentDTO;
import com.cg.sprint.dto.EmployeeDTO;
import com.cg.sprint.entity.Department;
import com.cg.sprint.entity.Employee;
import com.cg.sprint.repository.DepartmentRepository;
import com.cg.sprint.repository.EmployeeRepository;
import com.cg.sprint.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        return departmentRepository.findAll()
                .stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Override
    public List<EmployeeDTO> getEmployeesByDepartment(Long departmentId) {
        List<Employee> employees = employeeRepository.findByDepartment_DepartmentId(departmentId);
        return employees.stream().map(this::convertEmployeeToDTO).collect(Collectors.toList());
    }

    private DepartmentDTO convertToDTO(Department dept) {
        DepartmentDTO dto = new DepartmentDTO();
        dto.setDepartmentId(dept.getDepartmentId());
        dto.setDepartmentName(dept.getDepartmentName());
        dto.setManagerId(dept.getManager() != null ? dept.getManager().getEmployeeId() : null);
        dto.setLocationId(dept.getLocation() != null ? dept.getLocation().getLocationId() : null);
        return dto;
    }

    private EmployeeDTO convertEmployeeToDTO(Employee emp) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setEmployeeId(emp.getEmployeeId());
        dto.setFirstName(emp.getFirstName());
        dto.setLastName(emp.getLastName());
        dto.setEmail(emp.getEmail());
        dto.setJobId(emp.getJob() != null ? emp.getJob().getJobId() : null);
        dto.setDepartmentId(emp.getDepartment() != null ? emp.getDepartment().getDepartmentId() : null);
        return dto;
    }
}