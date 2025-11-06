package com.cg.sprint.serviceimpl;

import com.cg.sprint.dto.EmployeeDTO;
import com.cg.sprint.entity.Employee;
import com.cg.sprint.repository.EmployeeRepository;
import com.cg.sprint.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll()
                .stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    private EmployeeDTO convertToDTO(Employee emp) {
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