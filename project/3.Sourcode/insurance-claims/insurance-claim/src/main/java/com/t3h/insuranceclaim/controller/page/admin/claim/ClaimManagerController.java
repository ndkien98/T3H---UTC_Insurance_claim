package com.t3h.insuranceclaim.controller.page.admin.claim;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/")
public class ClaimManagerController {


    @GetMapping("claim-manager")
    public String claimManager() {
        return "admin/claim/claim-manager";
    }

    @GetMapping("claim/{id}")
    public String claim(@PathVariable int id) {
        return "admin/claim/detail-claim";
    }
}
