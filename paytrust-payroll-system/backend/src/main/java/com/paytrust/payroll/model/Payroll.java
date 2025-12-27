package com.paytrust.payroll.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="payrolls")
public class Payroll {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @ManyToOne private Employee employee;
    private Double grossSalary, netSalary;
    private String payPeriod;
    @OneToMany(mappedBy="payroll", cascade=CascadeType.ALL) private List<Allowance> allowances;
    @OneToMany(mappedBy="payroll", cascade=CascadeType.ALL) private List<Deduction> deductions;
}
