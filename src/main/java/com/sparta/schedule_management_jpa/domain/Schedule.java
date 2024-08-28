package com.sparta.schedule_management_jpa.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Domainschedule")
@Getter
@Setter
public class Schedule extends Timestamped{


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


    // 댓글
    @OneToMany(mappedBy = "schedule",cascade = {CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval = true)
    private List<Comment> comments;

    @OneToMany(mappedBy = "schedule", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private List<ScheduleUser> scheduleUsers = new ArrayList<>();

}
