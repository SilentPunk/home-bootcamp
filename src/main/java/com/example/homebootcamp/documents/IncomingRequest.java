package com.example.homebootcamp.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Map;

@Document
public class IncomingRequest {

    @Id
    private String id;

    private Map incomingHeaders;

    private Map incomingBody;

    private Date timestamp;

    private String requestIdentifier;

    public IncomingRequest(Map incomingHeaders, Map incomingBody, Date timestamp, String requestIdentifier){
        this.incomingHeaders = incomingHeaders;
        this.incomingBody = incomingBody;
        this.timestamp = timestamp;
        this.requestIdentifier = requestIdentifier;
    }
}
