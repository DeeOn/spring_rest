package com.restapp.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@org.aspectj.lang.annotation.Aspect
@Component
@Slf4j
public class Aspect {

    @Before("@annotation(LogRequestMethods)")
    public void logRequestMethods(JoinPoint joinPoint) throws Throwable {
        log.info("Executing method:" + joinPoint.toShortString());
    }
}
