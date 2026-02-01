package com.tms.Task_Management_System.services.taskServices;

import com.tms.Task_Management_System.Dto.taskDto.CreateTaskRequest;
import com.tms.Task_Management_System.Dto.taskDto.CreateTaskResponse;
import com.tms.Task_Management_System.Dto.taskDto.TaskResponse;
import com.tms.Task_Management_System.Dto.taskDto.UpdateTaskRequest;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskServices {
    public ResponseEntity<CreateTaskResponse> createTask(CreateTaskRequest createTaskRequest);
    public ResponseEntity<TaskResponse> getTaskById(Long taskId,Long userId);
    public  ResponseEntity<List<TaskResponse>> getAllTask(Long userId);
    public ResponseEntity<String> updateTaskById(Long taskId, Long useId, UpdateTaskRequest updateTaskRequest);
}
