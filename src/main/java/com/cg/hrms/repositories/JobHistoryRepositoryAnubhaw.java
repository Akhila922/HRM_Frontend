package com.cg.hrms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hrms.entity.JobHistory;
import com.cg.hrms.entity.JobHistoryId;

import java.util.List;

public interface JobHistoryRepositoryAnubhaw extends JpaRepository<JobHistory, JobHistoryId> {
    List<JobHistory> findByEmployee_EmployeeId(Long employeeId);
}
