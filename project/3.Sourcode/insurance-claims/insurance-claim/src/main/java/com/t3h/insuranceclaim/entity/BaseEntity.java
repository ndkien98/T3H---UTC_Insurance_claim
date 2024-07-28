package com.t3h.insuranceclaim.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdDate;
    private String createdBy;
    private LocalDateTime lastModifiedDate;
    private String lastModifiedBy;
    private Boolean deleted = false;

    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        lastModifiedDate = LocalDateTime.now();
    }


}
