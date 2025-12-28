package com.paytrust.payroll.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String planName;          // Basic, Standard, Enterprise
    private Double pricePerEmployee;  // e.g. 50 KES per employee
    private Double basePrice;         // minimum monthly cost (e.g. 2,000 KES)
}
