package com.tms.Task_Management_System.Dto.commentDto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tms.Task_Management_System.entity.userEntity.User;
import lombok.Data;

@Data
public class CreateCommentResponse {

    private Long commentId;
    private String comment;
    private User user;
    private String createdAt;
}
