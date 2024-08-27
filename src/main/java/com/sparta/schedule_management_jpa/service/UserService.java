package com.sparta.schedule_management_jpa.service;

import com.sparta.schedule_management_jpa.dto.UserDto;
import com.sparta.schedule_management_jpa.entity.User;
import com.sparta.schedule_management_jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private UserDto convertDto(User user) {
        return new UserDto(
                user.getId(),
                user.getEmail(),
                user.getUsername(),
                user.getCreatedDate()
        );
    }

    public UserDto save(User user) {
        User newUser = userRepository.save(user);
        return convertDto(newUser);
    }

    public UserDto getUserById(Long id) {
        User findUser = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 id를 찾을 수 없습니다."));
        return convertDto(findUser);
    }


    public List<UserDto> getAllUser() {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();

        for(User user : userList){
            userDtoList.add(convertDto(user));
        }
        return userDtoList;
    }

    public UserDto updateUser(Long id, User user) {
        User findUser = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 id를 찾을 수 없습니다."));

        findUser.setUsername(user.getUsername());
        findUser.setEmail(user.getEmail());
        User updateUser = userRepository.save(findUser);

        return convertDto(updateUser);
    }


    public void deleteUser(Long id) {

        userRepository.deleteById(id);
    }
}
