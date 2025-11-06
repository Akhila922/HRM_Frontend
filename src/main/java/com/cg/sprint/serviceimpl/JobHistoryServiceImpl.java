package com.cg.sprint.serviceimpl;

import com.cg.sprint.dto.JobHistoryDTO;
import com.cg.sprint.entity.JobHistory;
import com.cg.sprint.entity.JobHistoryId;
import com.cg.sprint.repository.JobHistoryRepository;
import com.cg.sprint.service.JobHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobHistoryServiceImpl implements JobHistoryService {

    @Autowired
    private JobHistoryRepository jobHistoryRepository;

    @Override
    public List<JobHistoryDTO> getAllJobHistories() {
        return jobHistoryRepository.findAll()
                .stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public JobHistoryDTO getJobHistory(Long employeeId, String startDate) {
        LocalDate start = LocalDate.parse(startDate);
        JobHistoryId id = new JobHistoryId();
        id.setEmployeeId(employeeId);
        id.setStartDate(start);
        return jobHistoryRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    private JobHistoryDTO convertToDTO(JobHistory jobHistory) {
        JobHistoryDTO dto = new JobHistoryDTO();
        dto.setEmployeeId(jobHistory.getId().getEmployeeId());
        dto.setStartDate(jobHistory.getId().getStartDate());
        dto.setEndDate(jobHistory.getEndDate());
        dto.setJobId(jobHistory.getJob() != null ? jobHistory.getJob().getJobId() : null);
        dto.setDepartmentId(jobHistory.getDepartment() != null ? jobHistory.getDepartment().getDepartmentId() : null);
        return dto;
    }
}