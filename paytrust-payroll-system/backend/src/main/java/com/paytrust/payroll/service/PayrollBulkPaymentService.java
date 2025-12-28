package com.paytrust.payroll.service;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PayrollBulkPaymentService {

    private final MpesaService mpesaService;
    private final BankPaymentService bankPaymentService;

    public PayrollBulkPaymentService(MpesaService mpesaService, BankPaymentService bankPaymentService) {
        this.mpesaService = mpesaService;
        this.bankPaymentService = bankPaymentService;
    }

    public String payAllEmployees(Long companyId) {
        List<String> mockEmployeeContacts = List.of("0712345678", "0745123456");
        double salary = 20000; // Example static salary

        mockEmployeeContacts.forEach(phone -> mpesaService.sendMpesaPayment(phone, salary));

        return "🔥 ALL_EMPLOYEES_PAID_SUCCESSFULLY for company ID: " + companyId;
    }
}
