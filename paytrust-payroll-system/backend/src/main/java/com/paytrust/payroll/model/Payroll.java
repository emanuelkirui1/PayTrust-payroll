package com.paytrust.payroll.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private double basicSalary;
    private double allowances;
    private double deductions;
    private double netPay;
    private int paidLeaveDays;
    private int unpaidLeaveDays;
    private String month;
}
