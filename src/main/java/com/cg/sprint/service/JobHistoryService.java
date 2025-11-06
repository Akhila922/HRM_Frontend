package com.cg.sprint.service;

import com.cg.sprint.dto.JobHistoryDTO;
import java.util.List;

public interface JobHistoryService {
    List<JobHistoryDTO> getAllJobHistories();
    JobHistoryDTO getJobHistory(Long employeeId, String startDate);
}