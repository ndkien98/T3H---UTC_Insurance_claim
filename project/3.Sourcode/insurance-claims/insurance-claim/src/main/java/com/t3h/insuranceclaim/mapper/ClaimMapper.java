package com.t3h.insuranceclaim.mapper;

import com.t3h.insuranceclaim.dto.ClaimDTO;
import com.t3h.insuranceclaim.entity.ClaimEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClaimMapper {
    @Mapping(source = "code", target = "claimCode")
    @Mapping(source = "customerEntity.name", target = "customerName")
    @Mapping(source = "insuranceProductEntity.name", target = "insuranceProductName")
    @Mapping(source = "claimStatusEntity.code", target = "status")
    @Mapping(source = "claimStatusEntity.description", target = "statusDescription")
    ClaimDTO toDTO(ClaimEntity entity);

//
//    @Mapping(target = "status.code", source = "status")
//    @Mapping(target = "customer.name", source = "customerName")
//    @Mapping(target = "insuranceProduct.name", source = "insuranceProductName")
    ClaimEntity toEntity(ClaimDTO dto);
}
