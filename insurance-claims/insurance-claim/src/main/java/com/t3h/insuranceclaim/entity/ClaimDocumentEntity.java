
package com.t3h.insuranceclaim.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "claim_document")
@Getter
@Setter
public class ClaimDocumentEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "claim_id")
    private ClaimEntity claimEntity;

    private String documentType;
    private String documentName;
    private String filePath;
    private LocalDate uploadDate;

    public ClaimDocumentEntity() {

    }


    // Getters and Setters
}
