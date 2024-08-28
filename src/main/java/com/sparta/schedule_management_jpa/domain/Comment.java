package com.sparta.schedule_management_jpa.domain;

import com.sparta.schedule_management_jpa.dto.ScheduleDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "DomainComment")
@Getter
@Setter
public class Comment extends Timestamped {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String content;


    // 일정과 연관 관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id",nullable = false)
    private Schedule schedule;

    // 유저 정보를 가지고 있다.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;  // 작성자 정보 추가

    public Comment() {}
}
