package com.ibrahim.todolistpostgres.service;

import com.ibrahim.todolistpostgres.domain.Task;
import com.ibrahim.todolistpostgres.dtos.request.TaskRequest;

public interface TaskService {
    Task createTask(TaskRequest taskRequest);
}
