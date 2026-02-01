package com.tms.Task_Management_System.controller.taskController;


import com.tms.Task_Management_System.Dto.taskDto.CreateTaskRequest;
import com.tms.Task_Management_System.Dto.taskDto.CreateTaskResponse;
import com.tms.Task_Management_System.Dto.taskDto.TaskResponse;
import com.tms.Task_Management_System.Dto.taskDto.UpdateTaskRequest;
import com.tms.Task_Management_System.services.taskServices.TaskServicesImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/id/{taskId}")
    public ResponseEntity<TaskResponse> getTaskById(@PathVariable Long taskId, @RequestParam Long userId)
    {
        log.info("Inside get task by id controller  -----------------{}", taskId);
        ResponseEntity<TaskResponse> response = taskServices.getTaskById(taskId,userId);
        log.info("sending response back to the client ----------------{}",response);
        return response;
    }

    @GetMapping("/get/{userId}")
    public ResponseEntity<List<TaskResponse>> getAllTask(@PathVariable Long userId)
    {
        log.info("Inside get all task controller ---------------------> ");
        ResponseEntity<List<TaskResponse>> response = taskServices.getAllTask(userId);
        log.info("sending response back to the client -----------------{}",response);
        return response;
    }

    @PatchMapping("/update/task/{userId}")
    public ResponseEntity<String> updateTask(@RequestParam Long taskId, @PathVariable Long userId, @RequestBody UpdateTaskRequest updateTaskRequest)
    {
        log.info("Inside update task by id controller ---------------------------->{}",taskId);
        ResponseEntity<String> response = taskServices.updateTaskById(taskId,userId,updateTaskRequest);
        log.info("sending response back to the client ---------------------------- >{}");
        return response;
    }
}
