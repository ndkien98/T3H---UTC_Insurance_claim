package com.t3h.insuranceclaim.service;

import com.t3h.insuranceclaim.dto.InsuranceProductDTO;

import java.util.List;

public interface InsuranceProductService {
    List<InsuranceProductDTO> getAll();
    InsuranceProductDTO getById(Long id);
    InsuranceProductDTO create(InsuranceProductDTO insuranceproductDTO);
    InsuranceProductDTO update(Long id, InsuranceProductDTO insuranceproductDTO);
    void delete(Long id);
}
