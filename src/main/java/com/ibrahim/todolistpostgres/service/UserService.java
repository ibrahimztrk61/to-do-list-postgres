package com.ibrahim.todolistpostgres.service;

import com.ibrahim.todolistpostgres.domain.User;
import com.ibrahim.todolistpostgres.dtos.request.UserRequest;
import com.ibrahim.todolistpostgres.exceptions.NullUserRequestException;

import java.util.List;

public interface UserService {

    User createUser(UserRequest userRequest) throws NullUserRequestException;

    void deleteUser(Long userId);

    List<User> getAllUsers();

}
