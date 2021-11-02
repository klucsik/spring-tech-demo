package com.github.klucsik.kafkaproducer.messaging;

import com.github.klucsik.kafkaproducer.dto.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class KafkaTodo {

    @Autowired
    private KafkaTemplate<String, Todo> kafkaTemplate;

    @Value(value = "${kafka.todotopicname}")
    private String topicName;

    public void sendMessage(Todo toDo) {

        ListenableFuture<SendResult<String, Todo>> future =
                kafkaTemplate.send(topicName, toDo); //if we just call this, without the future = part it'll be blocking

        future.addCallback(new ListenableFutureCallback<SendResult<String, Todo>>() {

            @Override
            public void onSuccess(SendResult<String, Todo> result) {
                System.out.println("Sent message=[" + toDo +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=["
                        + toDo + "] due to : " + ex.getMessage());
            }
        });
    }
}
