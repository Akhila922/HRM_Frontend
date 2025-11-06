package com.cg.sprint.serviceimpl;

import com.cg.sprint.dto.LocationDTO;
import com.cg.sprint.dto.DepartmentDTO;
import com.cg.sprint.entity.Location;
import com.cg.sprint.entity.Department;
import com.cg.sprint.repository.LocationRepository;
import com.cg.sprint.repository.DepartmentRepository;
import com.cg.sprint.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<LocationDTO> getAllLocations() {
        return locationRepository.findAll()
                .stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public LocationDTO getLocationById(Long id) {
        return locationRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Override
    public List<DepartmentDTO> getDepartmentsByLocation(Long locationId) {
        List<Department> departments = departmentRepository.findByLocation_LocationId(locationId);
        return departments.stream().map(this::convertDepartmentToDTO).collect(Collectors.toList());
    }

    private LocationDTO convertToDTO(Location loc) {
        LocationDTO dto = new LocationDTO();
        dto.setLocationId(loc.getLocationId());
        dto.setStreetAddress(loc.getStreetAddress());
        dto.setPostalCode(loc.getPostalCode());
        dto.setCity(loc.getCity());
        dto.setStateProvince(loc.getStateProvince());
        dto.setCountryId(loc.getCountry() != null ? loc.getCountry().getCountryId() : null);
        return dto;
    }

    private DepartmentDTO convertDepartmentToDTO(Department dept) {
        DepartmentDTO dto = new DepartmentDTO();
        dto.setDepartmentId(dept.getDepartmentId());
        dto.setDepartmentName(dept.getDepartmentName());
        dto.setManagerId(dept.getManager() != null ? dept.getManager().getEmployeeId() : null);
        dto.setLocationId(dept.getLocation() != null ? dept.getLocation().getLocationId() : null);
        return dto;
    }
}