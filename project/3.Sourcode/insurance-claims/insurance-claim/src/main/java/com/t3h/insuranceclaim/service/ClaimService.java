package com.t3h.insuranceclaim.service;

import com.t3h.insuranceclaim.dto.ClaimDTO;

import java.util.List;

public interface ClaimService {
    List<ClaimDTO> getAll();
    ClaimDTO getById(Long id);
    ClaimDTO create(ClaimDTO claimDTO);
    ClaimDTO update(Long id, ClaimDTO claimDTO);
    void delete(Long id);
}
