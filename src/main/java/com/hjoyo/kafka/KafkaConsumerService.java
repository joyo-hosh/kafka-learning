package com.hjoyo.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(
            topics = "order-topic",
            groupId = "my-group"
    )
    public void consumeMessage(String message) {
        System.out.println("Message received from Kafka topic: " + message);
        // Here you can add logic to process the message, e.g., save to database, call another service, etc.
    }
}
