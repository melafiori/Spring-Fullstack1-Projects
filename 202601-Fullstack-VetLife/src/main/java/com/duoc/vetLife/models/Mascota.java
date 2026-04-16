package com.duoc.vetLife.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mascota {

    @NotNull (message = "El campo ID es obligatorio")
    private Long id;

    @NotBlank(message = "El campo nombreMascota no puede estar vacío")
    @NotNull (message = "El campo nombreMascota es obligatorio")
    private String nombreMascota;
    private String especieMascota;
    private int edadMascota;
    private String nombreDuenio;
    private double pesoMascota;
    private String estadoMascota;
}
