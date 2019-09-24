package com.restapp;

import com.restapp.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class GreetingHandler {

    @Autowired
    private MessageRepo messageRepo;

    public Greeting getGreeting(long id) {

        return new Greeting(id, messageRepo.findById(id).orElse(new Message()).getText());

    }

    public Answer getAnswer(String message) {
        return new Answer(messageRepo.save(new Message(message)).getId(), message, messageRepo.count());
    }
}
