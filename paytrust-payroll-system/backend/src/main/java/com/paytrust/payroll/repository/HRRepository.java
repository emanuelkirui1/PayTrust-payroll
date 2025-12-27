package com.paytrust.payroll.repository;

import com.paytrust.payroll.model.HR;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HRRepository extends JpaRepository<HR, Long> {
    HR findByUsername(String username);
}
