package com.restaturant.restaturant.springboot.dto;

import com.restaturant.restaturant.springboot.enums.UserRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
public class UserDTO {
    private Long id;
    private String name;
    private String password;
    private String email;
    private UserRoleEnum userRole;
}
