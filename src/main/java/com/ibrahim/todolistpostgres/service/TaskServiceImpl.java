package com.ibrahim.todolistpostgres.service;

import com.ibrahim.todolistpostgres.domain.Task;
import com.ibrahim.todolistpostgres.dtos.request.TaskRequest;
import com.ibrahim.todolistpostgres.mapper.TaskMapper;
import com.ibrahim.todolistpostgres.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public Task createTask(TaskRequest taskRequest) {
         Task task = taskMapper.toTask(taskRequest);
          return taskRepository.save(task);
    }
}
