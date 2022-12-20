package com.example.project_restapi.service;


import com.example.project_restapi.DTO.task.TaskRequest;
import com.example.project_restapi.DTO.task.TaskResponse;

import java.util.List;

public interface TaskService {
    List<TaskResponse> getAllTasks(Long id);

    TaskResponse addTask(Long id, TaskRequest taskRequest);

    TaskResponse getTaskById(Long id);

    TaskResponse updateTask(TaskRequest taskRequest, Long id);

    TaskResponse deleteTask(Long id);
}
