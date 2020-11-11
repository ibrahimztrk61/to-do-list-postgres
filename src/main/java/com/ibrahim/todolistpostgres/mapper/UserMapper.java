package com.ibrahim.todolistpostgres.mapper;

import com.ibrahim.todolistpostgres.domain.User;
import com.ibrahim.todolistpostgres.dtos.request.UserRequest;

public interface UserMapper {

    UserRequest toUserRequest(User user);

    User toUser(UserRequest userRequest);
}
