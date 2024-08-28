package com.sparta.schedule_management_jpa.service;

import com.sparta.schedule_management_jpa.config.PasswordEncoder;
import com.sparta.schedule_management_jpa.domain.User;
import com.sparta.schedule_management_jpa.domain.UserRoleEnum;
import com.sparta.schedule_management_jpa.dto.LoginRequestDto;
import com.sparta.schedule_management_jpa.dto.SignupRequestDto;
import com.sparta.schedule_management_jpa.dto.UserDto;
import com.sparta.schedule_management_jpa.jwt.JwtUtil;
import com.sparta.schedule_management_jpa.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    private UserDto convertDto(User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getRole(),
                user.isAdmin(),
                user.getAdminToken()
        );
    }


    // 유저 저장
    public UserDto save(User user) {
        User newUser = userRepository.save(user);
        return convertDto(newUser);
    }


    // 유저 단건 조회
    public UserDto getUserById(Long id) {
        User findUser = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 id를 찾을 수 없습니다."));
        return convertDto(findUser);
    }


    // 모든 유저 조회
    public List<UserDto> getAllUser() {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();

        for (User user : userList) {
            userDtoList.add(convertDto(user));
        }
        return userDtoList;
    }

    // 유저 수정
    public UserDto updateUser(Long id, User user) {
        User findUser = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 id를 찾을 수 없습니다."));

        findUser.setUsername(user.getUsername());
        findUser.setEmail(user.getEmail());
        User updateUser = userRepository.save(findUser);

        return convertDto(updateUser);
    }


    // 유저 삭제
    public void deleteUser(Long id) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 id를 찾을 수 없습니다."));
        userRepository.delete(existingUser);
    }


}

