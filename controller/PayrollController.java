package com.paytrust.payroll.controller;

import com.paytrust.payroll.model.Payroll;
import com.paytrust.payroll.model.Employee;
import com.paytrust.payroll.repository.EmployeeRepository;
import com.paytrust.payroll.service.PayrollService;
import com.paytrust.payroll.service.AuditService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payrolls")
@RequiredArgsConstructor
public class PayrollController {

    private final PayrollService payrollService;
    private final EmployeeRepository employeeRepository;
    private final AuditService auditService;

    @PostMapping("/generate/{employeeId}")
    public Payroll generatePayroll(@PathVariable Long employeeId, @RequestParam double overtime) {
        Employee emp = employeeRepository.findById(employeeId).orElseThrow();
        Payroll payroll = payrollService.generatePayroll(emp, overtime);
        auditService.logAction("Generated payroll for: " + emp.getFirstName(), "System");
        return payroll;
    }
}
