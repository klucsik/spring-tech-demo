package com.github.klucsik.kafkaproducer.messaging;

import com.github.klucsik.kafkaproducer.dto.ToDo;
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
    private KafkaTemplate<String, ToDo> kafkaTemplate;

    @Value(value = "${kafka.todotopicname}")
    private String topicName;

    public void sendMessage(ToDo toDo) {

        ListenableFuture<SendResult<String, ToDo>> future =
                kafkaTemplate.send(topicName, toDo); //if we just call this, without the future = part it'll be blocking

        future.addCallback(new ListenableFutureCallback<SendResult<String, ToDo>>() {

            @Override
            public void onSuccess(SendResult<String, ToDo> result) {
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
