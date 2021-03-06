package com.github.klucsik.kafkaproducer.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class KafkaHelloWorld {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * Send a String message to any topic in an async, nonblocking way
     * @param topicName
     * @param message
     */
    public void sendMessage(String topicName,String message) {

        ListenableFuture<SendResult<String, String>> future =
                kafkaTemplate.send(topicName, message); //if we just call this, without the future = part it'll be blocking

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("Sent message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=["
                        + message + "] due to : " + ex.getMessage());
            }
        });
    }
}
