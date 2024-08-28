package com.sparta.schedule_management_jpa.dto;

import com.sparta.schedule_management_jpa.domain.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {
    private Long id;
    private Long scheduleId;
    private String content;
    private String username;

    protected CommentDto(){}

    public CommentDto(Long id, Long scheduleId, String content, String username) {
        this.id = id;
        this.scheduleId = scheduleId;
        this.content = content;
        this.username = username;
    }

}
