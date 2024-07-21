
package com.t3h.insuranceclaim.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private InsuranceProduct insuranceProduct;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private ClaimStatus claimStatus;

    private LocalDate claimDate;
    private String description;
    private double account;
    private LocalDateTime createdDate;
    private String createdBy;
    private LocalDateTime lastModifiedDate;
    private String lastModifiedBy;
    private Boolean deleted;

    // Getters and Setters


}
