package com.t3h.insuranceclaim.service;

import com.t3h.insuranceclaim.dto.ClaimDocumentDTO;

import java.util.List;

public interface ClaimDocumentService {
    List<ClaimDocumentDTO> getAll();
    ClaimDocumentDTO getById(Long id);
    ClaimDocumentDTO create(ClaimDocumentDTO claimdocumentDTO);
    ClaimDocumentDTO update(Long id, ClaimDocumentDTO claimdocumentDTO);
    void delete(Long id);
}
