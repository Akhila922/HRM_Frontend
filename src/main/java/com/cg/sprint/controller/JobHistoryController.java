package com.cg.sprint.controller;

import com.cg.sprint.dto.JobHistoryDTO;
import com.cg.sprint.service.JobHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/job-history")
public class JobHistoryController {

    @Autowired
    private JobHistoryService jobHistoryService;

    @GetMapping
    public List<JobHistoryDTO> getAllJobHistories() {
        return jobHistoryService.getAllJobHistories();
    }

    @GetMapping("/{employeeId}/{startDate}")
    public JobHistoryDTO getJobHistory(@PathVariable Long employeeId, @PathVariable String startDate) {
        return jobHistoryService.getJobHistory(employeeId, startDate);
    }
}