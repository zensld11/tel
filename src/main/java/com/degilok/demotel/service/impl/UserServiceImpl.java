package com.degilok.demotel.service.impl;

import com.degilok.demotel.model.User;
import com.degilok.demotel.model.dto.UserDto;
import com.degilok.demotel.repository.UserRepository;
import com.degilok.demotel.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(UserDto userDto) {

        User user = new User();

        user.setLogin(userDto.login());
        user.setPhone(userDto.phone());
        user.setPassword(userDto.password());
        return userRepository.save(user);
    }

    public User getUserByLogin(String login){
        User user =  userRepository.getUserByLogin(login);
        return user;
    }
}