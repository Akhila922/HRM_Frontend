package com.cg.sprint.repository;

import com.cg.sprint.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Find employees by department
    List<Employee> findByDepartment_DepartmentId(Long departmentId);

    // Find employees by job
    List<Employee> findByJob_JobId(String jobId);

    // Find employees by manager
    List<Employee> findByManager_EmployeeId(Long managerId);
}
