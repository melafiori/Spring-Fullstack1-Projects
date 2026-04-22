package com.duoc.gourmetApp.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "reservas")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reserva_id")
    private Long id;

    @NotBlank(message = "El campo Rut no puede estar vacío.")
    @Column(name = "rut_cliente", unique = true, nullable = false)
    private String rut;

    @NotBlank(message = "El campo nombre de cliente NO puede estar vacío.")
    @Column(name = "nombre_cliente", nullable = false)
    private String nombreCliente;

    @Column(name = "cantidad_personas")
    private int cantidadPersonas;

    @NotNull(message = "El campo fechaReserva no puede ser nulo")
    @Column(name = "fecha_reserva")
    private LocalDate fechaReserva;

    @Column(name = "estado_reserva")
    private String estadoReserva;

    @Embedded
    Audit audit = new Audit();
}
