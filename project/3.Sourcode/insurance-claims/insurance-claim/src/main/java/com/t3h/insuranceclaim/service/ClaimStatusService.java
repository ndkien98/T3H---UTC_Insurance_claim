package com.t3h.insuranceclaim.service;

import com.t3h.insuranceclaim.dto.ClaimStatusDTO;

import java.util.List;

public interface ClaimStatusService {
    List<ClaimStatusDTO> getAll();
    ClaimStatusDTO getById(Long id);
    ClaimStatusDTO create(ClaimStatusDTO claimstatusDTO);
    ClaimStatusDTO update(Long id, ClaimStatusDTO claimstatusDTO);
    void delete(Long id);
}
