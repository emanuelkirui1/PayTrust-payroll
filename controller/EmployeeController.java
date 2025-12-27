package com.paytrust.payroll.controller;

import com.paytrust.payroll.model.Employee;
import com.paytrust.payroll.repository.EmployeeRepository;
import com.paytrust.payroll.service.AuditService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final AuditService auditService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        auditService.logAction("Added employee: " + employee.getFirstName(), "System");
        return employeeRepository.save(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Employee emp = employeeRepository.findById(id).orElseThrow();
        emp.setFirstName(employeeDetails.getFirstName());
        emp.setLastName(employeeDetails.getLastName());
        emp.setEmail(employeeDetails.getEmail());
        emp.setPhone(employeeDetails.getPhone());
        emp.setPosition(employeeDetails.getPosition());
        emp.setBasicSalary(employeeDetails.getBasicSalary());
        emp.setAllowances(employeeDetails.getAllowances());
        emp.setDeductions(employeeDetails.getDeductions());
        emp.setBankName(employeeDetails.getBankName());
        emp.setBankAccountNumber(employeeDetails.getBankAccountNumber());

        auditService.logAction("Updated employee: " + emp.getFirstName(), "System");
        return employeeRepository.save(emp);
    }
}
