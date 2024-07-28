package com.t3h.insuranceclaim.service;

import com.t3h.insuranceclaim.dto.ClaimDTO;
import com.t3h.insuranceclaim.dto.request.ClaimRequest;
import com.t3h.insuranceclaim.dto.response.ResponsePage;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClaimService {
    ClaimDTO getById(Long id);
    ClaimDTO create(ClaimDTO claimDTO);
    ClaimDTO update(Long id, ClaimDTO claimDTO);
    void delete(Long id);

    ResponsePage<List<ClaimDTO>> getAllClaims(ClaimRequest claimRequest, Pageable pageable);
}
