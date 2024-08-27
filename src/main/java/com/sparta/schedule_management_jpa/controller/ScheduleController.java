package com.sparta.schedule_management_jpa.controller;

import com.sparta.schedule_management_jpa.dto.ScheduleDto;
import com.sparta.schedule_management_jpa.entity.Schedule;
import com.sparta.schedule_management_jpa.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/save")
    public ScheduleDto saveSchedule(@RequestBody Schedule schedule) {
        ScheduleDto scheduleDto = scheduleService.save(schedule);
        return scheduleDto;
    }

    @GetMapping("/{id}")
    public ScheduleDto getScheduleById(@PathVariable Long id) {
        return scheduleService.getScheduleById(id);
    }

    @PutMapping("/{id}")
    public ScheduleDto updateSchedule(@PathVariable Long id, @RequestBody Schedule schedule) {
        return scheduleService.updateSchedule(id, schedule);
    }

    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable Long id){
        scheduleService.deleteSchedule(id);
    }
}
