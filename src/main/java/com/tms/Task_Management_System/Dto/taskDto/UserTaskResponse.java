package com.tms.Task_Management_System.Dto.taskDto;

import lombok.Data;

@Data
public class UserTaskResponse {

    private Long userId;
    private String email;
    private String userName;
}
