package com.degilok.demotel.controller;

import com.degilok.demotel.exceptions.UserNotFoundException;
import com.degilok.demotel.model.User;
import com.degilok.demotel.model.dto.UserDto;
import com.degilok.demotel.repository.UserRepository;
import com.degilok.demotel.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Контроллер для создания юзера и получение юзера по айди",
        description = "два метода: create user и user by id")
@RequestMapping("/api/v1/tel")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @Operation(summary = "Создание юзера")
    @PostMapping("/create/users")
    public ResponseEntity<User> createUsers(@RequestBody UserDto userDto) {
        User userCreated = userService.createUser(userDto);
        return ResponseEntity.ok(userCreated);
    }

    @Operation(summary = "Получение юзера по айди")
    @GetMapping("/user-by-id/{id}")
    User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }
}