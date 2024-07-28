
package com.t3h.insuranceclaim.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "claim_document")
@Getter
@Setter
public class ClaimDocument extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "claim_id")
    private ClaimEntity claimEntity;

    private String documentType;
    private String documentName;
    private String filePath;
    private LocalDate uploadDate;

    public ClaimDocument() {

    }


    // Getters and Setters
}
