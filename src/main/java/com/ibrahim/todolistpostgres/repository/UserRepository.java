package com.ibrahim.todolistpostgres.repository;

import com.ibrahim.todolistpostgres.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}