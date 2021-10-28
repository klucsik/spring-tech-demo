package com.github.klucsik.kafkaproducer.service;

import com.github.klucsik.kafkaproducer.messaging.Kafka;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ToDoService {
    @Autowired
    private final Kafka kafka;

    private final GenerateTodo generateTodo;

    public void createToDos(Integer number){
        for(int i=0; i<number; i++) {
            kafka.sendMessage("todo", generateTodo.generate());
        }
    }
}
