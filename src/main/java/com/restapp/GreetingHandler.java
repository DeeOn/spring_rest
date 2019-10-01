package com.restapp;

import com.restapp.AOP.LogRequestMethods;
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
    @LogRequestMethods
    public CompletableFuture<Greeting> requestGreeting(long id) {

//        try {
//            Thread.sleep(10000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return CompletableFuture.completedFuture(new Greeting(id, messageRepo.findById(id).orElse(new Message()).getText()));
    }

    @Async
    @LogRequestMethods
    public CompletableFuture<Answer> requestAnswer(String message) {

        return CompletableFuture.completedFuture(new Answer(messageRepo.save(new Message(message)).getId(), message, messageRepo.count()));

    }
}
