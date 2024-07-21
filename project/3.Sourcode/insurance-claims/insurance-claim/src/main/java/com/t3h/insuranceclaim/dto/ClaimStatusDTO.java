package com.t3h.insuranceclaim.dto;

public class ClaimStatusDTO {

    private Long id;
    private String statusName;
    private String description;
    
    // Getters and setters for each field
    public Long getId() { return id; }
    public String getStatusname() { return statusName; }
    public String getDescription() { return description; }
    public void setId(Long id) { this.id = id; }
    public void setStatusname(String statusName) { this.statusName = statusName; }
    public void setDescription(String description) { this.description = description; }
}
