package com.github.klucsik.kafkaproducer.cmdrunners;

import com.github.klucsik.kafkaproducer.messaging.Kafka;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TestMessage implements CommandLineRunner {

    @Autowired
    private final Kafka kafka;

    public void run(String... args) {
        sendFirstMessage();
    }

    private void sendFirstMessage(){
        kafka.sendMessage("hello","world");
    }
}
