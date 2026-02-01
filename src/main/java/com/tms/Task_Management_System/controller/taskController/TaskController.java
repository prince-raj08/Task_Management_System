package com.tms.Task_Management_System.controller.taskController;


import com.tms.Task_Management_System.Dto.taskDto.CreateTaskRequest;
import com.tms.Task_Management_System.Dto.taskDto.CreateTaskResponse;
import com.tms.Task_Management_System.services.taskServices.TaskServicesImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
    private final TaskServicesImpl taskServices;

    @PostMapping("/create")
    public ResponseEntity<CreateTaskResponse> createTask(@RequestBody CreateTaskRequest createTaskRequest)
    {
        log.info("Inside create task controller -------------------->{}",createTaskRequest);
        ResponseEntity<CreateTaskResponse> response = taskServices.createTask(createTaskRequest);
        log.info("Sending response bank to the user ------------------{}",response);
        return response;
    }
}
