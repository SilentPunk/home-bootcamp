package com.example.homebootcamp.aspects;

import com.example.homebootcamp.annotations.PersistIncomingRequest;
import com.example.homebootcamp.annotations.PersistResponse;
import com.example.homebootcamp.documents.IncomingRequest;
import com.example.homebootcamp.repository.IncomingRequestLogRepository;
import org.aspectj.lang.annotation.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Component
@Aspect
public class PersistAspect {

    @Autowired
    private IncomingRequestLogRepository incomingRequestLogRepository;

    @Pointcut("@annotation(persistIncomingRequest)")
    public void beforeIncomingRequest(PersistIncomingRequest persistIncomingRequest){};

    @Pointcut("@annotation(persistResponse)")
    public void afterReturnResponse(PersistResponse persistResponse){};

    @Before("beforeIncomingRequest(persistIncomingRequest) && args(@RequestHeader headers, @RequestBody requestBody)")
    public void persistIncomingRequest(PersistIncomingRequest persistIncomingRequest, Map headers, JSONObject requestBody){
        String requestIdentifier = UUID.randomUUID().toString();
        Date date = new Date();
        incomingRequestLogRepository.save(new IncomingRequest(headers, requestBody.toMap(), date, requestIdentifier));
    }

    @AfterReturning(value = "afterReturnResponse(persistResponse)", returning = "returnedValue")
    public void persistResponse(PersistResponse persistResponse, Object returnedValue){

    }
}
