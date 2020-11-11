package com.ibrahim.todolistpostgres.controllers;

import com.ibrahim.todolistpostgres.domain.User;
import com.ibrahim.todolistpostgres.dtos.request.UserRequest;
import com.ibrahim.todolistpostgres.service.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/todolist/users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @PostMapping
    public User createUser(UserRequest userRequest){
       User user = userService.createUser(userRequest);
       return user;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping
    public void deleteUser(String userId){
        userService.deleteUser(userId);
    }

}
