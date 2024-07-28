package com.t3h.insuranceclaim.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class ClaimDTO {

    private Long id;
    private String claimCode;
    private String customerName;
    private String insuranceProductName;
    private LocalDate claimDate;
    private String description;
    private String status;
    private String statusDescription;
    private Double amount;


}
