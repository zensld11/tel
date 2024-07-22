package com.degilok.demotel.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserServiceImpl sut;

    @Test
    void getUserByLogin() {
        sut.getUserByLogin("Adelina");
    }
}