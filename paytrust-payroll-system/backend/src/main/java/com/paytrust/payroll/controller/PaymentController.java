package com.paytrust.payroll.controller;

import com.paytrust.payroll.service.MpesaService;
import com.paytrust.payroll.service.BankPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final MpesaService mpesaService;
    private final BankPaymentService bankPaymentService;

    @PostMapping("/mpesa")
    public String payMpesa(
            @RequestParam String phone,
            @RequestParam double amount
    ) {
        return mpesaService.sendPayment(phone, amount);
    }

    @PostMapping("/bank")
    public String payBank(
            @RequestParam String account,
            @RequestParam double amount
    ) {
        return bankPaymentService.sendBankTransfer(account, amount);
    }
}
