package com.ibrahim.todolistpostgres.controllers;

import com.ibrahim.todolistpostgres.domain.User;
import com.ibrahim.todolistpostgres.dtos.request.UserRequest;
import com.ibrahim.todolistpostgres.exceptions.NullUserRequestException;
import com.ibrahim.todolistpostgres.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserServiceImpl userService;

    @Test
    public void it_should_create_user() throws NullUserRequestException {
        // Given
        UserRequest userRequest = new UserRequest();
        userRequest.setName("ibrahim");
        userRequest.setSurname("öztürk");

        // When
        userController.createUser(userRequest);

        var userRequestArgumentCaptor = ArgumentCaptor.forClass(UserRequest.class);
        verify(userService).createUser(userRequestArgumentCaptor.capture());
        var capturedUserRequest = userRequestArgumentCaptor.getValue();

        // Then
        assertThat(capturedUserRequest).isEqualToComparingFieldByField(userRequest);

    }

    @Test
    public void it_should_get_all_users() {
        // Given

        // When
        userController.getAllUsers();

        // Then
        verify(userService).getAllUsers();

    }

    @Test
    void it_should_get_user_by_id() {
        // Given
        long id = 1L;
        User user = new User();
        user.setId(id);
        when(userService.findUserById(id)).thenReturn(user);
        // When
        User controllerUser = userController.findUserById(user.getId());
        // Then
        verify(userService).findUserById(1L);
        assertThat(user).isEqualTo(controllerUser);
    }


    @Test
    void it_should_delete_user() {
        // Given
        long id = 1L;

        // When
        userController.deleteUser(id);

        // Then
        verify(userService).deleteUser(id);
    }


}