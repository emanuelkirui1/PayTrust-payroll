package com.paytrust.payroll.controller;

import com.paytrust.payroll.service.PayrollBatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/payroll")
@RequiredArgsConstructor
public class PayrollBatchController {

    private final PayrollBatchService payrollBatchService;

    @PostMapping("/pay-all")
    public Map<String,String> payAll(@RequestBody List<String> phoneNumbers, @RequestParam double amount) {
        return payrollBatchService.payAll(phoneNumbers, amount);
    }
}
