package com.paytrust.payroll.controller;

import com.paytrust.payroll.model.User;
import com.paytrust.payroll.service.SuperAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/superadmin")
@RequiredArgsConstructor
public class SuperAdminController {

    private final SuperAdminService superAdminService;

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return superAdminService.createUser(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return superAdminService.getAllUsers();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        superAdminService.deleteUser(id);
    }
}
