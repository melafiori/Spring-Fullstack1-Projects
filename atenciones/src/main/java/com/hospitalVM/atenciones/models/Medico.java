package com.hospitalVM.atenciones.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "medicos")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="medico_id")
    private Long medicoId;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "El campo rut no puede estar vacío.")
    @Pattern(regexp = "\\d{1,8}-[\\dKk]", message = "El formato tiene que ser 12345678-9")
    private String run;

    @Column(nullable = false, name= "nombre_completo")
    @NotBlank(message = "El campo Nombre Completo no puede estar vacío.")
    private String nombreCompleto;

    @Column(name="jefe_turno", nullable = false)
    @NotNull(message = "El campo Jefe de Turno no puede ser nulo.")
    private Boolean jefeTurno;

    @Embedded
    private Audit audit = new Audit();
}
