package com.sparta.schedule_management_jpa.controller;

import com.sparta.schedule_management_jpa.dto.CommentDto;
import com.sparta.schedule_management_jpa.domain.Comment;
import com.sparta.schedule_management_jpa.service.CommentService;
import com.sparta.schedule_management_jpa.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // 댓글 저장
    @PostMapping("/save/{scheduleId}")
    public ResponseEntity<CommentDto> saveComment(@PathVariable(name = "scheduleId") Long scheduleId, @RequestBody CommentDto commentDto) {
        try {
            CommentDto savedComment = commentService.save(scheduleId, commentDto);
            return ResponseEntity.ok(savedComment);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // 댓글 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable(name = "id") Long id) {
        try {
            CommentDto comment = commentService.getCommentById(id);
            if (comment != null) {
                return ResponseEntity.ok(comment);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // 댓글 전체 조회
    @GetMapping("/all")
    public ResponseEntity<List<CommentDto>> getAllComments() {
        try {
            List<CommentDto> comments = commentService.getAllComments();
            return ResponseEntity.ok(comments);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // 댓글 수정
    @PutMapping("/{id}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable(name = "id") Long id, @RequestBody Comment comment) {
        try {
            CommentDto updatedComment = commentService.updateComment(id, comment);
            if (updatedComment != null) {
                return ResponseEntity.ok(updatedComment);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // 댓글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable(name = "id") Long id) {
        try {
            boolean deleted = commentService.deleteComment(id);
            if (deleted) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}


