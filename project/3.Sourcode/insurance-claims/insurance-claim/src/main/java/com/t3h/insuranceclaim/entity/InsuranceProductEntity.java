
package com.t3h.insuranceclaim.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "insurance_product")
@Getter
@Setter
public class InsuranceProductEntity extends BaseEntity {

    private String name;
    private String description;
    private String coverage;
    // Getters and Setters
}
