package com.libraryApi.library.exceptions.ex;

public class UserAlreadyBorrowed extends RuntimeException{
    
    public UserAlreadyBorrowed(String msg){
        super(msg);
    }
}
