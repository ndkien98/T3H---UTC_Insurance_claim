package com.t3h.insuranceclaim.controller.page.guest;

import com.t3h.insuranceclaim.security.SecurityUtils;
import com.t3h.insuranceclaim.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    public String login() {
        return "guest/loginmetlife";
    }

    @GetMapping("/process-after-login")
    public String preLogin(Model model) {
        String urlRedirect = loginService.preLogin(model);
        return urlRedirect;
    }
}
