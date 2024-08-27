package com.sparta.schedule_management_jpa.service;

import com.sparta.schedule_management_jpa.dto.ScheduleDto;
import com.sparta.schedule_management_jpa.entity.Schedule;
import com.sparta.schedule_management_jpa.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
//    public Page<ScheduleDto> getSchedules(int page, int size) {
//        Pageable pageable = PageRequest.of(page, size);
//        Page<Schedule> schedules = scheduleRepository.findAllByOrderByUpdatedDateDesc(pageable);
//
//        // Page<Schedule>를 Page<ScheduleDto>로 변환
//        return schedules.map(this::convertToDto);
//    }

    private ScheduleDto convertToDto(Schedule schedule) {
        return new ScheduleDto(
                schedule.getId(),
                schedule.getComments(),
                schedule.getTitle(),
                schedule.getUser().getId(),
                schedule.getUser().getEmail(),
                schedule.getUser().getUsername(),
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

        findSchedule.setUser(updatedSchedule.getUser());
        findSchedule.setTitle(updatedSchedule.getTitle());
        findSchedule.setContent(updatedSchedule.getContent());
        findSchedule.setComments(updatedSchedule.getComments());

        Schedule savedSchedule = scheduleRepository.save(findSchedule);

        return convertToDto(savedSchedule);
    }

    public void deleteSchedule(Long id) {
        Schedule targetSchedule = scheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid schedule ID: " + id));
        scheduleRepository.delete(targetSchedule);
    }

}

