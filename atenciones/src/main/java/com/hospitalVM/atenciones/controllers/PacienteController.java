package com.hospitalVM.atenciones.controllers;

import com.hospitalVM.atenciones.models.Paciente;
import com.hospitalVM.atenciones.services.PacienteService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pacientes")
@Validated
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<Paciente>> findAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(pacienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> findById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(pacienteService.findById(id));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Paciente> findByMail(@PathVariable String email) {
        return ResponseEntity.
                status(HttpStatus.OK)
                .body(pacienteService.findByCorreo(email));
    }

    @GetMapping("/rut/{rut}")
    public ResponseEntity<Paciente> findByRut(@PathVariable String rut) {
        return ResponseEntity.
                status(HttpStatus.OK)
                .body(pacienteService.findByRut(rut));
    }

    @PostMapping
    public ResponseEntity<Paciente> save(@Valid @RequestBody Paciente paciente) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(pacienteService.save(paciente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> update(@PathVariable Long id, @Valid @RequestBody Paciente paciente) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(pacienteService.updateById(id, paciente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Paciente> delete(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}   