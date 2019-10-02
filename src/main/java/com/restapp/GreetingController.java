package com.restapp;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@Log4j2
public class GreetingController {

    @Autowired
    private GreetingHandler greetingHandler;

    public GreetingController(GreetingHandler greetingHandler) {
        this.greetingHandler = greetingHandler;
    }

    @RequestMapping(value="/greeting", method=GET)
    public CompletableFuture<Greeting> greeting(@RequestParam(value="id") Long id) {

            log.info("GET by id=" + id);
            return greetingHandler.requestGreeting(id);

    }

    @RequestMapping(value="/greeting", method=POST)
    public CompletableFuture<Answer> saveMessage(@RequestParam(value="message") String message) {

            log.info("POST with message=" + message);
            return greetingHandler.requestAnswer(message);

    }
}
