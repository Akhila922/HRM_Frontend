package com.cg.sprint.serviceimpl;

import com.cg.sprint.dto.JobDTO;
import com.cg.sprint.dto.EmployeeDTO;
import com.cg.sprint.entity.Job;
import com.cg.sprint.entity.Employee;
import com.cg.sprint.repository.JobRepository;
import com.cg.sprint.repository.EmployeeRepository;
import com.cg.sprint.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<JobDTO> getAllJobs() {
        return jobRepository.findAll()
                .stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public JobDTO getJobById(String id) {
        return jobRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Override
    public List<EmployeeDTO> getEmployeesByJob(String jobId) {
        List<Employee> employees = employeeRepository.findByJob_JobId(jobId);
        return employees.stream().map(this::convertEmployeeToDTO).collect(Collectors.toList());
    }

    private JobDTO convertToDTO(Job job) {
        JobDTO dto = new JobDTO();
        dto.setJobId(job.getJobId());
        dto.setJobTitle(job.getJobTitle());
        dto.setMinSalary(job.getMinSalary());
        dto.setMaxSalary(job.getMaxSalary());
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