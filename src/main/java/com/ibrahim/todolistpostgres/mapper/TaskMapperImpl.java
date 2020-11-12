package com.ibrahim.todolistpostgres.mapper;

import com.ibrahim.todolistpostgres.domain.Task;
import com.ibrahim.todolistpostgres.domain.TaskStatus;
import com.ibrahim.todolistpostgres.dtos.request.TaskRequest;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {
    @Override
    public TaskRequest toTaskRequest(Task task) {
        return TaskRequest.builder()
                .category(task.getCategory())
                .description(task.getDescription())
                .duration(task.getDuration())
                .build();

    }

    @Override
    public Task toTask(TaskRequest taskRequest) {
        return Task.builder()
                .category(taskRequest.getCategory())
                .description(taskRequest.getDescription())
                .duration(taskRequest.getDuration())
                .taskStatus(TaskStatus.TODO)
                .build();

    }
}
