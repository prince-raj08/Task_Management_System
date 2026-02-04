package com.tms.Task_Management_System.services.commentServices;

import com.tms.Task_Management_System.Dto.commentDto.CreateCommentRequest;
import com.tms.Task_Management_System.Dto.commentDto.CreateCommentResponse;
import com.tms.Task_Management_System.ExceptionHandler.SecurityError;
import com.tms.Task_Management_System.entity.commentEntity.Comment;
import com.tms.Task_Management_System.entity.taskEntity.Task;
import com.tms.Task_Management_System.entity.userEntity.User;
import com.tms.Task_Management_System.repositories.CommentRepository;
import com.tms.Task_Management_System.repositories.TaskRepository;
import com.tms.Task_Management_System.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
@Slf4j
@Service
@RequiredArgsConstructor
public class CommetServicesImpl implements CommentService {
    public final ObjectMapper mapper;
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    private final CommentRepository commentRepository;
    @Override
    public ResponseEntity<CreateCommentResponse> addComment(Long taskId, CreateCommentRequest commentRequest) {
        log.info("Inside add comment sevices --------------------------->{}", taskId);
        User user = userRepository.findByUserId(commentRequest.getUserId()).orElseThrow(()-> new SecurityError("User not found"));

        Task task = taskRepository.findByTaskId(taskId).orElseThrow(
                () -> new SecurityError("Task not found"));
        Comment comment = new Comment();
        comment.setCommnent(commentRequest.getComment());
        comment.setUser(user);
        comment.setTask(task);
        comment.setCreatedAt(LocalDateTime.now().toString());
        Comment savedComment =commentRepository.save(comment);
        CreateCommentResponse response = new CreateCommentResponse();
        response.setCommentId(savedComment.getCommId());
        response.setComment(savedComment.getCommnent());
        response.setUser(savedComment.getUser());
        response.setCreatedAt(savedComment.getCreatedAt());
        log.info("Sending response to the add comment controller");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
