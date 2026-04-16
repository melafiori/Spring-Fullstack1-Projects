package com.duoc.TechStore.models;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @NotNull(message = "El campo ID no puede estar vacío")
    private Long id;


    private String modelName;
    private String brand;
    private String category;
    private Double price;
    private Integer stock;
}
