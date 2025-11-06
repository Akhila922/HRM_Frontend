package com.cg.sprint.service;

import com.cg.sprint.dto.JobDTO;
import com.cg.sprint.dto.EmployeeDTO;
import java.util.List;

public interface JobService {
    List<JobDTO> getAllJobs();
    JobDTO getJobById(String id);
    List<EmployeeDTO> getEmployeesByJob(String jobId);
}