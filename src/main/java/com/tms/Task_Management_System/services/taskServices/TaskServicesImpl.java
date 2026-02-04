package com.tms.Task_Management_System.services.taskServices;

import com.tms.Task_Management_System.Dto.taskDto.*;
import com.tms.Task_Management_System.Enums.Status;
import com.tms.Task_Management_System.ExceptionHandler.SecurityError;
import com.tms.Task_Management_System.entity.taskEntity.Task;
import com.tms.Task_Management_System.entity.userEntity.User;
import com.tms.Task_Management_System.repositories.TaskRepository;
import com.tms.Task_Management_System.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskServicesImpl implements TaskServices{
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    private final ObjectMapper mapper;
    @Override
    public ResponseEntity<CreateTaskResponse> createTask(CreateTaskRequest createTaskRequest) {
        log.info("Inside create Task services  ------------------------------>{}",createTaskRequest);

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

        log.info("sending response back to the create task controller");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    public ResponseEntity<TaskResponse> getTaskById(Long taskId,Long userId) {
        User user = userRepository.findByUserId(userId).orElseThrow(()-> new SecurityError("User not exist"));
        Task task = taskRepository.findByTaskId(taskId).orElseThrow(() -> new RuntimeException("Invalid task id"));
        TaskResponse response = mapper.convertValue(task,TaskResponse.class);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<List<TaskResponse>> getAllTask(Long userId) {
        User user = userRepository.findByUserId(userId).orElseThrow(()-> new SecurityError("User not exist"));
        List<Task> taskList = taskRepository.findAll();
        List<TaskResponse> responsesList = new ArrayList<>();
        for(Task t: taskList)
        {
            TaskResponse result = mapper.convertValue(t,TaskResponse.class);
            responsesList.add(result);
        }
        return ResponseEntity.status(HttpStatus.OK).body(responsesList);
    }

    @Override
    public ResponseEntity<String> updateTaskById(Long taskId, Long useId, UpdateTaskRequest updateTaskRequest) {
        User user=userRepository.findByUserId(useId).orElseThrow(()-> new SecurityError("User not exist"));
        Task task = taskRepository.findByTaskId(taskId).orElseThrow(()-> new RuntimeException("task not found"));
        task.setTittle(updateTaskRequest.getTittle());
        task.setDescription(updateTaskRequest.getDescription());
        task.setStatus(updateTaskRequest.getStatus());
        taskRepository.save(task);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Task updated Successfully");
    }

}
