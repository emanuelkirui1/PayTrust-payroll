package com.paytrust.payroll.repository;

import com.paytrust.payroll.model.Accountant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountantRepository extends JpaRepository<Accountant, Long> {
    Accountant findByUsername(String username);
}
