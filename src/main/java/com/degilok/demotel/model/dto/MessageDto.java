package com.degilok.demotel.model.dto;

public record MessageDto(
        String message,
        boolean isMessageRead,
        String recipient,
        String login
) {
}