package com.tms.Task_Management_System.Dto.userDto;

import com.tms.Task_Management_System.Enums.IsActive;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class GetUserResponse {

    private Long userId;
    private String userName;
    private String email;
    private String mobile;
    private IsActive isActive;

}
