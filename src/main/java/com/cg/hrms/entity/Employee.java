package com.cg.hrms.entity;
 
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

import java.math.BigDecimal;

import java.sql.Date;

import java.time.LocalDate;
 
@Entity

@Table(name = "employees")

public class Employee {
 
    @Id

    @Column(name = "employee_id")

    private Long employeeId;
 
    @Column(name = "first_name")

    private String firstName;
 
    @Column(name = "last_name", nullable = false)

    private String lastName;
 
    @Column(name = "email", nullable = false, unique = true)

    private String email;
 
    @Column(name = "phone_number")

    private String phoneNumber;
 
    // Both date types included

    @Column(name = "hire_date", nullable = false)

    private Date hireDate;
 
    @Transient // Not persisted, just for compatibility

    private LocalDate hireLocalDate;
 
    // Both jobId and Job relationship included

    @Column(name = "job_id", nullable = false)

    private String jobId;
 
    @ManyToOne

    @JoinColumn(name = "job_id", referencedColumnName = "job_id", insertable = false, updatable = false)

    private Job job;
 
    // Both salary types included

    @Column(name = "salary")

    private Double salary;
 
    @Transient

    private BigDecimal salaryDecimal;
 
    @Column(name = "commission_pct")

    private Double commissionPct;
 
    @Transient

    private BigDecimal commissionPctDecimal;
 
    // Both managerId and manager relationship included

    @Column(name = "manager_id")

    private Long managerId;
 
    @ManyToOne

    @JoinColumn(name = "manager_id", insertable = false, updatable = false)

    private Employee manager;
 
    @ManyToOne

    @JsonIgnore

    @JoinColumn(name = "department_id")

    private Department department;
 
    // Getters and Setters
 
    public Long getEmployeeId() {

        return employeeId;

    }
 
    public void setEmployeeId(Long employeeId) {

        this.employeeId = employeeId;

    }
 
    public String getFirstName() {

        return firstName;

    }
 
    public void setFirstName(String firstName) {

        this.firstName = firstName;

    }
 
    public String getLastName() {

        return lastName;

    }
 
    public void setLastName(String lastName) {

        this.lastName = lastName;

    }
 
    public String getEmail() {

        return email;

    }
 
    public void setEmail(String email) {

        this.email = email;

    }
 
    public String getPhoneNumber() {

        return phoneNumber;

    }
 
    public void setPhoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber;

    }
 
    public Date getHireDate() {

        return hireDate;

    }
 
    public void setHireDate(Date hireDate) {

        this.hireDate = hireDate;

    }
 
    public LocalDate getHireLocalDate() {

        return hireLocalDate;

    }
 
    public void setHireLocalDate(LocalDate hireLocalDate) {

        this.hireLocalDate = hireLocalDate;

    }
 
    public String getJobId() {

        return jobId;

    }
 
    public void setJobId(String jobId) {

        this.jobId = jobId;

    }
 
    public Job getJob() {

        return job;

    }
 
    public void setJob(Job job) {

        this.job = job;

    }
 
    public Double getSalary() {

        return salary;

    }
 
    public void setSalary(Double salary) {

        this.salary = salary;

    }
 
    public BigDecimal getSalaryDecimal() {

        return salaryDecimal;

    }
 
    public void setSalaryDecimal(BigDecimal salaryDecimal) {

        this.salaryDecimal = salaryDecimal;

    }
 
    public Double getCommissionPct() {

        return commissionPct;

    }
 
    public void setCommissionPct(Double commissionPct) {

        this.commissionPct = commissionPct;

    }
 
    public BigDecimal getCommissionPctDecimal() {

        return commissionPctDecimal;

    }
 
    public void setCommissionPctDecimal(BigDecimal commissionPctDecimal) {

        this.commissionPctDecimal = commissionPctDecimal;

    }
 
    public Long getManagerId() {

        return managerId;

    }
 
    public void setManagerId(Long managerId) {

        this.managerId = managerId;

    }
 
    public Employee getManager() {

        return manager;

    }
 
    public void setManager(Employee manager) {

        this.manager = manager;

    }
 
    public Department getDepartment() {

        return department;

    }
 
    public void setDepartment(Department department) {

        this.department = department;

    }

}
 
