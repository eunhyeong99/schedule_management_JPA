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
    private String username;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private List<CommentDto> comments;

    public ScheduleDto(Long id, List<Comment> comments, String title, String username, LocalDateTime createdDate) {
        this.id = id;
        this.comments = comments;
        this.title = title;
        this.username = username;
    }
}
