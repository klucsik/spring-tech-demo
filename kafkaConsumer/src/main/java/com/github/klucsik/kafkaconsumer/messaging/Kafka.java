package com.github.klucsik.kafkaconsumer.messaging;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Kafka {
    @KafkaListener(topics = "hello")
    public void listenTodo(String message) {
        System.out.println("Received Message on hello topic: " + message);
    }
}
