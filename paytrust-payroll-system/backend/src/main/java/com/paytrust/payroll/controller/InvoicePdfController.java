package com.paytrust.payroll.controller;

import com.paytrust.payroll.service.InvoicePdfService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.ByteArrayInputStream;

@RestController
@RequestMapping("/api/invoice")
@RequiredArgsConstructor
public class InvoicePdfController {

    private final InvoicePdfService invoicePdfService;

    @GetMapping("/pdf")
    public ResponseEntity<byte[]> invoicePdf(
            @RequestParam String company, @RequestParam double amount
    ) throws Exception {

        ByteArrayInputStream pdf = invoicePdfService.generateInvoice(company, amount);

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=invoice.pdf")
                .body(pdf.readAllBytes());
    }
}
