package com.degilok.demotel.service.impl;

import com.degilok.demotel.model.Message;
import com.degilok.demotel.model.User;
import com.degilok.demotel.model.dto.MessageDto;
import com.degilok.demotel.repository.MessageRepository;
import com.degilok.demotel.service.MessageService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final UserServiceImpl userService;

    public MessageServiceImpl(MessageRepository messageRepository, UserServiceImpl userService) {
        this.messageRepository = messageRepository;
        this.userService = userService;
    }

    @Override
    public Message createMessage(MessageDto messageDto) {
        Message message = new Message();

        message.setRecipient(messageDto.recipient());
        message.setMessage(messageDto.message());
        message.setLogin(userService.getUserByLogin(messageDto.login()));
        message.setMessageRead(messageDto.isMessageRead());
        message.setDateCreate(LocalDate.now());
        return messageRepository.save(message);
    }

//    @Override
//    public String getUsersMessage(String login){
//
//        Message message = (Message) messageRepository.findByLogin(login);
//
//        message.getLogin();
//        message.getDateCreate();
//        message.getRecipient();
//        message.getDateCreate();
//
//        return message.getMessage();
//    }


    @Override
    public List<Message> getUserMessagesByLogin(User user) {
        user.getLogin();

        List<Message> userMessage = messageRepository.findByLogin(user);


        return userMessage;
    }
}

//    @Override
//    public Message getUserMessages(Message message) {
//        message.getMessage();
//        message.getAuthor();
//        message.getResipient();
//        message.getDateCreate();
//        return null;
//    }

/*// самый правильный на сейчас метод
   @Override
//    public Message getUserMessagesByLogin(User login, Message message) {
//        login.getLogin();
//        message.getMessage();
//        message.getAuthor();
//        message.getResipient();
//        message.getDateCreate();
//        return null;
//    }
 */