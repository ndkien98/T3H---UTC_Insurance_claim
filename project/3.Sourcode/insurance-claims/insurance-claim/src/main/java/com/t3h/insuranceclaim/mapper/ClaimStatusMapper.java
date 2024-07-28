package com.t3h.insuranceclaim.mapper;

import com.t3h.insuranceclaim.dto.ClaimStatusDTO;
import com.t3h.insuranceclaim.entity.ClaimStatusEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClaimStatusMapper {
    ClaimStatusDTO toDTO(ClaimStatusEntity claimstatus);
    ClaimStatusEntity toEntity(ClaimStatusDTO claimstatusDTO);
}
