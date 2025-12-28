package com.paytrust.payroll.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PayrollBatchService {

    private final MpesaService mpesaService;

    public Map<String, String> payAll(List<String> phoneNumbers, double amountPerEmployee) {
        return phoneNumbers.stream().collect(
                Collectors.toMap(
                        phone -> phone,
                        phone -> mpesaService.stkPush(phone, amountPerEmployee)
                )
        );
    }
}
