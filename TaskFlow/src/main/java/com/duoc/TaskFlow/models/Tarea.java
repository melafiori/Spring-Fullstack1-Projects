package com.duoc.TaskFlow.models;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarea {

    private Long id;

    private String taskDescription;
    private Integer taskPriority;
    private String taskState;
    private String taskDate;
    private LocalDateTime fecha;
}
