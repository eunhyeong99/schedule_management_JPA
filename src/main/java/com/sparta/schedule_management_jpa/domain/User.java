package com.sparta.schedule_management_jpa.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "DomainUser")
@Getter
@Setter
public class User extends Timestamped {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRoleEnum role;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private List<ScheduleUser> scheduleUsers = new ArrayList<>();

    @Column(nullable = false)
    private boolean admin;

    @Column(nullable = false)
    private String adminToken;


    public User() {
    }

    public boolean isAdmin() {
        return role == UserRoleEnum.ADMIN;
    }

    public String getAdminToken() {
        return "someAdminToken";
    }


}
