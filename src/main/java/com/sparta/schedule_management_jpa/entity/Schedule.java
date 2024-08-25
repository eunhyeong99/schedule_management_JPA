package com.sparta.schedule_management_jpa.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 작성 유저명
    @Column(nullable = false, unique = true)
    private String username;

    // 할 일 제목
    @Column(nullable = false)
    private String title;

    // 할 일 내용
    @Column(nullable = false)
    private String content;

    // 작성일
    private LocalDateTime createdDate;

    // 수정일
    private LocalDateTime updatedDate;

    // 댓글
    @OneToMany(mappedBy = "schedule")
    private List<Comment> comments;

    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedDate = LocalDateTime.now();
    }

}
