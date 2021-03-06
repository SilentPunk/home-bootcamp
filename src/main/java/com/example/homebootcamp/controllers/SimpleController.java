package com.example.homebootcamp.controllers;

import com.example.homebootcamp.annotations.AddRequestIdentifier;
import com.example.homebootcamp.annotations.PersistIncomingRequest;
import com.example.homebootcamp.annotations.PersistResponse;
import com.example.homebootcamp.interfaces.BaseController;
import com.example.homebootcamp.interfaces.MessageProducer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Component
public class SimpleController implements BaseController {
    private final Logger logger = LogManager.getLogger(getClass().getName());
    private final MessageProducer messageProducer;

    @Autowired
    public SimpleController(MessageProducer messageProducer){
        this.messageProducer = messageProducer;
    }

    @AddRequestIdentifier
    @PersistIncomingRequest
    @PersistResponse
    public ResponseEntity putRequest(@RequestHeader Map headers,
                                     @RequestBody JSONObject requestBody){

        JSONObject body = new JSONObject(requestBody);
        messageProducer.sendMessage("test");
        return null;
    }
}
