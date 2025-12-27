package com.paytrust.payroll.repository;

import com.paytrust.payroll.model.SuperAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperAdminRepository extends JpaRepository<SuperAdmin, Long> {
    SuperAdmin findByUsername(String username);
}
