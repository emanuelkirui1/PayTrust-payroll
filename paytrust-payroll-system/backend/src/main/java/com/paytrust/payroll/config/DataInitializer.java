package com.paytrust.payroll.config;

import com.paytrust.payroll.model.User;
import com.paytrust.payroll.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    @Override
    public void run(String... args) {
        if (userRepository.findByUsername("superadmin").isEmpty()) {
            userRepository.save(
                User.builder()
                    .username("superadmin")
                    .password("superadmin123")
                    .role("SUPERADMIN")
                    .build()
            );
        }
    }
}
