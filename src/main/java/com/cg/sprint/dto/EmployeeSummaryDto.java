package com.cg.sprint.dto;

public class EmployeeSummaryDto {
  private String countryName;
  private String city;
  private String stateProvince;
  private String departmentName;
  private Long employeeId;
  private String employeeName;
  private String email;
  private String phoneNumber;

  public EmployeeSummaryDto(String countryName, String city, String stateProvince,
                            String departmentName, Long employeeId, String employeeName,
                            String email, String phoneNumber) {
    this.countryName = countryName;
    this.city = city;
    this.stateProvince = stateProvince;
    this.departmentName = departmentName;
    this.employeeId = employeeId;
    this.employeeName = employeeName;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }

  // getters only
  public String getCountryName() { return countryName; }
  public String getCity() { return city; }
  public String getStateProvince() { return stateProvince; }
  public String getDepartmentName() { return departmentName; }
  public Long getEmployeeId() { return employeeId; }
  public String getEmployeeName() { return employeeName; }
  public String getEmail() { return email; }
  public String getPhoneNumber() { return phoneNumber; }
}