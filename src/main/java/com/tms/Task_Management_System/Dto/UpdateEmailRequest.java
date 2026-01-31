package com.tms.Task_Management_System.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateEmailRequest {
    @NotNull(message = "user Id can not be blank")
    private Long userId;
    @Email(message = "Invalid email", regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")
    private String oldEmail;
    @Email(message = "Invalid email",  regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")
    private String newEmail;
}
