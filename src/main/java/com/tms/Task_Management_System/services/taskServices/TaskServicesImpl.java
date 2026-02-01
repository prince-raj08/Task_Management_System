package com.tms.Task_Management_System.services.taskServices;

import com.tms.Task_Management_System.Dto.taskDto.CreateTaskRequest;
import com.tms.Task_Management_System.Dto.taskDto.CreateTaskResponse;
import com.tms.Task_Management_System.Dto.taskDto.UserTaskResponse;
import com.tms.Task_Management_System.Dto.userDto.UserCreateResponse;
import com.tms.Task_Management_System.Enums.Status;
import com.tms.Task_Management_System.ExceptionHandler.SecurityError;
import com.tms.Task_Management_System.entity.taskEntity.Task;
import com.tms.Task_Management_System.entity.userEntity.User;
import com.tms.Task_Management_System.repositories.TaskRepository;
import com.tms.Task_Management_System.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TaskServicesImpl implements TaskServices{
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    private final ObjectMapper mapper;
    @Override
    public ResponseEntity<CreateTaskResponse> createTask(CreateTaskRequest createTaskRequest) {
        User user = userRepository.findByUserId(createTaskRequest.getUserId()).orElseThrow(()-> new SecurityError("User not exist"));
        Task task = mapper.convertValue(createTaskRequest,Task.class);
        task.setStatus(Status.TODO);
        task.setCreatedAt(LocalDateTime.now().toString());
        task.setUpdatedAt(LocalDateTime.now().toString());
        task.setUser(user);
        Task savedTask = taskRepository.save(task);

        UserTaskResponse result = mapper.convertValue(user, UserTaskResponse.class);

        CreateTaskResponse response = mapper.convertValue(savedTask,CreateTaskResponse.class);
        response.setUser(result);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
