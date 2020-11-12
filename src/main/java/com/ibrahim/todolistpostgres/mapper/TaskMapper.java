package com.ibrahim.todolistpostgres.mapper;

import com.ibrahim.todolistpostgres.domain.Task;
import com.ibrahim.todolistpostgres.domain.User;
import com.ibrahim.todolistpostgres.dtos.request.TaskRequest;
import com.ibrahim.todolistpostgres.dtos.request.UserRequest;

public interface TaskMapper {

    TaskRequest toTaskRequest(Task task);

    Task  toTask(TaskRequest taskRequest);
}
