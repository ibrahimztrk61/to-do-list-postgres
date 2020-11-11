package com.ibrahim.todolistpostgres.service;

import com.ibrahim.todolistpostgres.domain.User;
import com.ibrahim.todolistpostgres.dtos.request.UserRequest;

import java.util.List;

public interface UserService {

    User createUser(UserRequest userRequest);

    void deleteUser(String userId);

    List<User> getAllUsers();
}
