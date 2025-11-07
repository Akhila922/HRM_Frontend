package com.cg.hrms.repositories;

import com.cg.hrms.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepositoryVighnesh extends JpaRepository<Employee, Long> {
  List<Employee> findByDepartment_Location_Country_CountryNameIgnoreCase(String countryName);
}
