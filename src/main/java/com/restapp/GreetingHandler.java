package com.restapp;

import com.restapp.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class GreetingHandler {

    @Autowired
    private MessageRepo messageRepo;

    @Async
    public CompletableFuture<Greeting> requestGreeting(long id) {
        return CompletableFuture.completedFuture(new Greeting(id, messageRepo.findById(id).orElse(new Message()).getText()));
    }

    @Async
    public CompletableFuture<Answer> requestAnswer(String message) {
        try {
            Thread.sleep(5000L);
            return CompletableFuture.completedFuture(new Answer(messageRepo.save(new Message(message)).getId(), message, messageRepo.count()));
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
