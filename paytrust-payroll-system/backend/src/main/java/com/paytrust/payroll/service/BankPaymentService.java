package com.paytrust.payroll.service;

import org.springframework.stereotype.Service;

@Service
public class BankPaymentService {

    public String sendBankPayment(String accountNumber, double amount) {
        System.out.println("🏦 Initiating Bank Payment to " + accountNumber + " : KES " + amount);
        return "BANK_PAYMENT_SUCCESS";
    }
}
