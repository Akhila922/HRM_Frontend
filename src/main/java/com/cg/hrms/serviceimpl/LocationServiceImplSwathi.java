package com.cg.hrms.serviceimpl;

import com.cg.hrms.dto.*;
import com.cg.hrms.entity.Location;
import com.cg.hrms.repositories.LocationRepositorySwathi;
import com.cg.hrms.service.LocationServiceSwathi;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class LocationServiceImplSwathi implements LocationServiceSwathi {

    private final LocationRepositorySwathi repo;

    public LocationServiceImplSwathi(LocationRepositorySwathi repo) {
        this.repo = repo;
    }

    @Override
    public LocationDtoSwathi getCityDetails(String cityName) {
        Location location = repo.findByCityIgnoreCase(cityName);
        if (location == null) return null;

        LocationDtoSwathi dto = new LocationDtoSwathi();
        dto.setCity(location.getCity());
        dto.setDepartments(
                location.getDepartments().stream().map(dept -> {
                    DepartmentDtoSwathi d = new DepartmentDtoSwathi();
                    d.setDepartmentName(dept.getDepartmentName());
                    d.setEmployees(
                            dept.getEmployees().stream().map(emp -> {
                                EmployeeDtoSwathi e = new EmployeeDtoSwathi();
                                e.setEmployeeId(emp.getEmployeeId());
                                e.setFirstName(emp.getFirstName());
                                e.setLastName(emp.getLastName());
                                e.setEmail(emp.getEmail());
                                e.setPhoneNumber(emp.getPhoneNumber());
                                return e;
                            }).collect(Collectors.toList())
                    );
                    return d;
                }).collect(Collectors.toList())
        );
        return dto;
    }
}
