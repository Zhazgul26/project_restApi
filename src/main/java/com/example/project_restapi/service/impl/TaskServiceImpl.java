package com.example.project_restapi.service.impl;

import com.example.project_restapi.DTO.task.TaskRequest;
import com.example.project_restapi.DTO.task.TaskResponse;
import com.example.project_restapi.converter.task.TaskRequestConverter;
import com.example.project_restapi.converter.task.TaskResponseConverter;
import com.example.project_restapi.entities.Lesson;
import com.example.project_restapi.entities.Task;
import com.example.project_restapi.repository.LessonRepository;
import com.example.project_restapi.repository.TaskRepository;
import com.example.project_restapi.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final LessonRepository lessonRepository;

    private final TaskRequestConverter taskRequestConverter;

    private final TaskResponseConverter taskResponseConverter;

    @Override
    public List<TaskResponse> getAllTasks(Long id) {
        return taskResponseConverter.view(taskRepository.getAllTasks(id));
    }

    @Override
    public TaskResponse addTask(Long id, TaskRequest taskRequest) {
        Lesson lesson = lessonRepository.findById(id).get();
        Task task = taskRequestConverter.createTask(taskRequest);
        lesson.addTask(task);
        task.setLesson(lesson);
        taskRepository.save(task);
        return taskResponseConverter.viewTask(task);
    }

    @Override
    public TaskResponse getTaskById(Long id) {
        return taskResponseConverter.viewTask(taskRepository.getById(id));
    }

    @Override
    public TaskResponse updateTask(TaskRequest taskRequest, Long id) {
        Task task = taskRepository.findById(id).get();
        taskRequestConverter.updateTask(task, taskRequest);
        taskRepository.save(task);
        return taskResponseConverter.viewTask(task);
    }

    @Override
    public TaskResponse deleteTask(Long id) {
        Task task = taskRepository.findById(id).get();
        taskRepository.delete(task);
        return taskResponseConverter.viewTask(task);
    }
}
