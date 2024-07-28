package com.t3h.insuranceclaim.dto.response;

import lombok.Data;

@Data
public class ResponsePage <T>{
    private T content;
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private int totalPages;
}
