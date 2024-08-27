package com.sparta.schedule_management_jpa.controller;

import com.sparta.schedule_management_jpa.dto.CommentDto;
import com.sparta.schedule_management_jpa.dto.UserDto;
import com.sparta.schedule_management_jpa.entity.Comment;
import com.sparta.schedule_management_jpa.entity.User;
import com.sparta.schedule_management_jpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // 유저 저장
    @PostMapping("/save/")
    public UserDto saveUser(@RequestBody User user) {
        return userService.save(user);
    }

    // 유저 단건 조회
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // 댓글 전체 조회
    @GetMapping("/all")
    public List<UserDto> getAllUser() {
        return userService.getAllUser();
    }

    // 댓글 수정
    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    // 댓글 삭제
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
