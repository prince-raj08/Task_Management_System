package com.tms.Task_Management_System.controller.userController;

import com.tms.Task_Management_System.Dto.UpdateEmailRequest;
import com.tms.Task_Management_System.Dto.UserCreateRequest;
import com.tms.Task_Management_System.Dto.UserCreateResponse;
import com.tms.Task_Management_System.services.userServices.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/register")
    public ResponseEntity<UserCreateResponse> createUser(@RequestBody @Valid UserCreateRequest userCreateRequest)
    {
        log.info("Inside Create User controller -------------> {}",userCreateRequest);
        ResponseEntity<UserCreateResponse> response = userService.register(userCreateRequest);
        log.info("Sending response back to client ----------->{}", response);
     return response;
    }
    @PatchMapping("/updateEmail")
    public ResponseEntity<String> updateEmail(@RequestBody @Valid UpdateEmailRequest updateEmailRequest)
    {
        log.info("Inside update user controller -------------{}",updateEmailRequest);
        ResponseEntity<String> response = userService.UpdateEmail(updateEmailRequest);
        log.info("Sending response back to client ----------------->{}",response);
        return response;
    }
}
