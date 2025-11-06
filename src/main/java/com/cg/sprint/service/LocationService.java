package com.cg.sprint.service;

import com.cg.sprint.dto.LocationDTO;
import com.cg.sprint.dto.DepartmentDTO;
import java.util.List;

public interface LocationService {
    List<LocationDTO> getAllLocations();
    LocationDTO getLocationById(Long id);
    List<DepartmentDTO> getDepartmentsByLocation(Long locationId);
}