package com.sparta.schedule_management_jpa.dto;

import com.sparta.schedule_management_jpa.entity.Comment;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ScheduleDto {
    private Long id;
    private Long user_id;
    private String user_name;
    private String user_email;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private List<Comment> comments;

    public ScheduleDto(Long id, List<Comment> comments, String title, Long user, String email, String username, LocalDateTime createdDate) {
        this.id = id;
        this.comments = comments;
        this.title = title;
        this.user_id = user;
        this.user_name = username;
        this.user_email = email;
    }
}
