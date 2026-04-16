package com.duoc.vetLife.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MascotaDTO {
    private String nombreMascota;
    private String especieMascota;
    private String nombreDuenio;
    private String estadoMascota;
}
