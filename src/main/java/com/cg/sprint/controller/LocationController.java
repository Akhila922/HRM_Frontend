package com.cg.sprint.controller;

import com.cg.sprint.dto.LocationDTO;
import com.cg.sprint.dto.DepartmentDTO;
import com.cg.sprint.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    public List<LocationDTO> getAllLocations() {
        return locationService.getAllLocations();
    }

    @GetMapping("/{id}")
    public LocationDTO getLocationById(@PathVariable Long id) {
        return locationService.getLocationById(id);
    }

    @GetMapping("/{id}/departments")
    public List<DepartmentDTO> getDepartmentsByLocation(@PathVariable Long id) {
        return locationService.getDepartmentsByLocation(id);
    }

}
