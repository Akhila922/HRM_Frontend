package com.cg.sprint.service;

import com.cg.sprint.dto.EmployeeDTO;
import com.cg.sprint.dto.EmployeeSummaryDto;
import java.util.List;

public interface EmployeeService {
  List<EmployeeDTO> getAllEmployees();
  EmployeeDTO getEmployeeById(Long id);

  // NEW
  List<EmployeeSummaryDto> getEmployeeSummariesByCountry(String countryName);
}
