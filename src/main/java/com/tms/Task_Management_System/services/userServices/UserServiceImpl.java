package com.tms.Task_Management_System.services.userServices;

import com.tms.Task_Management_System.Dto.userDto.*;
import com.tms.Task_Management_System.Enums.IsActive;
import com.tms.Task_Management_System.ExceptionHandler.DuplicateEmail;
import com.tms.Task_Management_System.ExceptionHandler.DuplicateMobile;
import com.tms.Task_Management_System.ExceptionHandler.SecurityError;
import com.tms.Task_Management_System.entity.userEntity.User;
import com.tms.Task_Management_System.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserServices {
    private final ObjectMapper mapper;
    private final UserRepository userRepository;
    @Override
    public ResponseEntity<UserCreateResponse> register(UserCreateRequest userCreateRequest) {

        log.info("Inside register services  ------------> {}",userCreateRequest);

       if(userRepository.existsUserByEmail(userCreateRequest.getEmail()))
        {
            throw new DuplicateEmail("Email already register");
        }
       if(userRepository.existsUserByMobile(userCreateRequest.getMobile()))
       {
           throw new DuplicateMobile("Mobile no is already register");
       }
        User user = mapper.convertValue(userCreateRequest,User.class);
        user.setIsActive(IsActive.ACTIVE);
       User saveUser =  userRepository.save(user);
        UserCreateResponse response =  new UserCreateResponse();
        response.setUserId(saveUser.getUserId());
        response.setMessage("User register Successfully");
        log.info("sending response to controller  ---------------{}",response.getMessage());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    public ResponseEntity<String> UpdateEmail(UpdateEmailRequest updateEmailRequest) {
        log.info("Inside update email services ---------------->{}",updateEmailRequest);

        boolean exists = userRepository.existsUserByUserId(updateEmailRequest.getUserId());
        if(exists == false)
        {
            throw new SecurityError("SECURITY ERROR : INVALID USER");
        }
        if(!userRepository.existsUserByEmail(updateEmailRequest.getOldEmail()))
        {
            throw new DuplicateEmail("User with email not found");
        }
        if(updateEmailRequest.getOldEmail().equals(updateEmailRequest.getNewEmail()))
        {
            throw new DuplicateEmail("Old and New Email can not be same");
        }
        if(userRepository.existsUserByEmail(updateEmailRequest.getNewEmail()))
        {
            throw new DuplicateEmail("Email exist with another user -----> "+updateEmailRequest.getNewEmail());
        }
        User user = userRepository.findByEmailAndUserId(updateEmailRequest.getOldEmail(),updateEmailRequest.getUserId()).orElseThrow(()->
                new SecurityException("User with userid and email not found"));

        user.setEmail(updateEmailRequest.getNewEmail());
        userRepository.save(user);
        log.info("Sending response back to controller ---------->  Email updated Successfully");
        return ResponseEntity.status(HttpStatus.OK).body("Email updated Successfully");
    }

    @Override
    public ResponseEntity<String> updateMobile(UpdateMobileRequest updateMobileRequest) {

        log.info("Inside update mobile services ---------------->{}",updateMobileRequest);

        boolean exists = userRepository.existsUserByUserId(updateMobileRequest.getUserId());
        if(exists == false)
        {
            throw new SecurityError("SECURITY ERROR : INVALID USER");
        }
        if(!userRepository.existsUserByMobile(updateMobileRequest.getOldMobile()))
        {
            throw new DuplicateMobile("User with mobile no not found");
        }
        if(updateMobileRequest.getOldMobile().equals(updateMobileRequest.getNewMobile()))
        {
            throw new DuplicateMobile("Old and New Mobile can not be same");
        }
        if(userRepository.existsUserByMobile(updateMobileRequest.getNewMobile()))
        {
            throw new DuplicateMobile("Mobile exist with another user -----> "+updateMobileRequest.getNewMobile());
        }

        User user = userRepository
                .findByMobileAndUserId(updateMobileRequest.getOldMobile(),
                        updateMobileRequest.getUserId())
                .orElseThrow(() ->
                        new SecurityException("User with userid and mobile no not found")
                );

        user.setEmail(updateMobileRequest.getNewMobile());
        userRepository.save(user);
        log.info("Sending response back to controller ---------->  Mobile no updated Successfully");
        return ResponseEntity.status(HttpStatus.OK).body("Mobile updated Successfully");
    }

    @Override
    public ResponseEntity<GetUserResponse> findByUserId(Long userid) {

        User user = userRepository.findByUserId(userid).orElseThrow(()-> new SecurityError("User not found with this id "+ userid));
        GetUserResponse response = mapper.convertValue(user,GetUserResponse.class);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<List<GetUserResponse>> getAllUsers() {

        List<User> userList = userRepository.findAll();
        List<GetUserResponse> response = new ArrayList<>();
        for( User u : userList)
        {
            GetUserResponse result= mapper.convertValue(u,GetUserResponse.class);
            response.add(result);
        }

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


}
