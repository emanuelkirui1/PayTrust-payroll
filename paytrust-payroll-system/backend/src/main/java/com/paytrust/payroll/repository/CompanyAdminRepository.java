package com.paytrust.payroll.repository;

import com.paytrust.payroll.model.CompanyAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyAdminRepository extends JpaRepository<CompanyAdmin, Long> {
    CompanyAdmin findByUsername(String username);
}
