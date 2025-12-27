package com.paytrust.payroll.repository;

import com.paytrust.payroll.model.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollRepository extends JpaRepository<Payroll, Long> {}
