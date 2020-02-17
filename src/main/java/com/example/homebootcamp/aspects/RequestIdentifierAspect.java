package com.example.homebootcamp.aspects;

import com.example.homebootcamp.annotations.AddRequestIdentifier;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

import static com.example.homebootcamp.constants.RequestConstants.REQUEST_IDENTIFIER;

@Aspect
@Order(0)
@Component
public class RequestIdentifierAspect {


    @Pointcut("@annotation(addRequestIdentifier)")
    public void addRequestIdentifierPointcut(AddRequestIdentifier addRequestIdentifier){};

    @Before("addRequestIdentifierPointcut(addRequestIdentifier) && args(@RequestHeader headers, ..)")
    public void addRequestIdentifierToRequestHeaders(AddRequestIdentifier addRequestIdentifier, Map<String, String> headers){
        String identifier = UUID.randomUUID().toString();
        headers.put(REQUEST_IDENTIFIER, identifier);
    }
}
