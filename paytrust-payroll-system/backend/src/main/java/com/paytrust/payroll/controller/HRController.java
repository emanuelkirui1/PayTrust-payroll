package com.paytrust.payroll.controller;

import com.paytrust.payroll.model.Payroll;
import com.paytrust.payroll.repository.PayrollRepository;
import com.paytrust.payroll.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/hr")
public class HRController {

    @Autowired
    private PayrollRepository payrollRepo;

    @Autowired
    private AuditLogRepository auditRepo;

    @PostMapping("/approve/{id}")
    public Payroll approvePayroll(@PathVariable Long id, @RequestParam String hrName) {
        Payroll payroll = payrollRepo.findById(id).orElseThrow();
        payroll.setNetPay(payroll.getBasicSalary() + payroll.getAllowances() - payroll.getDeductions());
        payrollRepo.save(payroll);
        auditRepo.save(new com.paytrust.payroll.model.AuditLog(null,"HR approved payroll id "+id, hrName, null));
        return payroll;
    }

    @GetMapping("/{companyId}")
    public List<Payroll> getCompanyPayrolls(@PathVariable Long companyId) {
        return payrollRepo.findByEmployee_Company_Id(companyId);
    }
}
