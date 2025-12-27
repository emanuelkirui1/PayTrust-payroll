package com.paytrust.payroll.controller;

import com.paytrust.payroll.model.Payroll;
import com.paytrust.payroll.model.AuditLog;
import com.paytrust.payroll.repository.PayrollRepository;
import com.paytrust.payroll.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/company/payrolls")
public class PayrollController {

    @Autowired
    private PayrollRepository payrollRepo;

    @Autowired
    private AuditLogRepository auditRepo;

    private void log(String action, String by) {
        auditRepo.save(new AuditLog(null, action, by, null));
    }

    @GetMapping("/{companyId}")
    public List<Payroll> getPayrolls(@PathVariable Long companyId) {
        return payrollRepo.findByEmployee_Company_Id(companyId);
    }

    @PostMapping
    public Payroll add(@RequestBody Payroll payroll) {
        Payroll saved = payrollRepo.save(payroll);
        log("Added payroll for employee "+payroll.getEmployee().getId(),"CompanyAdmin");
        return saved;
    }

    @PutMapping("/{id}")
    public Payroll update(@PathVariable Long id,@RequestBody Payroll payroll) {
        Payroll existing = payrollRepo.findById(id).orElseThrow();
        existing.setBasicSalary(payroll.getBasicSalary());
        existing.setAllowances(payroll.getAllowances());
        existing.setDeductions(payroll.getDeductions());
        existing.setPaidLeaveDays(payroll.getPaidLeaveDays());
        existing.setUnpaidLeaveDays(payroll.getUnpaidLeaveDays());
        existing.setNetPay(payroll.getNetPay());
        Payroll saved = payrollRepo.save(existing);
        log("Updated payroll id "+id,"CompanyAdmin");
        return saved;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        payrollRepo.deleteById(id);
        log("Deleted payroll id "+id,"CompanyAdmin");
    }
}
