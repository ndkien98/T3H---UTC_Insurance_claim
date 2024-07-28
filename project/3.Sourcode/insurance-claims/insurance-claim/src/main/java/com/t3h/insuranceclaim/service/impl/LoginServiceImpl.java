package com.t3h.insuranceclaim.service.impl;

import com.t3h.insuranceclaim.mapper.UserMapper;
import com.t3h.insuranceclaim.repository.UserRepository;
import com.t3h.insuranceclaim.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

}
