package com.tms.Task_Management_System.Dto.taskDto;


import com.tms.Task_Management_System.Enums.Status;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateTaskRequest {
    @NotBlank(message = "tittle can not be blank")
    private String tittle;
    @NotBlank(message = "description can not be blank")
    private String description;
    @NotBlank(message = "status can not be blank")
    private Status status;
}
