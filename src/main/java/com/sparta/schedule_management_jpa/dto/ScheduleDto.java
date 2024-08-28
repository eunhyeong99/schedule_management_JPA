package com.sparta.schedule_management_jpa.dto;

import com.sparta.schedule_management_jpa.domain.Comment;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ScheduleDto {
    private Long id;
    private String title;
    private String content;
    private List<UserDto> users;

    public ScheduleDto(Long id, String title, String content, List<UserDto> users) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.users = users;
    }
}
