package com.tms.Task_Management_System.services.userServices;

import com.tms.Task_Management_System.Dto.userDto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServices {
     public ResponseEntity<UserCreateResponse> register(UserCreateRequest userCreateRequest);
     public ResponseEntity<String> UpdateEmail(UpdateEmailRequest updateEmailRequest);
     public ResponseEntity<String> updateMobile(UpdateMobileRequest updateMobileRequest);
     public ResponseEntity<GetUserResponse> findByUserId(Long userid);
     public ResponseEntity<List<GetUserResponse>> getAllUsers();
}
