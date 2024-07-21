package com.t3h.insuranceclaim.dto;

import java.time.LocalDate;

public class ClaimDTO {

    private Long id;
    private String description;
    private String status;
    private Long customerId;
    private Long productId;
    private LocalDate date;
    
    // Getters and setters for each field
    public Long getId() { return id; }
    public String getDescription() { return description; }
    public String getStatus() { return status; }
    public Long getCustomerid() { return customerId; }
    public Long getProductid() { return productId; }
    public LocalDate getDate() { return date; }
    public void setId(Long id) { this.id = id; }
    public void setDescription(String description) { this.description = description; }
    public void setStatus(String status) { this.status = status; }
    public void setCustomerid(Long customerId) { this.customerId = customerId; }
    public void setProductid(Long productId) { this.productId = productId; }
    public void setDate(LocalDate date) { this.date = date; }
}
