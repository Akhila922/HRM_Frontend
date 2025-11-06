package com.cg.sprint.repository;

import com.cg.sprint.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CountryRepository extends JpaRepository<Country, String> {
    // Find countries by region
    List<Country> findByRegion_RegionId(Long regionId);
}

