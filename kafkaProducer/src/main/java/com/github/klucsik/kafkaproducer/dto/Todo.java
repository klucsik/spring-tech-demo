package com.github.klucsik.kafkaproducer.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Todo {
    private Long id;
    private String todo;
    private LocalDate deadline;
}
