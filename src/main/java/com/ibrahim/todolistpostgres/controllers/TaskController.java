package com.ibrahim.todolistpostgres.controllers;

import com.ibrahim.todolistpostgres.domain.Task;
import com.ibrahim.todolistpostgres.dtos.request.TaskRequest;
import com.ibrahim.todolistpostgres.service.TaskServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/todolist/tasks")
public class TaskController {

    private final TaskServiceImpl taskService;

    public TaskController(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskRequest taskRequest){
        return taskService.createTask(taskRequest);
    }


}
