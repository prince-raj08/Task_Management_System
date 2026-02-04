package com.tms.Task_Management_System.controller.commentController;


import com.tms.Task_Management_System.Dto.commentDto.CreateCommentRequest;
import com.tms.Task_Management_System.Dto.commentDto.CreateCommentResponse;
import com.tms.Task_Management_System.services.commentServices.CommentService;
import com.tms.Task_Management_System.services.commentServices.CommetServicesImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {
    private final CommetServicesImpl commetServices;
    private final CommentService commentService;

    @PostMapping("/add/comment/{taskId}")
    public ResponseEntity<CreateCommentResponse> addComment(@PathVariable Long taskId, @RequestBody CreateCommentRequest commentRequest)
    {
        log.info("Inside add coment Controller ------------------------------->{}",taskId);
        ResponseEntity<CreateCommentResponse> response = commentService.addComment(taskId,commentRequest);
        log.info("Sending response back to client ----------------------------->{}",response);
        return response;
    }

}
