package com.cg.sprint.repository;

import com.cg.sprint.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {
    // Find locations by country
    List<Location> findByCountry_CountryId(String countryId);
}
