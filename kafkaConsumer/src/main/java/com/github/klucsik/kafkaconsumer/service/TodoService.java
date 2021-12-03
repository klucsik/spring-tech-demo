package com.github.klucsik.kafkaconsumer.service;

import com.github.klucsik.kafkaconsumer.dto.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {


    @KafkaListener(topics = "todo", containerFactory = "todoKafkaListenerContainerFactory" )
    public void consumeTodo(Todo todo){
        System.out.println("received todo: " + todo);
    }
}
