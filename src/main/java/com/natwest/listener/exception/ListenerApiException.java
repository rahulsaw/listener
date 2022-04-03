package com.natwest.listener.exception;

import lombok.Getter;

/*
created by Rahul sawaria on 03/04/22
*/
public enum ListenerApiException {
    SOMETHING_WENT_WRONG("Seems like something went wrong"),
    UNAUTHORIZED("unauthorized request"),
    INVALID_REQUEST("{0} length should be of 11 digit"),
    EMPTY_REQUEST("Request body is empty"),
    INVALID_AMOUNT("Enter valid amount value");

    @Getter
    private final String message;

    ListenerApiException(String message) {
        this.message = message;
    }
}
