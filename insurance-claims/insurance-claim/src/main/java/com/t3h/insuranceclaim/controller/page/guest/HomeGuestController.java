package com.t3h.insuranceclaim.controller.page.guest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeGuestController {

    @GetMapping("/home")
    public String index() {
        return "guest/homeguest"; // Tên của file HTML trong thư mục templates
    }
    @GetMapping("/")
    public String redirectToHome() {
        return "redirect:/home";
    }

}
