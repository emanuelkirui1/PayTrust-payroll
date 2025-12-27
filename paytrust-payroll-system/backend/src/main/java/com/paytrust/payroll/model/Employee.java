package com.paytrust.payroll.model;
import jakarta.persistence.*;

@Entity
@Table(name="employees")
public class Employee {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    private String firstName, lastName, email, phone, position;
}
