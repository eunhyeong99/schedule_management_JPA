package com.sparta.schedule_management_jpa.service;

import com.sparta.schedule_management_jpa.dto.ScheduleDto;
import com.sparta.schedule_management_jpa.entity.Schedule;
import com.sparta.schedule_management_jpa.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    private ScheduleDto convertToDto(Schedule schedule) {
        return new ScheduleDto(
                schedule.getId(),
                schedule.getComments(),
                schedule.getTitle(),
                schedule.getUsername(),
                schedule.getCreatedDate()
        );
    }

    public ScheduleDto save(Schedule schedule) {

        Schedule saveSchedule = scheduleRepository.save(schedule);

        return convertToDto(saveSchedule);
    }

    public ScheduleDto getScheduleById(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid schedule ID: " + id));

        return convertToDto(schedule);
    }

    public ScheduleDto updateSchedule(Long id, Schedule updatedSchedule) {

        Schedule findSchedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid schedule ID: " + id));

        findSchedule.setUsername(updatedSchedule.getUsername());
        findSchedule.setTitle(updatedSchedule.getTitle());
        findSchedule.setContent(updatedSchedule.getContent());
        findSchedule.setComments(updatedSchedule.getComments());

        Schedule savedSchedule = scheduleRepository.save(findSchedule);

        return convertToDto(savedSchedule);
    }
}

