package com.tms.Task_Management_System.services.commentServices;

import com.tms.Task_Management_System.Dto.commentDto.CreateCommentRequest;
import com.tms.Task_Management_System.Dto.commentDto.CreateCommentResponse;
import com.tms.Task_Management_System.Dto.commentDto.GetCommentResponse;
import lombok.Generated;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    public ResponseEntity<CreateCommentResponse> addComment(Long taskId, CreateCommentRequest commentRequest);
    public ResponseEntity<List<GetCommentResponse>> getCommentByTaskId(Long taskId);
}
