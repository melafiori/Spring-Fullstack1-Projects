package com.duoc.TaskFlow.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class TareaException extends RuntimeException{
    // Antiguo private String message;
    public TareaException(String message){
        super(message);
    }
}
