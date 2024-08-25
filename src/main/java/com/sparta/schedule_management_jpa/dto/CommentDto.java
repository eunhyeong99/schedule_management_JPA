package com.sparta.schedule_management_jpa.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentDto {
    private Long id;
    private Long scheduleId;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public CommentDto(Long id, Long scheduleId, String content, LocalDateTime updatedDate) {
        this.id = id;
        this.scheduleId = scheduleId;
        this.content = content;
    }
}
