package com.sparta.schedule_management_jpa.controller;

import com.sparta.schedule_management_jpa.dto.ScheduleDto;
import com.sparta.schedule_management_jpa.domain.Schedule;
import com.sparta.schedule_management_jpa.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/save")
    public ResponseEntity<ScheduleDto> saveSchedule(@RequestBody ScheduleDto scheduleDto) {
        try {
            Schedule schedule = convertToEntity(scheduleDto);
            ScheduleDto savedScheduleDto = scheduleService.save(schedule);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedScheduleDto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleDto> getScheduleById(@PathVariable Long id) {
        try {
            ScheduleDto scheduleDto = scheduleService.getScheduleById(id);
            return ResponseEntity.ok(scheduleDto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScheduleDto> updateSchedule(@PathVariable Long id, @RequestBody ScheduleDto scheduleDto) {
        try {
            Schedule schedule = convertToEntity(scheduleDto);
            schedule.setId(id);
            ScheduleDto updatedScheduleDto = scheduleService.updateSchedule(schedule);
            return ResponseEntity.ok(updatedScheduleDto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        try {
            scheduleService.deleteSchedule(id);
            return ResponseEntity.noContent().build(); // No content for successful deletion
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // DTO를 엔티티로 변환하는 메서드
    private Schedule convertToEntity(ScheduleDto scheduleDto) {
        Schedule schedule = new Schedule();
        schedule.setTitle(scheduleDto.getTitle());
        schedule.setContent(scheduleDto.getContent());
        return schedule;
    }
}
