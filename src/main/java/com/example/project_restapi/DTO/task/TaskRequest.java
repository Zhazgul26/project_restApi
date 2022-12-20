package com.example.project_restapi.DTO.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequest {
    private String taskName;
    private String taskText;
    private LocalDate deadLine;
}
