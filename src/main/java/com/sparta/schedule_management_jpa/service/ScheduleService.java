package com.sparta.schedule_management_jpa.service;

import com.sparta.schedule_management_jpa.domain.User;
import com.sparta.schedule_management_jpa.dto.ScheduleDto;
import com.sparta.schedule_management_jpa.domain.Schedule;
import com.sparta.schedule_management_jpa.dto.UserDto;
import com.sparta.schedule_management_jpa.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserService userService;

    public ScheduleDto save(Schedule schedule) {
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return convertToDto(savedSchedule);
    }

    public ScheduleDto getScheduleById(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid schedule ID: " + id));
        return convertToDto(schedule);
    }

    public ScheduleDto updateSchedule(Schedule schedule) {
        if (!scheduleRepository.existsById(schedule.getId())) {
            throw new IllegalArgumentException("Invalid schedule ID: " + schedule.getId());
        }
        Schedule updatedSchedule = scheduleRepository.save(schedule);
        return convertToDto(updatedSchedule);
    }

    public void deleteSchedule(Long id) {
        if (!scheduleRepository.existsById(id)) {
            throw new IllegalArgumentException("Invalid schedule ID: " + id);
        }
        scheduleRepository.deleteById(id);
    }


    // 엔티티를 DTO로 변환하는 메서드
    private ScheduleDto convertToDto(Schedule schedule) {
        List<UserDto> userDtos = schedule.getScheduleUsers().stream()
                .map(scheduleUser -> {
                    User user = scheduleUser.getUser();
                    return new UserDto(user.getId(), user.getUsername(), user.getEmail());
                })
                .collect(Collectors.toList());

        return new ScheduleDto(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContent(),
                userDtos
        );
    }

}

