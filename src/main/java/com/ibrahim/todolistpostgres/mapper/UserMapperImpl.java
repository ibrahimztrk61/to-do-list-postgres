package com.ibrahim.todolistpostgres.mapper;

import com.ibrahim.todolistpostgres.domain.User;
import com.ibrahim.todolistpostgres.dtos.request.UserRequest;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl  implements UserMapper{
    @Override
    public UserRequest toUserRequest(User user) {
        return UserRequest.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .build();
    }

    @Override
    public User toUser(UserRequest userRequest) {
        return User.builder()
                .name(userRequest.getName())
                .surname(userRequest.getSurname())
                .build();
    }
}
