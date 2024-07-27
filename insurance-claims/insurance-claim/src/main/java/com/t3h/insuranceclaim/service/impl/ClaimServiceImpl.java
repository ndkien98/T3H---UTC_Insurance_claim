package com.t3h.insuranceclaim.service.impl;

import com.t3h.insuranceclaim.dto.ClaimDTO;
import com.t3h.insuranceclaim.entity.Claim;
import com.t3h.insuranceclaim.mapper.ClaimMapper;
import com.t3h.insuranceclaim.repository.ClaimRepository;
import com.t3h.insuranceclaim.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClaimServiceImpl implements ClaimService {

    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
    private ClaimMapper claimMapper;

    @Override
    public List<ClaimDTO> getAll() {
        return claimRepository.findAll().stream()
                .map(claimMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClaimDTO getById(Long id) {
        Claim claim = claimRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Claim not found"));
        return claimMapper.toDTO(claim);
    }

    @Override
    public ClaimDTO create(ClaimDTO claimDTO) {
        Claim claim = claimMapper.toEntity(claimDTO);
        claim = claimRepository.save(claim);
        return claimMapper.toDTO(claim);
    }

    @Override
    public ClaimDTO update(Long id, ClaimDTO claimDTO) {
        Claim claim = claimRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Claim not found"));
        claim = claimMapper.toEntity(claimDTO);
        claim = claimRepository.save(claim);
        return claimMapper.toDTO(claim);
    }

    @Override
    public void delete(Long id) {
        claimRepository.deleteById(id);
    }
}
