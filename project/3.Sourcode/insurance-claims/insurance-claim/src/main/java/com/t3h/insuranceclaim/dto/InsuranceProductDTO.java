package com.t3h.insuranceclaim.dto;

import java.math.BigDecimal;

public class InsuranceProductDTO {

    private Long id;
    private String name;
    private String description;
    private BigDecimal premium;
    private BigDecimal coverage;
    
    // Getters and setters for each field
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public BigDecimal getPremium() { return premium; }
    public BigDecimal getCoverage() { return coverage; }
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setPremium(BigDecimal premium) { this.premium = premium; }
    public void setCoverage(BigDecimal coverage) { this.coverage = coverage; }
}
