package com.paytrust.payroll.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class MpesaConfig {

    @Value("${mpesa.consumer.key}")
    private String consumerKey;

    @Value("${mpesa.consumer.secret}")
    private String consumerSecret;

    @Value("${mpesa.shortcode}")
    private String shortcode;

    @Value("${mpesa.passkey}")
    private String passkey;

    @Value("${mpesa.callback.url}")
    private String callbackUrl;

    public String authUrl() {
        return "https://sandbox.safaricom.co.ke/oauth/v1/generate?grant_type=client_credentials";
    }

    public String stkPushUrl() {
        return "https://sandbox.safaricom.co.ke/mpesa/stkpush/v1/processrequest";
    }
}
