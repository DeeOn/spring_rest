package com.restapp;

import org.springframework.stereotype.Component;

@Component
public class GreetingHandler {

    public Greeting getGreeting(long id, String message) {

        return new Greeting(id, message);

    }

    public Answer getAnswer(long id, String message, long count) {

        return new Answer(id, message, count);
    }
}
