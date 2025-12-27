package com.paytrust.payroll.controller;

import com.paytrust.payroll.model.Payroll;
import com.paytrust.payroll.repository.PayrollRepository;
import com.paytrust.payroll.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/accountant")
public class AccountantController {

    @Autowired
    private PayrollRepository payrollRepo;

    @Autowired
    private AuditLogRepository auditRepo;

    @PostMapping("/pay/{id}")
    public Payroll executePayment(@PathVariable Long id, @RequestParam String accountantName) {
        Payroll payroll = payrollRepo.findById(id).orElseThrow();
        // mark as paid
        auditRepo.save(new com.paytrust.payroll.model.AuditLog(null,"Accountant executed payment for payroll id "+id, accountantName, null));
        return payroll;
    }

    @GetMapping("/{companyId}")
    public List<Payroll> getCompanyPayrolls(@PathVariable Long companyId) {
        return payrollRepo.findByEmployee_Company_Id(companyId);
    }
}
