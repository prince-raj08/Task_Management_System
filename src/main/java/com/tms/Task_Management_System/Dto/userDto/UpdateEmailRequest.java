package com.tms.Task_Management_System.Dto.userDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateEmailRequest {
    @NotNull(message = "user Id can not be blank")
    private Long userId;
    @Email(message = "Invalid email")
    private String oldEmail;
    @Email(message = "Invalid email")
    private String newEmail;
}
