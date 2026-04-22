package com.duoc.gourmetApp.repositories;

import com.duoc.gourmetApp.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    Optional<Reserva> findByNombreCliente(String nombreCliente);

    Optional<Reserva> findByRut(String rut);

}
