package com.t3h.insuranceclaim.mapper;

import com.t3h.insuranceclaim.dto.InsuranceProductDTO;
import com.t3h.insuranceclaim.entity.InsuranceProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InsuranceProductMapper {
    InsuranceProductDTO toDTO(InsuranceProductEntity insuranceproduct);
    InsuranceProductEntity toEntity(InsuranceProductDTO insuranceproductDTO);
}
