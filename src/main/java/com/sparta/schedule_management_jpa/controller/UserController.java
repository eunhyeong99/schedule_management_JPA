package com.sparta.schedule_management_jpa.controller;

import com.sparta.schedule_management_jpa.domain.User;
import com.sparta.schedule_management_jpa.dto.UserDto;
import com.sparta.schedule_management_jpa.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    private User convertToEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole()); // role 설정
        user.setAdmin(userDto.isAdmin());
        user.setAdminToken(userDto.getAdminToken());
        return user;
    }

    // 유저 저장
    @PostMapping("/save")
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {
        try {
            User user = convertToEntity(userDto);
            UserDto responseDto = userService.save(user);

            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // 유저 단건 조회
    @GetMapping("/{userOneId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "userOneId") Long id) {
        try {
            UserDto userDto = userService.getUserById(id);
            return ResponseEntity.ok(userDto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // 유저 전체 조회
    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAllUser() {
        try {
            List<UserDto> userDtos = userService.getAllUser();
            return ResponseEntity.ok(userDtos);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // 유저 수정
    @PutMapping("/{updateUser}")
    public ResponseEntity<UserDto> updateUser(@PathVariable(name = "updateUser") Long id, @RequestBody UserDto userDto) {
        try {
            User user = convertToEntity(userDto);
            UserDto updatedUserDto = userService.updateUser(id, user);
            return ResponseEntity.ok(updatedUserDto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // 유저 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(name = "id") Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
