package com.t3h.insuranceclaim.mapper;

import com.t3h.insuranceclaim.dto.ClaimDocumentDTO;
import com.t3h.insuranceclaim.entity.ClaimDocumentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClaimDocumentMapper {
    ClaimDocumentDTO toDTO(ClaimDocumentEntity claimdocument);
    ClaimDocumentEntity toEntity(ClaimDocumentDTO claimdocumentDTO);
}
