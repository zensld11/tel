package com.degilok.demotel.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(Long id){
        System.out.println("Couldn't found the user with id + id");
    }
}