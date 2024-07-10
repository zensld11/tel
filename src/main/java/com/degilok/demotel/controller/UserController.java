package com.degilok.demotel.controller;

import com.degilok.demotel.exceptions.UserNotFoundException;
import com.degilok.demotel.model.User;
import com.degilok.demotel.model.dto.UserDto;
import com.degilok.demotel.repository.UserRepository;
import com.degilok.demotel.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tel")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping("/create/users")
    public ResponseEntity<User> createUsers(@RequestBody UserDto userDto) {
        User userCreated = userService.createUser(userDto);
        return ResponseEntity.ok(userCreated);
    }

    @GetMapping("/user-by-id/{id}")
    User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }
}