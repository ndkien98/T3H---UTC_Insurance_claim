
package com.t3h.insuranceclaim.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "claim")
@Getter
@Setter
public class ClaimEntity extends BaseEntity {

    private String code;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private InsuranceProductEntity insuranceProductEntity;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private ClaimStatusEntity claimStatusEntity;

    private LocalDate claimDate;
    private String description;
    private Double amount;

    public ClaimEntity() {

    }
    // Getters and Setters
}
