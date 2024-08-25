package com.sparta.schedule_management_jpa.service;

import com.sparta.schedule_management_jpa.dto.CommentDto;
import com.sparta.schedule_management_jpa.entity.Comment;
import com.sparta.schedule_management_jpa.entity.Schedule;
import com.sparta.schedule_management_jpa.repository.CommentRepository;
import com.sparta.schedule_management_jpa.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    private CommentDto convertToDto(Comment comment) {
        return new CommentDto(
                comment.getId(),
                comment.getSchedule().getId(),
                comment.getContent(),
                comment.getUpdatedDate()
        );
    }

    public CommentDto save(Long scheduleId, Comment comment) {

        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new IllegalArgumentException("Invalid schedule ID: " + scheduleId));

        comment.setSchedule(schedule);

        Comment saveComment = commentRepository.save(comment);

        return convertToDto(saveComment);
    }


    public CommentDto getCommentById(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid comment ID: " + id));

        return convertToDto(comment);
    }

    public List<CommentDto> getAllComments() {
        List<Comment> comments = commentRepository.findAll();
        List<CommentDto> commentDtoList = new ArrayList<>();

        for(Comment comment : comments){
            CommentDto commentDto = convertToDto(comment);
            commentDtoList.add(commentDto);
        }

        return commentDtoList;
    }


    public CommentDto updateComment(Long id, Comment comment) {
        Comment targetComment = commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid comment ID: " + id));

        targetComment.setContent(comment.getContent());

        Comment updateComment = commentRepository.save(targetComment);
        return convertToDto(updateComment);
    }


    public void deleteComment(Long id) {
        Comment targetComment = commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid comment ID: " + id));

        commentRepository.delete(targetComment);
    }
}
