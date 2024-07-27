package com.t3h.insuranceclaim.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class UserDTO {

    private Long id;
    private String username;
    private String password;
    private String code;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    Set<RoleDTO> roles = new HashSet<>();

    private LocalDate createdDate;
    private String createdBy;
    private LocalDate lastModifiedDate;
    private String lastModifiedBy;
    private Boolean deleted = false;
}
