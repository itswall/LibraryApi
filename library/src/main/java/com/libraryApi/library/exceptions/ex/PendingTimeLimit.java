package com.libraryApi.library.exceptions.ex;

public class PendingTimeLimit extends RuntimeException{
    
    public PendingTimeLimit(String msg){
        super(msg);
    }
}
