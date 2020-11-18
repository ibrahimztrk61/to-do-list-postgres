package com.ibrahim.todolistpostgres.controllers;

import com.ibrahim.todolistpostgres.domain.Task;
import com.ibrahim.todolistpostgres.domain.TaskStatus;
import com.ibrahim.todolistpostgres.dtos.request.TaskRequest;
import com.ibrahim.todolistpostgres.dtos.request.TaskUpdateRequest;
import com.ibrahim.todolistpostgres.exceptions.TaskNotFoundException;
import com.ibrahim.todolistpostgres.service.TaskServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaskControllerTest {

    @InjectMocks
    private TaskController taskController;

    @Mock
    private TaskServiceImpl taskService;

    @Test
    void it_should_create_task() {
        // Given
        TaskRequest taskRequest = new TaskRequest();
        taskRequest.setCategory("software");
        taskRequest.setDescription("swagger");
        taskRequest.setDuration("30");
        taskRequest.setUserId(1L);

        // When
        taskController.createTask(taskRequest);
        var taskRequestArgumentCaptor = ArgumentCaptor.forClass(TaskRequest.class);
        verify(taskService).createTask(taskRequestArgumentCaptor.capture());
        var capturedTaskRequest = taskRequestArgumentCaptor.getValue();

        // Then
        assertThat(capturedTaskRequest).isEqualToComparingFieldByField(taskRequest);
    }

    @Test
    void it_should_find_task_by_task_status_pending() throws TaskNotFoundException {
        // Given
        TaskStatus taskStatus = TaskStatus.PENDING;

        Task task = new Task();
        Task task1 = new Task();
        task.setTaskStatus(taskStatus);
        task1.setTaskStatus(taskStatus);
        task.setId(1L);
        task1.setId(2L);

        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task);

        // When
        when(taskService.findTaskByTaskStatus(taskStatus)).thenReturn(tasks);
        when(taskService.findTaskByTaskStatus(taskStatus)).thenReturn(tasks);
        List<Task> controllerTasks = taskController.findTaskByTaskStatus(taskStatus);

        // Then
        verify(taskService).findTaskByTaskStatus(taskStatus);
        assertThat(tasks).isEqualTo(controllerTasks);
    }

    @Test
    void it_should_find_task_by_task_status_done() throws TaskNotFoundException {
        // Given
        TaskStatus taskStatus = TaskStatus.DONE;

        Task task = new Task();
        Task task1 = new Task();
        task.setTaskStatus(taskStatus);
        task1.setTaskStatus(taskStatus);
        task.setId(1L);
        task1.setId(2L);

        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task);

        // When
        when(taskService.findTaskByTaskStatus(taskStatus)).thenReturn(tasks);
        when(taskService.findTaskByTaskStatus(taskStatus)).thenReturn(tasks);
        List<Task> controllerTasks = taskController.findTaskByTaskStatus(taskStatus);

        // Then
        verify(taskService).findTaskByTaskStatus(taskStatus);
        assertThat(tasks).isEqualTo(controllerTasks);
    }

    @Test
    void it_should_find_task_by_task_status_todo() throws TaskNotFoundException {
        // Given
        TaskStatus taskStatus = TaskStatus.TODO;

        Task task = new Task();
        Task task1 = new Task();
        task.setTaskStatus(taskStatus);
        task1.setTaskStatus(taskStatus);
        task.setId(1L);
        task1.setId(2L);

        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task);

        // When
        when(taskService.findTaskByTaskStatus(taskStatus)).thenReturn(tasks);
        when(taskService.findTaskByTaskStatus(taskStatus)).thenReturn(tasks);
        List<Task> controllerTasks = taskController.findTaskByTaskStatus(taskStatus);

        // Then
        verify(taskService).findTaskByTaskStatus(taskStatus);
        assertThat(tasks).isEqualTo(controllerTasks);
    }

    @Test
    void it_should_change_task_status() throws TaskNotFoundException {
        // Given
        TaskStatus taskStatus = TaskStatus.PENDING;

        Task task = new Task();

        task.setTaskStatus(TaskStatus.TODO);
        task.setId(1L);

        // When
        when(taskService.changeTaskStatus(1L, taskStatus)).thenReturn(task);
        Task controllerTask = taskController.changeTaskStatus(task.getId(), taskStatus);

        // Then
        verify(taskService).changeTaskStatus(1L, taskStatus);
        assertThat(task).isEqualTo(controllerTask);
    }

    @Test
    void it_should_change_task_duration() throws TaskNotFoundException {
        // Given
        String duration = "30";
        String updatedDuration = "45";

        Task task = new Task();
        task.setId(1L);
        task.setDuration(duration);

        TaskUpdateRequest updateRequest = new TaskUpdateRequest();
        updateRequest.setDuration(updatedDuration);


        // When
        when(taskService.taskUpdate(1L, updateRequest)).thenReturn(task);
        Task controllerTask = taskController.updateTask(task.getId(), updateRequest);

        // Then
        verify(taskService).taskUpdate(1L, updateRequest);
        assertThat(task.getDuration()).isEqualTo(controllerTask.getDuration());
    }
}