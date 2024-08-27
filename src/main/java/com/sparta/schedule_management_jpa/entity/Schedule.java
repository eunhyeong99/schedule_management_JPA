package com.sparta.schedule_management_jpa.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 유저 고유 식별자
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

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
    @OneToMany(mappedBy = "schedule",cascade = {CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval = true)
    private List<Comment> comments;

    @OneToMany(mappedBy = "schedule", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private List<ScheduleUser> scheduleUsers = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedDate = LocalDateTime.now();
    }

}
