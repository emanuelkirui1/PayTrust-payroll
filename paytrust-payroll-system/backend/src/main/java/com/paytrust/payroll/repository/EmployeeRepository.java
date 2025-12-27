package com.paytrust.payroll.repository;

import com.paytrust.payroll.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByCompany_Id(Long companyId);
}
