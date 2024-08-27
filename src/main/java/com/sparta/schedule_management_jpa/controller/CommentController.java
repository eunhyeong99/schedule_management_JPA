package com.sparta.schedule_management_jpa.controller;

import com.sparta.schedule_management_jpa.dto.CommentDto;
import com.sparta.schedule_management_jpa.dto.ScheduleDto;
import com.sparta.schedule_management_jpa.entity.Comment;
import com.sparta.schedule_management_jpa.service.CommentService;
import com.sparta.schedule_management_jpa.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final ScheduleService scheduleService;

//    @GetMapping
//    public Page<ScheduleDto> getSchedules(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size) {
//        return scheduleService.getSchedules(page, size);
//    }

    // 댓글 저장
    @PostMapping("/save/{scheduleId}")
    public CommentDto saveComment(@PathVariable Long scheduleId, @RequestBody Comment comment) {
        return commentService.save(scheduleId, comment);
    }

    // 댓글 단건 조회
    @GetMapping("/{id}")
    public CommentDto getCommentById(@PathVariable Long id) {
        return commentService.getCommentById(id);
    }

    // 댓글 전체 조회
    @GetMapping("/all")
    public List<CommentDto> getAllComments() {
        return commentService.getAllComments();
    }

    // 댓글 수정
    @PutMapping("/{id}")
    public CommentDto updateComment(@PathVariable Long id, @RequestBody Comment comment) {
        return commentService.updateComment(id, comment);
    }

    // 댓글 삭제
    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }

}


