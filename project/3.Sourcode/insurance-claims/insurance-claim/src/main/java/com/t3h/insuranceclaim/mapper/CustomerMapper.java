package com.t3h.insuranceclaim.mapper;

import com.t3h.insuranceclaim.dto.CustomerDTO;
import com.t3h.insuranceclaim.entity.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO toDTO(CustomerEntity customerEntity);
    CustomerEntity toEntity(CustomerDTO customerDTO);
}
