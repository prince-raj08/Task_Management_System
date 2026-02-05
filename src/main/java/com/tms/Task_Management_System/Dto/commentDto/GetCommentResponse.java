package com.tms.Task_Management_System.Dto.commentDto;

import com.tms.Task_Management_System.Dto.taskDto.TaskResponse;
import com.tms.Task_Management_System.Dto.userDto.GetUserResponse;
import com.tms.Task_Management_System.entity.taskEntity.Task;
import lombok.Data;


@Data
public class GetCommentResponse {
    private Long commId;
    private String commnent;
    private GetUserResponse user;
    private TaskResponse task;
    private String createdAt;
}
