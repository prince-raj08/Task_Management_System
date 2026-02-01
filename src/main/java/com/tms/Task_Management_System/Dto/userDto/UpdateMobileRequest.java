package com.tms.Task_Management_System.Dto.userDto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UpdateMobileRequest {

    @Length( min =10,max = 10, message = "mobile no shiuld be 10 digit")
    private String oldMobile;
    @Length( min =10,max = 10, message = "mobile no shiuld be 10 digit")
    private String newMobile;
    @NotNull(message = "user id can not be blank")
    private Long userId;
}
