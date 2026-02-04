package com.tms.Task_Management_System.services.commentServices;

import com.tms.Task_Management_System.Dto.commentDto.CreateCommentRequest;
import com.tms.Task_Management_System.Dto.commentDto.CreateCommentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    public ResponseEntity<CreateCommentResponse> addComment(Long taskId, CreateCommentRequest commentRequest);
}
