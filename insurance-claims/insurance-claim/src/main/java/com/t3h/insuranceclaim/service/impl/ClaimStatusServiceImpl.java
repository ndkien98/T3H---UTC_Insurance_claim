package com.t3h.insuranceclaim.service.impl;

import com.t3h.insuranceclaim.dto.ClaimStatusDTO;
import com.t3h.insuranceclaim.entity.ClaimStatusEntity;
import com.t3h.insuranceclaim.mapper.ClaimStatusMapper;
import com.t3h.insuranceclaim.repository.ClaimStatusRepository;
import com.t3h.insuranceclaim.service.ClaimStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClaimStatusServiceImpl implements ClaimStatusService {

    @Autowired
    private ClaimStatusRepository claimstatusRepository;

    @Autowired
    private ClaimStatusMapper claimstatusMapper;

    @Override
    public List<ClaimStatusDTO> getAll() {
        return claimstatusRepository.findAll().stream()
                .map(claimstatusMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClaimStatusDTO getById(Long id) {
        ClaimStatusEntity claimstatus = claimstatusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ClaimStatus not found"));
        return claimstatusMapper.toDTO(claimstatus);
    }

    @Override
    public ClaimStatusDTO create(ClaimStatusDTO claimstatusDTO) {
        ClaimStatusEntity claimstatus = claimstatusMapper.toEntity(claimstatusDTO);
        claimstatus = claimstatusRepository.save(claimstatus);
        return claimstatusMapper.toDTO(claimstatus);
    }

    @Override
    public ClaimStatusDTO update(Long id, ClaimStatusDTO claimstatusDTO) {
        ClaimStatusEntity claimstatus = claimstatusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ClaimStatus not found"));
        claimstatus = claimstatusMapper.toEntity(claimstatusDTO);
        claimstatus = claimstatusRepository.save(claimstatus);
        return claimstatusMapper.toDTO(claimstatus);
    }

    @Override
    public void delete(Long id) {
        claimstatusRepository.deleteById(id);
    }
}
