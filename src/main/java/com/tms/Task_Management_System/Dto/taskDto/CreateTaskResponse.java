package com.tms.Task_Management_System.Dto.taskDto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tms.Task_Management_System.Dto.userDto.UserCreateResponse;
import com.tms.Task_Management_System.Enums.Status;
import com.tms.Task_Management_System.entity.userEntity.User;
import lombok.Data;

@Data
public class CreateTaskResponse {

    private Long taskId;
    private String tittle;
    private String description;
    private Status status;
    private UserTaskResponse user;
    private String createdAt;
    private String updatedAt;
}
