package com.paytrust.payroll.repository;

import com.paytrust.payroll.model.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PayrollRepository extends JpaRepository<Payroll, Long> {
    List<Payroll> findByEmployee_Company_Id(Long companyId);
}
