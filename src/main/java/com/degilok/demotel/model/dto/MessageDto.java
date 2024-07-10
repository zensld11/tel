package com.degilok.demotel.model.dto;

import com.degilok.demotel.model.User;

public record MessageDto(
        String message,
        boolean isMessageRead,
        String recipient,
        User login
) {
}
//User login был здесь