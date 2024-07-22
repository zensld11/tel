package com.degilok.demotel.service;

import com.degilok.demotel.model.User;
import com.degilok.demotel.model.dto.UserDto;

public interface UserService {

        User createUser(UserDto userDto);
}