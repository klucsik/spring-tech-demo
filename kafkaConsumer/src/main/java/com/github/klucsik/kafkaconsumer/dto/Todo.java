package com.github.klucsik.kafkaconsumer.dto;

import lombok.Data;

import java.time.LocalDate;
//FIXME: violating DRY! Import this directly from consuemr, or make a common dep from this
@Data
public class Todo {
    private Long id;
    private String todo;
    private LocalDate deadline;
}
