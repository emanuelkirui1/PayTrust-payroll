package com.paytrust.payroll.repository;

import com.paytrust.payroll.model.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
    List<AuditLog> findByPerformedByContaining(String performedBy);
}
