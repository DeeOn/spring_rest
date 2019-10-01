package com.restapp;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

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
    public Greeting greeting(@RequestParam(value="id") Long id, HttpServletRequest request, HttpServletResponse response) {

        try {
            log.info("GET by id=" + id);
            log.info(request.getQueryString());
            return greetingHandler.requestGreeting(id).get(5L, TimeUnit.SECONDS);

        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } catch (ExecutionException e) {
            e.printStackTrace();
            return null;
        } catch (TimeoutException e) {
            log.error("TimeoutException");
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new Greeting(-1, "TIMEOUT");
        }

    }

    @RequestMapping(value="/greeting", method=POST)
    public Answer saveMessage(@RequestParam(value="message") String message) {

        try {
            log.info("POST with message=" + message);
            return greetingHandler.requestAnswer(message).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } catch (ExecutionException e) {
            e.printStackTrace();
            return null;
        }

    }
}
