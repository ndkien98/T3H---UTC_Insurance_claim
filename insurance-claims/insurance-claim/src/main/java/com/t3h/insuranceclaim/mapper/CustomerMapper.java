package com.t3h.insuranceclaim.mapper;

import com.t3h.insuranceclaim.entity.*;
import com.t3h.insuranceclaim.dto.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO toDTO(CustomerEntity customerEntity);
    CustomerEntity toEntity(CustomerDTO customerDTO);
}
