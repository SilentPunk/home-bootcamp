package com.example.homebootcamp.messageproducer;

import com.example.homebootcamp.interfaces.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SimpleMessageProducer implements MessageProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public SimpleMessageProducer(KafkaTemplate kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendMessage(String message) {
        kafkaTemplate.send("Sample", message);
    }
}
