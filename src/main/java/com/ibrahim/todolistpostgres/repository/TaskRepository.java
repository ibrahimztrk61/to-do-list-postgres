package com.ibrahim.todolistpostgres.repository;

import com.ibrahim.todolistpostgres.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
