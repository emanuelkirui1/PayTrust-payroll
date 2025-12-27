package com.paytrust.payroll.controller;

import com.paytrust.payroll.model.AuditLog;
import com.paytrust.payroll.repository.AuditLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/superadmin/audit")
@RequiredArgsConstructor
public class AuditLogController {

    private final AuditLogRepository repository;

    @GetMapping
    public List<AuditLog> getAllLogs() {
        return repository.findAll();
    }
}
