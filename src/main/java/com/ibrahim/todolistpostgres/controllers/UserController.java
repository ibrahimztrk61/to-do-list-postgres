package com.ibrahim.todolistpostgres.controllers;

import com.ibrahim.todolistpostgres.domain.User;
import com.ibrahim.todolistpostgres.dtos.request.UserRequest;
import com.ibrahim.todolistpostgres.exceptions.NullUserRequestException;
import com.ibrahim.todolistpostgres.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/todolist/users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @PostMapping("/createUser")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody @Valid UserRequest userRequest) throws NullUserRequestException {
        return userService.createUser(userRequest);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("{userId}")
    public User findUserById(@PathVariable Long userId) {
        return userService.findUserById(userId);
    }

    @GetMapping("/findUserById/{userName}")
    public List<User> getUserByName(@PathVariable String userName) {
        return userService.getUserByName(userName);
    }

    @DeleteMapping("/deleteUser/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }

}
