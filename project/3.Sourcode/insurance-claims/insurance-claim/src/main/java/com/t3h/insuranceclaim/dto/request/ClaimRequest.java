package com.t3h.insuranceclaim.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ClaimRequest {

    private String claimCode;
    private String fromDate;
    private String toDate;
    private String statusCode;

    private LocalDate fromDateSearch;
    private LocalDate toDateSearch;



}
