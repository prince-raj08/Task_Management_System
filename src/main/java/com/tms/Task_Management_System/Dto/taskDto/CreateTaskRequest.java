package com.tms.Task_Management_System.Dto.taskDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateTaskRequest {
    @NotNull(message = "user Id can not be null")
    private Long userId;
    @NotBlank(message = "tittle can not be blank")
    private String tittle;
    @NotBlank(message = "description can not be blank")
    private String description;

}
