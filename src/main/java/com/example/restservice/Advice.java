package com.example.restservice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Advice {
    @Pointcut("execution(Greeting com.example.restservice.GreetingController.greeting(String))")
    public void greetingPointcut() {
    }

    @Around("greetingPointcut()")
    public Object afterReturning(ProceedingJoinPoint jp) throws Throwable {
        Greeting greeting = (Greeting) jp.proceed();
        return new Greeting(greeting.getId() + 10, greeting.getContent());
    }
}
