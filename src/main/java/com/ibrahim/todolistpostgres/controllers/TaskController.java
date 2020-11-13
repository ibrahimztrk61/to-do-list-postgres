package com.ibrahim.todolistpostgres.controllers;

import com.ibrahim.todolistpostgres.domain.Task;
import com.ibrahim.todolistpostgres.domain.TaskStatus;
import com.ibrahim.todolistpostgres.dtos.request.TaskRequest;
import com.ibrahim.todolistpostgres.dtos.request.TaskUpdateRequest;
import com.ibrahim.todolistpostgres.exceptions.TaskNotFoundException;
import com.ibrahim.todolistpostgres.exceptions.UserNotFoundException;
import com.ibrahim.todolistpostgres.service.TaskServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/todolist/tasks")
public class TaskController {

    private final TaskServiceImpl taskService;

    public TaskController(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskRequest taskRequest) {
        return taskService.createTask(taskRequest);
    }

    @GetMapping("{taskStatus}")
    public Optional<List<Task>> findTaskByTaskStatus(@PathVariable TaskStatus taskStatus) {
        return taskService.findTaskByTaskStatus(taskStatus);
    }

    @PatchMapping("/changeTaskStatus/{taskId}")
    public Task changeTaskStatus(@PathVariable Long taskId, @RequestBody TaskStatus taskStatus) throws TaskNotFoundException {
        return taskService.changeTaskStatus(taskId, taskStatus);
    }

    @PostMapping("/TaskUpdate/{taskId}")
    public Task changeTaskDuration(@PathVariable Long taskId, @RequestBody TaskUpdateRequest taskUpdateRequest) throws TaskNotFoundException {
        return taskService.taskUpdate(taskId, taskUpdateRequest);
    }


}
