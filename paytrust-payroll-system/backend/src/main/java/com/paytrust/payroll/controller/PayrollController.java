package com.paytrust.payroll.controller;

import com.paytrust.payroll.model.Payroll;
import com.paytrust.payroll.model.AuditLog;
import com.paytrust.payroll.repository.PayrollRepository;
import com.paytrust.payroll.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/superadmin/payrolls")
public class PayrollController {

    @Autowired
    private PayrollRepository payrollRepo;

    @Autowired
    private AuditLogRepository auditRepo;

    private void logAction(String action, String by) {
        auditRepo.save(new AuditLog(null, action, by, null));
    }

    @GetMapping
    public List<Payroll> getAll() {
        return payrollRepo.findAll();
    }

    @PostMapping
    public Payroll add(@RequestBody Payroll payroll) {
        Payroll saved = payrollRepo.save(payroll);
        logAction("Added payroll for employee " + payroll.getEmployeeId(), "SuperAdmin");
        return saved;
    }

    @PutMapping("/{id}")
    public Payroll update(@PathVariable Long id, @RequestBody Payroll payroll) {
        Payroll existing = payrollRepo.findById(id).orElseThrow();
        existing.setBasicSalary(payroll.getBasicSalary());
        existing.setAllowances(payroll.getAllowances());
        existing.setDeductions(payroll.getDeductions());
        existing.setPaidLeaveDays(payroll.getPaidLeaveDays());
        existing.setUnpaidLeaveDays(payroll.getUnpaidLeaveDays());
        existing.setNetPay(payroll.getNetPay());
        Payroll saved = payrollRepo.save(existing);
        logAction("Updated payroll id " + id, "SuperAdmin");
        return saved;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        payrollRepo.deleteById(id);
        logAction("Deleted payroll id " + id, "SuperAdmin");
    }
}
