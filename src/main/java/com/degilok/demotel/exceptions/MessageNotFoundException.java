package com.degilok.demotel.exceptions;

public class MessageNotFoundException extends RuntimeException{

    public MessageNotFoundException(String message){
        System.out.println("Message not found" + message);

    }
}
