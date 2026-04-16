package com.hospitalVM.atenciones.controllers;

import com.hospitalVM.atenciones.models.Atencion;
import com.hospitalVM.atenciones.repositories.AtencionRepository;
import com.hospitalVM.atenciones.services.AtencionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/atenciones")
public class AtencionController {
    @Autowired
    private AtencionService atencionService;

    @GetMapping
    public ResponseEntity<List<Atencion>> findAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(atencionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atencion> findById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(atencionService.findById(id));
    }
}
