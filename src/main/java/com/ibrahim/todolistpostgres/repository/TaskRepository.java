package com.ibrahim.todolistpostgres.repository;

import com.ibrahim.todolistpostgres.domain.Task;
import com.ibrahim.todolistpostgres.domain.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findTaskByTaskStatus(TaskStatus taskStatus);

}
