package com.cg.sprint.repository;


import com.cg.sprint.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, String> {
    // No extra methods needed for now
}
