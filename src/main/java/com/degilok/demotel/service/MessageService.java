package com.degilok.demotel.service;

import com.degilok.demotel.model.Message;
import com.degilok.demotel.model.User;
import com.degilok.demotel.model.dto.MessageDto;

import java.util.List;

public interface MessageService {

    Message createMessage(MessageDto messageDto);

    List<Message> getUserMessagesByLogin(User login);

}
