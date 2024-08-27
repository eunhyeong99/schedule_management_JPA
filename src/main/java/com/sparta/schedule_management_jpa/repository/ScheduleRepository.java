package com.sparta.schedule_management_jpa.repository;

import com.sparta.schedule_management_jpa.entity.Schedule;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,Long> {
//    Page<Schedule> findAllByOrderByUpdatedDateDesc(Pageable pageable);
}
