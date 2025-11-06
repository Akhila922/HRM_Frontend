package com.cg.sprint.repository;


import com.cg.sprint.entity.JobHistory;
import com.cg.sprint.entity.JobHistoryId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobHistoryRepository extends JpaRepository<JobHistory, JobHistoryId> {
    // No extra methods needed for now
}
