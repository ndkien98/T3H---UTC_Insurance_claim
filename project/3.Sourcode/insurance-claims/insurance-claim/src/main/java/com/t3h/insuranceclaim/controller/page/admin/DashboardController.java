package com.t3h.insuranceclaim.controller.page.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {


    @GetMapping("admin/dashboard")
    public String getDashboard() {
        return "admin/dashboard";
    }

    @GetMapping("admin/")
    public String getHome() {
        return "redirect:/admin/dashboard";
    }

}
