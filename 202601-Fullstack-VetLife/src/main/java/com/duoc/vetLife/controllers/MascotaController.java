package com.duoc.vetLife.controllers;

import com.duoc.vetLife.exceptions.MascotaException;
import com.duoc.vetLife.models.Mascota;
import com.duoc.vetLife.models.MascotaDTO;
import com.duoc.vetLife.services.MascotaService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/mascotas")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    @GetMapping
    public ResponseEntity<List<Mascota>> getAllMascotas() {
        return ResponseEntity.ok(mascotaService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Mascota> getMascotaById(@PathVariable Long id) {
        Mascota mascota = mascotaService.getById(id);
        if (mascota == null) throw new MascotaException("Mascota no encontrada con ID: " + id);
        return ResponseEntity.ok(mascota);
    }

    @PostMapping
    public ResponseEntity<Mascota> saveMascota(@Valid @RequestBody Mascota mascota) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mascotaService.savePet(mascota));

    }

    @PutMapping("{id}")
    public Mascota updateMascota(@PathVariable Long id,@Valid @RequestBody Mascota mascota) {
        mascota.setId(id);
        return mascotaService.updatePet(mascota);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarMascota(@PathVariable Long id) {
        return ResponseEntity.ok(mascotaService.deletePet(id));
    }   

    // Busca por nombre de mascota
    @GetMapping("petName/{petName}")
    public ResponseEntity<List<MascotaDTO>> getByPetName(@PathVariable String petName) {
        return ResponseEntity.status(HttpStatus.OK).body(
                this.mascotaService.getByPetName(petName)
        );
    }

    // Busca por nombre de dueño
    @GetMapping("ownerName/{ownerName}")
    public ResponseEntity<List<MascotaDTO>> getByOwnerName(@PathVariable String ownerName) {
        return ResponseEntity.status(HttpStatus.OK).body(
                this.mascotaService.getByOwnerName(ownerName)
        );
    }

}

