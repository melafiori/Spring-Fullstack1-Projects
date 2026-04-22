package com.duoc.gourmetApp.services;

import com.duoc.gourmetApp.models.Reserva;

import java.util.List;

public interface ReservaService {

    List<Reserva> findAll();

    Reserva findByRut(String rut);

    Reserva findById(Long id);

    Reserva findByNombreCliente(String nombreCliente);

    Reserva save(Reserva reserva);

    void deleteById(Long id);

    Reserva updateById(Long id, Reserva reserva);
}
