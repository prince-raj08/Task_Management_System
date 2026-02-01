package com.tms.Task_Management_System.services.taskServices;

import com.tms.Task_Management_System.Dto.taskDto.CreateTaskRequest;
import com.tms.Task_Management_System.Dto.taskDto.CreateTaskResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface TaskServices {
    public ResponseEntity<CreateTaskResponse> createTask(CreateTaskRequest createTaskRequest);
}
