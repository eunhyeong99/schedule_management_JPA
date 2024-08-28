package com.sparta.schedule_management_jpa.dto;

import com.sparta.schedule_management_jpa.domain.Timestamped;
import com.sparta.schedule_management_jpa.domain.UserRoleEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class UserDto extends Timestamped {
    private Long id;
    private String username;
    private String email;
    private String password;
    private UserRoleEnum role; // UserRoleEnum 추가
    private boolean admin = false;
    private String adminToken = "";



    public UserDto(Long id,String username, String email, String password, UserRoleEnum role, boolean admin, String adminToken) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.admin = admin;
    }

    public UserDto(Long id, String username, String email) {
       this.id = id;
       this.username = username;
       this.email = email;
    }
}
