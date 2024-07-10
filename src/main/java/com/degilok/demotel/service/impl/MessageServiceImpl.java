package com.degilok.demotel.service.impl;

import com.degilok.demotel.model.Message;
import com.degilok.demotel.model.User;
import com.degilok.demotel.model.dto.MessageDto;
import com.degilok.demotel.repository.MessageRepository;
import com.degilok.demotel.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Message createMessage(MessageDto messageDto) {
        Message message = new Message();

        message.setResipient(messageDto.recipient());
        message.setMessage(messageDto.message());
        message.setLogin(messageDto.login());
        message.setMessageRead(messageDto.isMessageRead());
        return messageRepository.save(message);
    }


    @Override
    public List<Message> getUserMessagesByLogin(User user) {
        user.getLogin();

        List<Message> userMessage = messageRepository.findByLogin(user);
        return userMessage;
        //login.getLogin();
        //messageRepository.findAll();

//        messageRepository.findAllById(id);

        //getLogin();
    }
}
/*@Override
public List<Message> getUserMessagesByLogin(User user) {
    String login = user.getLogin(); // Получаем логин пользователя
    List<Message> userMessages = messageRepository.findByUserLogin(login); // Ищем сообщения пользователя по его логину
    return userMessages; // Возвращаем список сообщений пользователя
}*/

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