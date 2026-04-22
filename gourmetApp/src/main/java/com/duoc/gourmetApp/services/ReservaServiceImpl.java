package com.duoc.gourmetApp.services;

import com.duoc.gourmetApp.exceptions.ReservaException;
import com.duoc.gourmetApp.models.Reserva;
import com.duoc.gourmetApp.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Reserva> findAll() {
        return this.reservaRepository.findAll();
    }

    @Override
    public Reserva findByRut(String rut) {
        return this.reservaRepository.findByRut(rut).orElseThrow(
                () -> new ReservaException("El cliente con rut " + rut + " no tiene reservas.")
        );
    }

    @Transactional(readOnly = true)
    @Override
    public Reserva findById(Long id) {
        return this.reservaRepository.findById(id).orElseThrow(
                () -> new ReservaException("Reserva con id " + id + " no encontrada.")
        );
    }

    @Transactional(readOnly = true)
    @Override
    public Reserva findByNombreCliente(String nombreCliente) {
        return this.reservaRepository.findByNombreCliente(nombreCliente).orElseThrow(
                () -> new ReservaException("Reserva con Nombre " + nombreCliente + " no encontrada.")
        );
    }

    @Override
    public Reserva save(Reserva reserva) {
        if(this.reservaRepository.findByRut(reserva.getRut()).isPresent()) {
            throw new ReservaException("Cliente con rut " + reserva.getRut() + " ya tiene una reserva.");
        }
        Reserva newReserva = new Reserva();
        newReserva.setNombreCliente(reserva.getNombreCliente());
        newReserva.setRut(reserva.getRut());
        newReserva.setFechaReserva(reserva.getFechaReserva());
        newReserva.setEstadoReserva(reserva.getEstadoReserva());

        return this.reservaRepository.save(newReserva);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        this.reservaRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Reserva updateById(Long id, Reserva reserva) {
        return this.reservaRepository.findById(id).map(r -> {
            r.setNombreCliente(reserva.getNombreCliente());
            r.setFechaReserva(reserva.getFechaReserva());
            r.setEstadoReserva(reserva.getEstadoReserva());
            r.setCantidadPersonas(reserva.getCantidadPersonas());
            return this.reservaRepository.save(r);
        }).orElseThrow(
                () -> new ReservaException("Reserva con id " + id + " no encontrada.")
        );
    }
}
