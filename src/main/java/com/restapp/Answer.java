package com.restapp;

import lombok.Getter;

@Getter
public class Answer {

    private final long id;
    private final String message;
    private final long count;

    public Answer(long id, String message, long count) {
        this.id = id;
        this.message = message;
        this.count = count;
    }
}
