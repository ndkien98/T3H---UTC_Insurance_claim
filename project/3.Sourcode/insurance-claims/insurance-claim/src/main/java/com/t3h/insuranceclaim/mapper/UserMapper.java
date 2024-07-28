package com.t3h.insuranceclaim.mapper;


import com.t3h.insuranceclaim.dto.UserDTO;
import com.t3h.insuranceclaim.entity.UserEntity;
import com.t3h.insuranceclaim.mapper.decorator.UserMapperDecorator;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
@DecoratedWith(UserMapperDecorator.class)
public interface UserMapper {

    UserDTO toDto(UserEntity userEntity);
    UserEntity toEntity(UserDTO userDTO);
}
