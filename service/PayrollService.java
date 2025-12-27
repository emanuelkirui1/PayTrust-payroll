package com.paytrust.payroll.service;

import com.paytrust.payroll.model.Payroll;
import com.paytrust.payroll.model.Employee;
import com.paytrust.payroll.repository.PayrollRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PayrollService {

    private final PayrollRepository payrollRepository;

    public Payroll generatePayroll(Employee emp, double overtime) {
        double netPay = emp.getBasicSalary() + emp.getAllowances() + overtime - emp.getDeductions();

        Payroll payroll = Payroll.builder()
                .employee(emp)
                .basicSalary(emp.getBasicSalary())
                .allowances(emp.getAllowances())
                .deductions(emp.getDeductions())
                .overtime(overtime)
                .netPay(netPay)
                .payDate(LocalDate.now())
                .build();

        return payrollRepository.save(payroll);
    }
}
