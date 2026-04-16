package com.duoc.TaskFlow.controllers;

import com.duoc.TaskFlow.models.Tarea;
import com.duoc.TaskFlow.services.TareaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.support.ResourceTransactionManager;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@Validated
public class TareaController {
    @Autowired
    private TareaService tareaService;


    // NUEVO

    @GetMapping
    public ResponseEntity<List<Tarea>> getAllTareas() {
        return ResponseEntity.status(HttpStatus.OK).body(tareaService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarea> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(tareaService.getById(id));
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Tarea>> getByEstado(@PathVariable String estado) {
        return ResponseEntity.status(HttpStatus.OK).body(tareaService.getByStatus(estado));
    }

    @PostMapping
    public ResponseEntity<Tarea> create(@Valid @RequestBody Tarea tarea) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tareaService.save(tarea));
    }

    @PutMapping
    public ResponseEntity<Tarea> update(@Valid @RequestBody Tarea tarea) {
        return ResponseEntity.status(HttpStatus.OK).body(tareaService.update(tarea));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.tareaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }




//  ANTIGUO
//    @GetMapping
//    public ResponseEntity<List<Tarea>> getAll(){
//
//        return ResponseEntity.ok(tareaService.getAll());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Tarea> getById(@PathVariable @Valid Long id){
//
//        return ResponseEntity.ok(tareaService.getById(id));
//    }
//
//    @PostMapping
//    public ResponseEntity<Tarea> save(@RequestBody Tarea task){
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(tareaService.save(task));
//    }
//
////    @PutMapping("/{id}")
////    public ResponseEntity<Tarea> update(@PathVariable @Valid Long id){
////
////        return ResponseEntity.status(HttpStatus.OK).body(tareaService.update(id));
////    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> delete(@PathVariable Long id){
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(tareaService.delete(id));
//    }

}
