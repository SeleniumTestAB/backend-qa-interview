package com.qa.interview.sollution.full.stack.sollution.backend.dictonary;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorDict {

    BAD_REQUEST_CONDITION(HttpStatus.SC_BAD_REQUEST, "Bad Request", "/weather/condition");

    private final int status;
    private final String error;
    private final String path;
}
