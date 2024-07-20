package com.degilok.demotel.controller;

import com.degilok.demotel.exceptions.MessageNotCreateException;
import com.degilok.demotel.exceptions.MessageNotFoundException;
import com.degilok.demotel.model.Message;
import com.degilok.demotel.model.User;
import com.degilok.demotel.model.dto.MessageDto;
import com.degilok.demotel.service.MessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@Tag(name = "Контроллер для создания сообщений и получение всех сообщение по логину юзера",
        description = "два метода: create message и messageLogin")
@RequestMapping("/api/tel2")
public class MessageController {

    private final MessageService messageService;


    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @Operation(summary = "Создание сообщений")
    @PostMapping("/create/messages")
    public ResponseEntity<Message> createMessages(@RequestBody MessageDto messageDto) throws MessageNotCreateException {

        Message messageCreated = messageService.createMessage(messageDto);
        if (messageCreated == null) {
            throw new MessageNotCreateException();
        }
        return ResponseEntity.ok(messageCreated);
    }

    @Operation(summary = "Получение всех сообщений по логину юзера")
    @GetMapping("/messages/{login}")
    public ResponseEntity<List<Message>> getMessage(@PathVariable User login) {
        try {
            List<Message> userMessages = messageService.getUserMessagesByLogin(login);
            return ResponseEntity.ok(userMessages);
        } catch (MessageNotFoundException w) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Сообщение пользователя не найдено", w);
        }
    }

//    @GetMapping("/mess/{login}")
//    String get(@PathVariable String login){
//         return messageService.getUsersMessage(login);
//    }

}

//    @GetMapping("/messages")
//    Message getMessage(@PathVariable User login) {
//        try {
//             messageService.getUserMessagesByLogin(login);
//        } catch (MessageNotFoundException w) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Сообщение не найдено", w);
//        }
//        return "sdfd";
//    }