package com.adriandotdev.custom_classes;

import org.springframework.http.HttpStatus;

public class HttpBadRequest extends HttpException {

    private final HttpStatus status = HttpStatus.BAD_REQUEST;

    public HttpBadRequest(String message, HttpStatus status, Object data) {
        super(message, data);
    }

    public HttpStatus GetStatus() {
        return this.status;
    }
}
