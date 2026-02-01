package com.tms.Task_Management_System.controller.userController;

import com.tms.Task_Management_System.Dto.userDto.*;
import com.tms.Task_Management_System.services.userServices.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/register")
    public ResponseEntity<UserCreateResponse> createUser(@RequestBody @Valid UserCreateRequest userCreateRequest)
    {
        log.info("Inside Create User controller -------------------> {}",userCreateRequest);
        ResponseEntity<UserCreateResponse> response = userService.register(userCreateRequest);
        log.info("Sending response back to client ------------------>{}", response);
     return response;
    }
    @PatchMapping("/updateEmail")
    public ResponseEntity<String> updateEmail(@RequestBody @Valid UpdateEmailRequest updateEmailRequest)
    {
        log.info("Inside update user controller --------------------{}",updateEmailRequest);
        ResponseEntity<String> response = userService.UpdateEmail(updateEmailRequest);
        log.info("Sending response back to client ----------------->{}",response);
        return response;
    }

    @PatchMapping("/update/mobile")
    public ResponseEntity<String> updateMobile(@RequestBody UpdateMobileRequest updateMobileRequest)
    {
        log.info("Indide update mobile controller  ---------------------------> {}",updateMobileRequest);
        ResponseEntity<String> response = userService.updateMobile(updateMobileRequest);
        log.info("sending response back to the client ------------------------->{}",response);
        return response;
    }

    @GetMapping("/{userid}")
    public ResponseEntity<GetUserResponse> getUserById(@PathVariable Long userid)
    {
        log.info("Inside get user by id controller ----------------->{}",userid);
        ResponseEntity<GetUserResponse> response = userService.findByUserId(userid);
        log.info("Sending response back to the client  -------------{}",response);
        return response;
    }

    @GetMapping("/all")
    public ResponseEntity<List<GetUserResponse>> getAllUsers()
    {
        log.info("Inside get all users controller  ----------------------------->");
        ResponseEntity<List<GetUserResponse>> response = userService.getAllUsers();
        log.info("sending response back to the client --------------------------->");
        return response;
    }
}
