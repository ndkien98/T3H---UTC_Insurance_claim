package com.t3h.insuranceclaim.mapper.decorator;

import com.t3h.insuranceclaim.dto.UserDTO;
import com.t3h.insuranceclaim.entity.UserEntity;
import com.t3h.insuranceclaim.mapper.RoleMapper;
import com.t3h.insuranceclaim.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public abstract class UserMapperDecorator implements UserMapper {

    @Autowired
    @Qualifier("delegate")
    private UserMapper delegate;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserDTO toDto(UserEntity userEntity) {
        UserDTO userDTO = delegate.toDto(userEntity);
        userDTO.setRoles(roleMapper.toRoleDTOSet(userEntity.getRoles()));
        return userDTO;
    }

    @Override
    public UserEntity toEntity(UserDTO userDTO) {
        UserEntity userEntity = delegate.toEntity(userDTO);
        userEntity.setRoles(roleMapper.toRoleEntitySet(userDTO.getRoles()));
        return userEntity;
    }
}
