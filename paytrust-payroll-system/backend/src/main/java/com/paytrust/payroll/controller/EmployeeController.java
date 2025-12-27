package com.paytrust.payroll.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/api/superadmin/employees")
public class EmployeeController {

    private List<Map<String,Object>> employees = new ArrayList<>();

    @GetMapping
    public List<Map<String,Object>> getAll() {
        return employees;
    }

    @PostMapping
    public void add(@RequestBody Map<String,Object> e) {
        employees.add(e);
    }
}
