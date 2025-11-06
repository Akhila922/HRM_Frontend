package com.cg.sprint.repository;

import com.cg.sprint.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Long> {
    // No extra methods needed for now
}

