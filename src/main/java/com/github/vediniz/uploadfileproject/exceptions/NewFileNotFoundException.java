package com.github.vediniz.uploadfileproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
class NewFileNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public NewFileNotFoundException(String ex){
        super(ex);
    }

    public NewFileNotFoundException(String ex, Throwable cause){
        super(ex, cause);
    }
}