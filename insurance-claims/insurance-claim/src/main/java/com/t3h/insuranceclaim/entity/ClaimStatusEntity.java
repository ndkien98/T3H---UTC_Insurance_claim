
package com.t3h.insuranceclaim.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "claim_status")
@Getter
@Setter
public class ClaimStatusEntity extends BaseEntity {

    private String status;


    public ClaimStatusEntity() {

    }

    // Getters and Setters
}
