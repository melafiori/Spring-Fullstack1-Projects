package com.duoc.bibiloteca.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @NotNull(message = "El campo ID es obligatorio.")
    private Long id;

    @NotNull(message = "El campo ISBN es obligatorio.")
    @NotBlank(message = "El campo ISBN no puede estar vacío.")
    private String isbn;
    private String title;
    private String editorial;
    @NotNull(message = "El campo fecha no puede estar vacío.")
    private Integer publishDate;
    private String author;



}
