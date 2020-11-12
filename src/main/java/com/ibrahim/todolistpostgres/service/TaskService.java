package com.ibrahim.todolistpostgres.service;

import com.ibrahim.todolistpostgres.domain.Task;
import com.ibrahim.todolistpostgres.domain.TaskStatus;
import com.ibrahim.todolistpostgres.dtos.request.TaskRequest;
import com.ibrahim.todolistpostgres.dtos.request.TaskUpdateRequest;
import com.ibrahim.todolistpostgres.exceptions.TaskNotFoundException;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task createTask(TaskRequest taskRequest);

    Task changeTaskStatus(Long taskId, TaskStatus taskStatus) throws TaskNotFoundException;

    Task taskUpdate(Long taskId, TaskUpdateRequest taskUpdateRequest) throws TaskNotFoundException;

    Optional<List<Task>> findTaskByTaskStatus(TaskStatus taskStatus);
}
