package com.example.homebootcamp.interfaces;

import com.example.homebootcamp.annotations.PersistIncomingRequest;
import com.example.homebootcamp.annotations.PersistResponse;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.Inherited;
import java.util.Map;


public interface BaseController {

    @RequestMapping(value = "/",
            consumes="application/json",
            produces="application/json",
            method= RequestMethod.POST)

    public ResponseEntity putRequest(@RequestHeader Map headers, @RequestBody JSONObject requestBody);
}
