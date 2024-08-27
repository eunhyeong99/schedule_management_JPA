package com.sparta.schedule_management_jpa.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public UserDto(Long id, String email, String username, LocalDateTime createdDate) {
        this.id = id;
        this.email = email;
        this.username = username;
    }
}
