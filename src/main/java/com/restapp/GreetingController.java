package com.restapp;

import com.restapp.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class GreetingController {

    @Autowired
    private GreetingHandler greetingHandler;

    @Autowired
    private MessageRepo messageRepo;

    public GreetingController(GreetingHandler greetingHandler) {
        this.greetingHandler = greetingHandler;
    }

    @RequestMapping(value="/greeting", method=GET)
    public Greeting greeting(@RequestParam(value="id") Long id) {

        return greetingHandler.getGreeting(id, messageRepo.findById(id).orElse(new Message()).getText());

    }

    @RequestMapping(value="/greeting", method=POST)
    public Answer saveMessage(@RequestParam(value="message") String text) {
        Message message = new Message(text);
        return greetingHandler.getAnswer(messageRepo.save(message).getId(), text, messageRepo.count());
    }
}
