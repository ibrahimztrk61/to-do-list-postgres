package com.ibrahim.todolistpostgres.service;

import com.ibrahim.todolistpostgres.domain.User;
import com.ibrahim.todolistpostgres.dtos.request.UserRequest;
import com.ibrahim.todolistpostgres.exceptions.NullUserRequestException;
import com.ibrahim.todolistpostgres.mapper.UserMapperImpl;
import com.ibrahim.todolistpostgres.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

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
    @Transactional
    public User createUser(UserRequest userRequest) throws NullUserRequestException {
        if (userRequest == null) {
            throw new NullUserRequestException();
        }
        Assert.notNull(userRequest.getName(), "Name space must not be empty!");

        User user = userMapper.toUser(userRequest);
        System.out.println(" user id: " + userRequest.getId());
        return userRepository.save(user);

    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long userId) {
    }




}
