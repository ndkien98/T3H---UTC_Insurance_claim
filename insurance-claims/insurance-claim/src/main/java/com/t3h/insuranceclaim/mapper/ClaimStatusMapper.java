package com.t3h.insuranceclaim.mapper;

import com.t3h.insuranceclaim.entity.*;
import com.t3h.insuranceclaim.dto.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClaimStatusMapper {
    ClaimStatusDTO toDTO(ClaimStatus claimstatus);
    ClaimStatus toEntity(ClaimStatusDTO claimstatusDTO);
}
