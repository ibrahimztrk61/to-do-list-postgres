package com.ibrahim.todolistpostgres.service;

import com.ibrahim.todolistpostgres.domain.User;
import com.ibrahim.todolistpostgres.dtos.request.UserRequest;
import com.ibrahim.todolistpostgres.mapper.UserMapperImpl;
import com.ibrahim.todolistpostgres.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapperImpl userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapperImpl userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User createUser(UserRequest userRequest) {
        User user = userMapper.toUser(userRequest);
        return userRepository.save(user);

    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(String userId) {
       userRepository.deleteById(userId);
    }




}
