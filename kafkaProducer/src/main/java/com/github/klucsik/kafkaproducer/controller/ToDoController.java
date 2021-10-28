package com.github.klucsik.kafkaproducer.controller;

import com.github.klucsik.kafkaproducer.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ToDoController {

    @Autowired
    private final ToDoService service;

    @GetMapping("/generate")
    public String generate(@RequestParam  Integer number){
        service.createToDos(number);
        return "sent messages!";
    }
}
