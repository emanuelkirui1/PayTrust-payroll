package com.paytrust.payroll.service;

import com.paytrust.payroll.config.MpesaConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.Base64;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MpesaService {

    private final MpesaConfig config;

    // Generate OAuth Token
    public String generateToken() {
        WebClient client = WebClient.create(config.authUrl());
        String token = client.get()
                .headers(h -> h.setBasicAuth(config.getConsumerKey(), config.getConsumerSecret()))
                .retrieve()
                .bodyToMono(Map.class)
                .block()
                .get("access_token").toString();
        return token;
    }

    // STK Push Request
    public String stkPush(String phone, double amount) {
        String token = generateToken();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String password = Base64.getEncoder().encodeToString(
                (config.getShortcode() + config.getPasskey() + timestamp).getBytes()
        );

        Map<String,Object> payload = Map.of(
            "BusinessShortCode", config.getShortcode(),
            "Password", password,
            "Timestamp", timestamp,
            "TransactionType", "CustomerPayBillOnline",
            "Amount", amount,
            "PartyA", phone,
            "PartyB", config.getShortcode(),
            "PhoneNumber", phone,
            "CallBackURL", config.getCallbackUrl(),
            "AccountReference", "Payroll",
            "TransactionDesc", "Salary Payment"
        );

        WebClient client = WebClient.create(config.stkPushUrl());
        Map response = client.post()
                .header("Authorization", "Bearer " + token)
                .bodyValue(payload)
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        return response.toString();
    }
}
