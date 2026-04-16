package com.hospitalVM.atenciones.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalTime;

@Entity
@Table(name = "atenciones")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Atencion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atencion")
    private Long idAtencion;

    @NotNull(message = "El campo de hora atención no puede estar vacío")
    @Column(name = "hora_atencion", nullable = false)
    private LocalTime horaAtencion;

    @NotNull(message = "El campo de costo no puede estar vacío")
    @Column(nullable = false)
    private Double costo;

    private String comentario;

    @NotNull(message = "El campo médico no puede ser vacío.")
    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;

    @NotNull(message = "El campo paciente no puede ser vacío.")
    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

}
