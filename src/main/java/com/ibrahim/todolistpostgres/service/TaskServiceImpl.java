package com.ibrahim.todolistpostgres.service;

import com.ibrahim.todolistpostgres.domain.Task;
import com.ibrahim.todolistpostgres.domain.TaskStatus;
import com.ibrahim.todolistpostgres.dtos.request.TaskRequest;
import com.ibrahim.todolistpostgres.dtos.request.TaskUpdateRequest;
import com.ibrahim.todolistpostgres.exceptions.TaskNotFoundException;
import com.ibrahim.todolistpostgres.mapper.TaskMapperImpl;
import com.ibrahim.todolistpostgres.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapperImpl taskMapper;

    public TaskServiceImpl(TaskRepository taskRepository, TaskMapperImpl taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public Task createTask(TaskRequest taskRequest) {
        Task task = taskMapper.toTask(taskRequest);
        return taskRepository.save(task);
    }

    @Override
    public Task changeTaskStatus(Long taskId, TaskStatus taskStatus) throws TaskNotFoundException {
        if (!taskRepository.existsById(taskId)) {
            throw new TaskNotFoundException();
        }
        Task task = taskRepository.getOne(taskId);
        task.setTaskStatus(taskStatus);
        return taskRepository.save(task);
    }

    @Override
    public Task taskUpdate(Long taskId, TaskUpdateRequest taskUpdateRequest) throws TaskNotFoundException {
        if (!taskRepository.existsById(taskId)) {
            throw new TaskNotFoundException();
        }
        Task task = taskRepository.getOne(taskId);
        task.setCategory(taskUpdateRequest.getCategory());
        task.setDescription(taskUpdateRequest.getDescription());
        task.setDuration(taskUpdateRequest.getDuration());
        return taskRepository.save(task);
    }

    @Override
    public Optional<List<Task>> findTaskByTaskStatus(TaskStatus taskStatus) {
        return taskRepository.findTaskByTaskStatus(taskStatus);
    }
}
