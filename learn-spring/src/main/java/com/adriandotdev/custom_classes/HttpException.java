package com.adriandotdev.custom_classes;

import org.springframework.http.HttpStatus;


public class HttpException extends Exception{

    private final Object data;

    public HttpException (String message, Object data) {
        super(message);
        this.data = data;
    }

    @Override
    public String toString() {
        return "HttpException{" +
                "data=" + data +
                '}';
    }
}
