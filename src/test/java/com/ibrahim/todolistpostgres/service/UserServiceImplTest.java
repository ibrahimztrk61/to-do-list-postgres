package com.ibrahim.todolistpostgres.service;

import com.ibrahim.todolistpostgres.domain.User;
import com.ibrahim.todolistpostgres.dtos.request.UserRequest;
import com.ibrahim.todolistpostgres.exceptions.NullUserRequestException;
import com.ibrahim.todolistpostgres.repository.TaskRepository;
import com.ibrahim.todolistpostgres.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private TaskRepository taskRepository;


    @Test
    void it_should_create_user() throws NullUserRequestException {
        UserRequest userRequest = new UserRequest();
        userRequest.setName("ibrahim");
        userRequest.setSurname("öztürk");
        userRequest.setId(1L);

        User mockUser = mock(User.class);

        when(mockUser.getId()).thenReturn(1L);
        when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(mockUser);

        User result = userService.createUser(userRequest);


        assertEquals(result.getId(),userRequest.getId());
        assertEquals(result.getSurname(),userRequest.getSurname());
        assertEquals(result.getName(), userRequest.getName());

    }

    @Test
    void it_should_get_all_user() {
        User user = new User();
        user.setId(1L);
        user.setName("ibrahim");
        user.setSurname("öztürk");

        when(userRepository.findAll()).thenReturn(Collections.singletonList(user));
        List<User> userList = userService.getAllUsers();

        assertEquals(userList.size(), 1);
        assertEquals(userList.get(0), User.builder().id(1L).name("ibrahim").surname("öztürk").build());
    }

    @Test
    void findUserById() {
    }

    @Test
    void getUserByName() {
    }

    @Test
    void deleteUser() {
    }
}