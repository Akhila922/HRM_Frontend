package com.cg.sprint.controller;

import com.cg.sprint.dto.JobDTO;
import com.cg.sprint.dto.EmployeeDTO;
import com.cg.sprint.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    // ✅ Get all jobs
    @GetMapping
    public List<JobDTO> getAllJobs() {
        return jobService.getAllJobs();
    }

    // ✅ Get job by ID
    @GetMapping("/{id}")
    public JobDTO getJobById(@PathVariable String id) {
        return jobService.getJobById(id);
    }

    // ✅ Get all employees for a given job
    @GetMapping("/{id}/employees")
    public List<EmployeeDTO> getEmployeesByJob(@PathVariable String id) {
        return jobService.getEmployeesByJob(id);
    }
}
