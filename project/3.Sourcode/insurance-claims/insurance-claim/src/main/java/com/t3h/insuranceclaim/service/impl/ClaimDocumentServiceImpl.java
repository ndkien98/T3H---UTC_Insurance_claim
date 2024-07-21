package com.t3h.insuranceclaim.service.impl;

import com.t3h.insuranceclaim.dto.ClaimDocumentDTO;
import com.t3h.insuranceclaim.entity.ClaimDocument;
import com.t3h.insuranceclaim.mapper.ClaimDocumentMapper;
import com.t3h.insuranceclaim.repository.ClaimDocumentRepository;
import com.t3h.insuranceclaim.service.ClaimDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClaimDocumentServiceImpl implements ClaimDocumentService {

    @Autowired
    private ClaimDocumentRepository claimdocumentRepository;

    @Autowired
    private ClaimDocumentMapper claimdocumentMapper;

    @Override
    public List<ClaimDocumentDTO> getAll() {
        return claimdocumentRepository.findAll().stream()
                .map(claimdocumentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClaimDocumentDTO getById(Long id) {
        ClaimDocument claimdocument = claimdocumentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ClaimDocument not found"));
        return claimdocumentMapper.toDTO(claimdocument);
    }

    @Override
    public ClaimDocumentDTO create(ClaimDocumentDTO claimdocumentDTO) {
        ClaimDocument claimdocument = claimdocumentMapper.toEntity(claimdocumentDTO);
        claimdocument = claimdocumentRepository.save(claimdocument);
        return claimdocumentMapper.toDTO(claimdocument);
    }

    @Override
    public ClaimDocumentDTO update(Long id, ClaimDocumentDTO claimdocumentDTO) {
        ClaimDocument claimdocument = claimdocumentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ClaimDocument not found"));
        claimdocument = claimdocumentMapper.toEntity(claimdocumentDTO);
        claimdocument = claimdocumentRepository.save(claimdocument);
        return claimdocumentMapper.toDTO(claimdocument);
    }

    @Override
    public void delete(Long id) {
        claimdocumentRepository.deleteById(id);
    }
}
