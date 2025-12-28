package com.paytrust.payroll.controller.payment;

import com.paytrust.payroll.service.MpesaService;
import com.paytrust.payroll.service.BankPaymentService;
import com.paytrust.payroll.service.PayrollBulkPaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final MpesaService mpesaService;
    private final BankPaymentService bankPaymentService;
    private final PayrollBulkPaymentService bulkPaymentService;

    public PaymentController(MpesaService mpesaService,
                             BankPaymentService bankPaymentService,
                             PayrollBulkPaymentService bulkPaymentService) {
        this.mpesaService = mpesaService;
        this.bankPaymentService = bankPaymentService;
        this.bulkPaymentService = bulkPaymentService;
    }

    @PostMapping("/mpesa")
    public String payMpesa(@RequestParam String phone, @RequestParam double amount) {
        return mpesaService.sendMpesaPayment(phone, amount);
    }

    @PostMapping("/bank")
    public String payBank(@RequestParam String account, @RequestParam double amount) {
        return bankPaymentService.sendBankPayment(account, amount);
    }

    @PostMapping("/bulk/{companyId}")
    public String payAllEmployees(@PathVariable Long companyId) {
        return bulkPaymentService.payAllEmployees(companyId);
    }
}
