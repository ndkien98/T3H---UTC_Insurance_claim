package com.t3h.insuranceclaim.service.impl;

import com.t3h.insuranceclaim.dto.UserDTO;
import com.t3h.insuranceclaim.mapper.UserMapper;
import com.t3h.insuranceclaim.repository.UserRepository;
import com.t3h.insuranceclaim.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO getUserByUsername(String username) {
        return userMapper.toDto(userRepository.findByUsername(username));
    }

    @Override
    public UserDTO getProfileUser() {
        return null;
    }


}
