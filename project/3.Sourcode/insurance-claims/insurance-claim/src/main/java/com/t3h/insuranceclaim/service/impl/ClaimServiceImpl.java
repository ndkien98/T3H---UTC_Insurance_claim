package com.t3h.insuranceclaim.service.impl;

import com.t3h.insuranceclaim.dto.ClaimDTO;
import com.t3h.insuranceclaim.dto.request.ClaimRequest;
import com.t3h.insuranceclaim.dto.response.ResponsePage;
import com.t3h.insuranceclaim.entity.ClaimEntity;
import com.t3h.insuranceclaim.mapper.ClaimMapper;
import com.t3h.insuranceclaim.repository.ClaimRepository;
import com.t3h.insuranceclaim.service.ClaimService;
import com.t3h.insuranceclaim.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClaimServiceImpl implements ClaimService {

    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
    private ClaimMapper claimMapper;

    @Override
    public ClaimDTO getById(Long id) {
        ClaimEntity claimEntity = claimRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Claim not found"));
        return claimMapper.toDTO(claimEntity);
    }

    @Override
    public ClaimDTO create(ClaimDTO claimDTO) {
        ClaimEntity claimEntity = claimMapper.toEntity(claimDTO);
        claimEntity = claimRepository.save(claimEntity);
        return claimMapper.toDTO(claimEntity);
    }
    @Override
    public ClaimDTO update(Long id, ClaimDTO claimDTO) {
        ClaimEntity claimEntity = claimRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Claim not found"));
        claimEntity = claimMapper.toEntity(claimDTO);
        claimEntity = claimRepository.save(claimEntity);
        return claimMapper.toDTO(claimEntity);
    }

    @Override
    public void delete(Long id) {
        claimRepository.deleteById(id);
    }

    @Override
    public ResponsePage<List<ClaimDTO>> getAllClaims(ClaimRequest claimRequest, Pageable pageable) {
        ResponsePage<List<ClaimDTO>> responsePage = new ResponsePage<>();

        if (claimRequest == null)
            claimRequest = new ClaimRequest();

        LocalDate fromDateSearch = DateUtils.strToDate(claimRequest.getFromDate());
        LocalDate toDateSearch = DateUtils.strToDate(claimRequest.getToDate());
        claimRequest.setFromDateSearch(fromDateSearch);
        claimRequest.setToDateSearch(toDateSearch);

        Page<ClaimEntity> claimEntityPage = claimRepository.findByCondition(claimRequest,pageable);

        List<ClaimDTO> claimDTOS = claimEntityPage.getContent().stream().map(claimMapper::toDTO).toList();
        responsePage.setPageNumber(pageable.getPageNumber());
        responsePage.setPageSize(pageable.getPageSize());
        responsePage.setTotalElements(claimEntityPage.getTotalElements());
        responsePage.setTotalPages(claimEntityPage.getTotalPages());
        responsePage.setContent(claimDTOS);
        return responsePage;
    }
}
