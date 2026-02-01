package com.tms.Task_Management_System.Dto.taskDto;

import com.tms.Task_Management_System.Enums.Status;
import lombok.Data;

@Data
public class TaskResponse {

    private Long taskId;
    private String tittle;
    private String description;
    private Status status;
    private String createdAt;
    private String updatedAt;

}
