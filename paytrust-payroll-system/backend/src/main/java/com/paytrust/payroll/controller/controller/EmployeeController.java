package com.paytrust.payroll.controller;

import com.paytrust.payroll.model.Employee;
import com.paytrust.payroll.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/superadmin/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeRepository repository;

    @GetMapping
    public List<Employee> getAll() { return repository.findAll(); }

    @PostMapping
    public Employee create(@RequestBody Employee emp) { return repository.save(emp); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { repository.deleteById(id); }
}
