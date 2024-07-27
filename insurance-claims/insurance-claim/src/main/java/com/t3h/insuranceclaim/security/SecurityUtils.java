package com.t3h.insuranceclaim.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class SecurityUtils {

    public static Authentication authentication;

    public static List<String> getCurrentUserRoles() {
        if (authentication == null){
            authentication = SecurityContextHolder.getContext().getAuthentication();
        }
        if (authentication != null && authentication.isAuthenticated()) {
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            return authorities.stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());
        }

        return List.of(); // Trả về danh sách trống nếu không có authentication hoặc không authenticated
    }

    public static String getCurrentUserName() {
        if (authentication == null){
            authentication = SecurityContextHolder.getContext().getAuthentication();
        }
        if (authentication != null && authentication.isAuthenticated()) {
            return authentication.getName();
        }
        return "";
    }
    public static enum Role {
        ADMIN(1),
        USER(2);

        private final int roleId;

        Role(int roleId) {
            this.roleId = roleId;
        }

        public int getRoleId() {
            return roleId;
        }
    }

    public static final String PREFIX_ROLE="ROLE_";

}
