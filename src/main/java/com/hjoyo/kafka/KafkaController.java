package com.hjoyo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @GetMapping("/send")
    public String sendMessage(@RequestParam (defaultValue = "Hello World") String message) {
        String topic = "order-topic";
        kafkaProducerService.sendMessage(topic, message);
        return "Message sent to Kafka topic: " + topic + ", with content: " + message;
    }
}
