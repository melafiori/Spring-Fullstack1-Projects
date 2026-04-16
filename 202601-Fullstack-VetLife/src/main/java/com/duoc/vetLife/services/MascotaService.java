package com.duoc.vetLife.services;

import com.duoc.vetLife.models.Mascota;
import com.duoc.vetLife.models.MascotaDTO;
import com.duoc.vetLife.repositories.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MascotaService {
    @Autowired
    private MascotaRepository mascotaRepository;

    public List<Mascota> getAll() {
        return mascotaRepository.getAll();
    }

    public Mascota getById(Long id) {
        return mascotaRepository.getById(id);
    }

    public Mascota savePet(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    public Mascota updatePet(Mascota mascota) {
        return mascotaRepository.update(mascota);
    }

    public String deletePet(Long id) {
        mascotaRepository.deleteById(id);
        return "Mascota eliminada";
    }

    public List<MascotaDTO> getByPetName(String petName) {
        List<MascotaDTO> response = new ArrayList<>();
        List<Mascota> mascotas = this.mascotaRepository.getByPetName(petName);

        for (Mascota mascota : mascotas){
            MascotaDTO mascotaDTO = new MascotaDTO(mascota.getNombreMascota(),
                    mascota.getEspecieMascota(), mascota.getNombreDuenio(), mascota.getEstadoMascota());

            response.add(mascotaDTO);
        }

        return response;
    }

    public List<MascotaDTO> getByOwnerName(String ownerName) {
        List<MascotaDTO> response = new ArrayList<>();
        List<Mascota> mascotas = this.mascotaRepository.getByOwnerName(ownerName);

        for (Mascota mascota : mascotas){
            MascotaDTO mascotaDTO = new MascotaDTO(mascota.getNombreDuenio(),
                    mascota.getEspecieMascota(), mascota.getNombreDuenio(), mascota.getEstadoMascota());

            response.add(mascotaDTO);
        }
        return response;
    }


}
