package com.tms.Task_Management_System.services.userServices;

import com.tms.Task_Management_System.Dto.UpdateEmailRequest;
import com.tms.Task_Management_System.Dto.UserCreateRequest;
import com.tms.Task_Management_System.Dto.UserCreateResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserServices {
     public ResponseEntity<UserCreateResponse> register(UserCreateRequest userCreateRequest);
     public ResponseEntity<String> UpdateEmail(UpdateEmailRequest updateEmailRequest);
}
