package com.ibrahim.todolistpostgres.repository;

import com.ibrahim.todolistpostgres.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

     List<User> getUserByName(String name);
}