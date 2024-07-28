
package com.t3h.insuranceclaim.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Data;
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
