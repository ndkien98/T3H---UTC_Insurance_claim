package com.t3h.insuranceclaim.controller.page.cms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DashboardController {


    @GetMapping("cms/dashboard")
    public String getDashboard() {
        return "cms/dashboard";
    }

    @PostMapping({"cms/","admin"})
    public String getHome() {
        return "redirect:/cms/dashboard";
    }

}
