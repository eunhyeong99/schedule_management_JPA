package com.sparta.schedule_management_jpa.repository;

import com.sparta.schedule_management_jpa.domain.Schedule;
import com.sparta.schedule_management_jpa.dto.ScheduleDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
}
