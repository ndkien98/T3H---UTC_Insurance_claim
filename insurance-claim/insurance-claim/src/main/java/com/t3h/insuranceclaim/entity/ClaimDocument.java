
package com.t3h.insuranceclaim.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class ClaimDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "claim_id")
    private Claim claim;

    private String documentType;
    private String documentName;
    private String filePath;
    private LocalDate uploadDate;
    private LocalDateTime createdDate;
    private String createdBy;
    private LocalDateTime lastModifiedDate;
    private String lastModifiedBy;
    private Boolean deleted;

    // Getters and Setters
}
