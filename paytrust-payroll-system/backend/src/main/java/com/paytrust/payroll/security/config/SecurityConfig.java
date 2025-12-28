package com.paytrust.payroll.security.config;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll()
                .requestMatchers("/api/superadmin/**").hasRole("SUPER_ADMIN")
                .requestMatchers("/api/company/**").hasRole("COMPANY_ADMIN")
                .requestMatchers("/api/hr/**").hasRole("HR")
                .requestMatchers("/api/accountant/**").hasRole("ACCOUNTANT")
                .anyRequest().authenticated()
            );

        return http.build();
    }
}
