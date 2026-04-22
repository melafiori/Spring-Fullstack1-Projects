package com.duoc.gourmetApp.controllers;


import com.duoc.gourmetApp.models.Reserva;
import com.duoc.gourmetApp.services.ReservaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reservas")
@Validated
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public ResponseEntity<List<Reserva>> findAll(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(reservaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> findById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(reservaService.findById(id));
    }

    @GetMapping("/rut/{rutCliente}")
    public ResponseEntity<Reserva> findByRutCliente(@PathVariable String rutCliente){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(reservaService.findByRut(rutCliente));
    }

    @PostMapping
    public ResponseEntity<Reserva> save(@Validated @RequestBody Reserva reserva){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(reservaService.save(reserva));
    }

    @DeleteMapping ResponseEntity<Reserva> delete(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
