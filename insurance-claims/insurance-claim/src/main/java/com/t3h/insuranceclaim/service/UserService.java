package com.t3h.insuranceclaim.service;

import com.t3h.insuranceclaim.dto.UserDTO;

public interface UserService {
    UserDTO getUserByUsername(String username);

    UserDTO getProfileUser();
}
