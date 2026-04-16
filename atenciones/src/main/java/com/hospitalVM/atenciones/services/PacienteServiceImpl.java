package com.hospitalVM.atenciones.services;

import com.hospitalVM.atenciones.exceptions.PacienteException;
import com.hospitalVM.atenciones.models.Paciente;
import com.hospitalVM.atenciones.repositories.PacienteRepository;
import jakarta.transaction.TransactionScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Paciente> findAll() {
        return this.pacienteRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Paciente findById(Long id) {
        return this.pacienteRepository.findById(id).orElseThrow(
                () -> new PacienteException("Paciente con id " + id + " no encontrado")
        );
    }

    @Transactional
    @Override
    public Paciente save(Paciente paciente) {
        if (this.pacienteRepository.findByRut(paciente.getRut()).isPresent()) {
            throw new PacienteException("Paciente con el rut:" + paciente.getRut() + "ya existe");
        }
        if (this.pacienteRepository.findByCorreo(paciente.getCorreo()).isPresent()) {
            throw new PacienteException("Paciente con el correo:" + paciente.getCorreo() + "ya existe");
        }
        Paciente newPaciente = new Paciente();
        newPaciente.setRut(paciente.getRut());
        newPaciente.setCorreo(paciente.getCorreo());
        newPaciente.setNombres(paciente.getNombres());
        newPaciente.setApellidos(paciente.getApellidos());
        newPaciente.setFechaNacimiento(paciente.getFechaNacimiento());

        return this.pacienteRepository.save(newPaciente);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        this.pacienteRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Paciente updateById(Long id, Paciente paciente) {
        return this.pacienteRepository.findById(id).map(p -> {
            p.setCorreo(paciente.getCorreo());
            p.setNombres(paciente.getNombres());
            p.setApellidos(paciente.getApellidos());
            p.setFechaNacimiento(paciente.getFechaNacimiento());
            return this.pacienteRepository.save(p);
        }).orElseThrow(
                () -> new PacienteException("Paciente con id " + id + " no encontrado")
        );
    }

    @Transactional(readOnly = true)
    @Override
    public Paciente findByCorreo(String correo) {
        return this.pacienteRepository.findByCorreo(correo).orElseThrow(
                () -> new PacienteException("Paciente con correo" + correo + " no encontrado")
        );
    }

    @Transactional(readOnly = true)
    @Override
    public Paciente findByRut(String rut) {
        return this.pacienteRepository.findByRut(rut).orElseThrow(
                () -> new PacienteException("Paciente con rut" + rut + " no encontrado")
        );
    }
}