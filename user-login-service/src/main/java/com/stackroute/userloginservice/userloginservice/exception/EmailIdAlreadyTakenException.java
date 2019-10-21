package com.stackroute.userloginservice.userloginservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FOUND)
public class EmailIdAlreadyTakenException extends RuntimeException {

    public EmailIdAlreadyTakenException(String message) {
        super(message);
    }
}
