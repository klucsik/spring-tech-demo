package com.github.klucsik.kafkaproducer.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ToDo {
    private Long id;
    private String todo;
    private LocalDate deadline;
}
