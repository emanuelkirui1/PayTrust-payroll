package com.paytrust.payroll.controller;

import com.paytrust.payroll.model.CompanyProfile;
import com.paytrust.payroll.repository.CompanyProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/superadmin/company")
public class CompanyProfileController {

    @Autowired
    private CompanyProfileRepository repo;

    @GetMapping
    public CompanyProfile getCompany() {
        return repo.findAll().stream().findFirst().orElse(null);
    }

    @PostMapping
    public CompanyProfile createOrUpdate(@RequestBody CompanyProfile profile) {
        repo.deleteAll(); // only one profile allowed
        return repo.save(profile);
    }
}
