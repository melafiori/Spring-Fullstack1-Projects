package com.duoc.vetLife.repositories;

import com.duoc.vetLife.exceptions.MascotaException;
import com.duoc.vetLife.models.Mascota;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MascotaRepository {

    //Array que guarda todas las mascotas
    private List<Mascota> listaMascotas = new ArrayList<>();

    // Metodo que retorna todas los mascotas
    public List<Mascota> getAll() { return  this.listaMascotas; }

    // metodo que busca por id
    public Mascota getById(Long id) {
        for (Mascota mascota : listaMascotas) {
            if (mascota.getId() == id) {
                return mascota;
            }
        }
        return null;
    }

    // metodo que busca por nombre de mascota
    public List<Mascota> getByPetName(String petName) {
        List<Mascota> mascotas = new ArrayList<>();
        for (Mascota mascota : this.listaMascotas) {
            if(mascota.getNombreMascota().equals(petName)){
                mascotas.add(mascota);
            }
        }
        return mascotas;
    }

    // metodo que busca por nombre de dueño
    public List<Mascota> getByOwnerName(String ownerName) {
        List<Mascota> mascotas = new ArrayList<>();
        for (Mascota mascota : this.listaMascotas) {
            if(mascota.getNombreDuenio().equals(ownerName)){
                mascotas.add(mascota);
            }
        }
        return mascotas;
    }


    public Mascota save (Mascota newPet) {
        Mascota mascotaGetById = this.getById(newPet.getId());
        if (mascotaGetById == null) {
            this.listaMascotas.add(newPet);
            return newPet;
        }
        throw new MascotaException("La mascota con el ID " + newPet.getId() + " ya existe.");


    }

    public Mascota update(Mascota updatedPet) {
        int position = 0;
        boolean find = false;
        for(int i=0; i<this.listaMascotas.size(); i++) {
            if(this.listaMascotas.get(i).getId() == updatedPet.getId()) {
                position = i;
                find = true;
                break;
            }
        }

        if (find){
            this.listaMascotas.set(position, updatedPet);
            return updatedPet;
        }else{
            throw new RuntimeException("No se encontro la mascota con ID: " + updatedPet.getId());
        }

    }

    public void deleteById(Long id) {
        Mascota mascota = this.getById(id);
        this.listaMascotas.remove(mascota);
    }

    public MascotaRepository() {
        listaMascotas.add(new Mascota(1L, "Frugelé", "Gato", 4, "Cary", 5, "Bien"));
        listaMascotas.add(new Mascota(2L, "Cereza", "Gato", 10, "Cassie", 2.01, "Bien"));
        listaMascotas.add(new Mascota(3L, "Akira", "Perro", 10, "Andrea", 8, "Bien"));
        listaMascotas.add(new Mascota(4L, "Frugelé", "Perro", 1, "Manuel", 10, "Bien"));

    }


}

