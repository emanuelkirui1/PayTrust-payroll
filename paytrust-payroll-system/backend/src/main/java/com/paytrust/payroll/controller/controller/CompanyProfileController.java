package com.paytrust.payroll.controller;

import com.paytrust.payroll.model.CompanyProfile;
import com.paytrust.payroll.repository.CompanyProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/superadmin/company")
@RequiredArgsConstructor
public class CompanyProfileController {

    private final CompanyProfileRepository repository;

    @GetMapping
    public CompanyProfile getProfile() {
        return repository.findAll().stream().findFirst().orElse(null);
    }

    @PostMapping
    public CompanyProfile saveOrUpdate(@RequestBody CompanyProfile profile) {
        return repository.save(profile);
    }
}
