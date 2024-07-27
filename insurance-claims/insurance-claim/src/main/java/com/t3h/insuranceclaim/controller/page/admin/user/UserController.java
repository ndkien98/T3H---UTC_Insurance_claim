package com.t3h.insuranceclaim.controller.page.admin.user;

import com.t3h.insuranceclaim.dto.UserDTO;
import com.t3h.insuranceclaim.entity.UserEntity;
import com.t3h.insuranceclaim.security.SecurityUtils;
import com.t3h.insuranceclaim.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("profile")
    public String profile(Model model) {
        UserDTO userDTO = userService.getProfileUser();
        model.addAttribute("userDto", userDTO);
        return "user/profile";
    }
}
