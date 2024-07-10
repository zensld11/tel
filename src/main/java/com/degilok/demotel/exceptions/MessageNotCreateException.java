package com.degilok.demotel.exceptions;

import org.springframework.http.HttpStatus;

public class MessageNotCreateException extends Exception{

    public MessageNotCreateException(){
        System.out.println(HttpStatus.INTERNAL_SERVER_ERROR + "Ошибка при создании сообщения");
    }
}
