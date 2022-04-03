package com.natwest.listener.exception;

import lombok.Getter;

/*
created by Rahul sawaria on 03/04/22
*/
@Getter
public class ListenerBaseException extends RuntimeException {

    private String name;
    private final String message;

    public ListenerBaseException(String message) {
        super();
        this.message = message;
    }

    public ListenerBaseException(String name, String message) {
        super();
        this.name = name;
        this.message = message;
    }
}
