package com.tms.Task_Management_System.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UserCreateRequest {
    @NotBlank
    @Length(min = 3, max = 50, message = "Name can not be blank")
    private String userName;
    @Email(message = "Invalid email", regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$\n")
    private String email;
    @Length(min = 10, max=10, message = "Mobile not should be 10 digits")
    private String mobile;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Password must contain uppercase, lowercase, number, special character and be at least 8 characters long")
    private String password;
}
