package com.github.klucsik.kafkaproducer.service;

import com.github.klucsik.kafkaproducer.messaging.KafkaTodo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ToDoService {
    @Autowired
    private final KafkaTodo kafkaTodo;

    private final GenerateTodo generateTodo;

    public void createToDos(Integer number){
        for(int i=0; i<number; i++) {
            kafkaTodo.sendMessage( generateTodo.generate());
        }
    }
}
