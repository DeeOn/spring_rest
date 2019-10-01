package com.restapp.AOP;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@org.aspectj.lang.annotation.Aspect
@Component
@Log4j2
public class Aspect {

    @Before("@annotation(LogRequestMethods)")
    public void logRequestMethods(JoinPoint joinPoint) throws Throwable {
        log.info("Executing method:" + joinPoint.toShortString());
    }
}
