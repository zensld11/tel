package com.degilok.demotel.service;

import com.degilok.demotel.model.Message;
import com.degilok.demotel.model.User;
import com.degilok.demotel.model.dto.MessageDto;

public interface MessageService {

    Message createMessage(MessageDto messageDto);

    Message getUserMessagesByLogin(User login, Message message);

}
