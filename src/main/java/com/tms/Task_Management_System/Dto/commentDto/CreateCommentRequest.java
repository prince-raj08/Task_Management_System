package com.tms.Task_Management_System.Dto.commentDto;

import com.tms.Task_Management_System.entity.taskEntity.Task;
import com.tms.Task_Management_System.entity.userEntity.User;
import lombok.Data;


@Data
public class CreateCommentRequest {

    private String comment;
    private Long userId;
}
