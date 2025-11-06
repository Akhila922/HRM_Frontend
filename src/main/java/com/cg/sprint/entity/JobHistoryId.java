package com.cg.sprint.entity;


import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class JobHistoryId implements Serializable {

    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "start_date")
    private LocalDate startDate;

    public Long getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
