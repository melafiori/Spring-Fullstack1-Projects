package com.hospitalVM.atenciones.controllers;

import com.hospitalVM.atenciones.models.Medico;
import com.hospitalVM.atenciones.repositories.MedicoRepository;
import com.hospitalVM.atenciones.services.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medicos")
@Validated
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public ResponseEntity<List<Medico>> getMedicos() {
        return ResponseEntity.status(HttpStatus.OK).body(medicoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> getById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(medicoService.findById(id));
    }

    @GetMapping("/run/{run}")
    public ResponseEntity<Medico> getByRun(@PathVariable String run) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(medicoService.findByRun(run));
    }

    @PostMapping
    public ResponseEntity<Medico> save(@Valid @RequestBody Medico medico) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(medicoService.save(medico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        medicoService.deleteById(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                // SI REtORNA VOID, SE PONE .build(); EN VEZ DE .body();
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medico> update(@PathVariable Long id, @RequestBody Medico medico) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(medicoService.updateById(id, medico));
    }
}
