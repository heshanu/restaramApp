package com.restaturant.restaturant.springboot.dto;

import com.restaturant.restaturant.springboot.enums.UserRoleEnum;
import lombok.Data;

@Data
public class AuthenticationResponse {
    private String jwt;
    private UserRoleEnum userRole;
    private Long userId;
}
