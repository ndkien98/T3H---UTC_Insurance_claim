package com.t3h.insuranceclaim.service.impl;

import com.t3h.insuranceclaim.dto.UserDTO;
import com.t3h.insuranceclaim.entity.UserEntity;
import com.t3h.insuranceclaim.mapper.UserMapper;
import com.t3h.insuranceclaim.repository.UserRepository;
import com.t3h.insuranceclaim.security.SecurityUtils;
import com.t3h.insuranceclaim.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String preLogin(Model model) {
        List<String> roles = SecurityUtils.getCurrentUserRoles();
        boolean isAdmin = roles.contains(SecurityUtils.PREFIX_ROLE + SecurityUtils.Role.ADMIN.name());
        if (isAdmin){
            return "redirect:/admin/dashboard";
        }
        return "redirect:/user/profile";
    }
}
