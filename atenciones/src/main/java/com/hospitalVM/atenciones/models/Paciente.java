package com.hospitalVM.atenciones.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pacientes")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Paciente {

    /**
     * @ID -> Se define como la llave primaria del elemento.
     * @GeneratedValue -> Nos permite generar un id de la primary key de forma automatica.
     * @Column -> Nos permite modificar la propiedad de un campo, por ejemplo que no sea nulo,
     * que tenga valor único o como se llamará en la BD.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paciente_id")
    private Long pacienteId;

    @NotBlank(message = "El rut no puede estar vacío.")
    @Column(unique = true, nullable = false)
    @Pattern(regexp = "\\d{1,8}-[\\dKk]", message = "El formato tiene que ser 12345678-9")
    private String rut;

    @NotBlank(message = "El campo nombres no puede estar vacío.")
    @Column(nullable = false)
    private String nombres;

    @NotBlank(message = "El campo apellidos no puede estar vacío.")
    @Column(nullable = false)
    private String apellidos;

    @NotNull(message = "El campo de fecha nacimiento no puede ser vacio")
    @Column(nullable = false, name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Email
    @NotBlank(message = "El campo Correo Electronico no puede estar vacío.")
    @Column(nullable = false, unique = true)
    private String correo;

    @Embedded
    Audit audit = new Audit();

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Atencion> atenciones = new ArrayList<>();


}
