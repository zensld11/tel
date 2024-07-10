package com.degilok.demotel.controller;

import com.degilok.demotel.exceptions.MessageNotCreateException;
import com.degilok.demotel.exceptions.MessageNotFoundException;
import com.degilok.demotel.model.Message;
import com.degilok.demotel.model.User;
import com.degilok.demotel.model.dto.MessageDto;
import com.degilok.demotel.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {

    private final MessageService messageService;


    public MessageController(MessageService messageService) {
        this.messageService = messageService;
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
    @GetMapping("/messages/{login}")
    public ResponseEntity<List<Message>> getMessage(@PathVariable User login){
        try {
            List<Message> userMessages = messageService.getUserMessagesByLogin(login);
            return ResponseEntity.ok(userMessages);
        }
        catch (MessageNotFoundException w){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Сообщение пользователя не найдено", w);
        }
    }

    @PostMapping("/create/messages")
    public ResponseEntity<Message> createMessages(@RequestBody MessageDto messageDto) throws MessageNotCreateException {
        Message messageCreated = messageService.createMessage(messageDto);
        messageCreated.setDateCreate(LocalDate.now());
        if (messageCreated == null) {
            throw new MessageNotCreateException();
        }
        return ResponseEntity.ok(messageCreated);
    }
}