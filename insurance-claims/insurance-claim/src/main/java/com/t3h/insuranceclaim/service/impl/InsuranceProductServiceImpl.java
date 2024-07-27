package com.t3h.insuranceclaim.service.impl;

import com.t3h.insuranceclaim.dto.InsuranceProductDTO;
import com.t3h.insuranceclaim.entity.InsuranceProductEntity;
import com.t3h.insuranceclaim.mapper.InsuranceProductMapper;
import com.t3h.insuranceclaim.repository.InsuranceProductRepository;
import com.t3h.insuranceclaim.service.InsuranceProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InsuranceProductServiceImpl implements InsuranceProductService {

    @Autowired
    private InsuranceProductRepository insuranceproductRepository;

    @Autowired
    private InsuranceProductMapper insuranceproductMapper;

    @Override
    public List<InsuranceProductDTO> getAll() {
        return insuranceproductRepository.findAll().stream()
                .map(insuranceproductMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public InsuranceProductDTO getById(Long id) {
        InsuranceProductEntity insuranceproduct = insuranceproductRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("InsuranceProduct not found"));
        return insuranceproductMapper.toDTO(insuranceproduct);
    }

    @Override
    public InsuranceProductDTO create(InsuranceProductDTO insuranceproductDTO) {
        InsuranceProductEntity insuranceproduct = insuranceproductMapper.toEntity(insuranceproductDTO);
        insuranceproduct = insuranceproductRepository.save(insuranceproduct);
        return insuranceproductMapper.toDTO(insuranceproduct);
    }

    @Override
    public InsuranceProductDTO update(Long id, InsuranceProductDTO insuranceproductDTO) {
        InsuranceProductEntity insuranceproduct = insuranceproductRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("InsuranceProduct not found"));
        insuranceproduct = insuranceproductMapper.toEntity(insuranceproductDTO);
        insuranceproduct = insuranceproductRepository.save(insuranceproduct);
        return insuranceproductMapper.toDTO(insuranceproduct);
    }

    @Override
    public void delete(Long id) {
        insuranceproductRepository.deleteById(id);
    }
}
