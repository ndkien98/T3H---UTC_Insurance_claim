package com.t3h.insuranceclaim.controller.resource;

import com.t3h.insuranceclaim.dto.UserDTO;
import com.t3h.insuranceclaim.dto.response.Response;
import com.t3h.insuranceclaim.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource/user/")
public class UserResourceController {

    @Autowired
    private UserService userService;

    @GetMapping("profile")
    public ResponseEntity<Response<UserDTO>> profile() {
        UserDTO userDTO = userService.getProfileUser();
        Response<UserDTO> response = new Response<>();
        response.setData(userDTO);
        response.setCode(HttpStatus.OK.value());
        response.setMessage("Successfully");
        return ResponseEntity.ok(response);
    }
}
