package com.hospitalVM.atenciones.services;

import com.hospitalVM.atenciones.models.Paciente;
import com.hospitalVM.atenciones.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    // Se pone readOnly = true pues el metodo NO modifica datos
    @Transactional(readOnly = true)
    @Override
    public List<Paciente> findAll() {
        return this.findAll();
    }

    @Override
    public Paciente findById() {
        return null;
    }

    @Override
    public Paciente findByRut(String rut) {
        return null;
    }

    @Override
    public Paciente findByCorreo(String correo) {
        return null;
    }

    @Override
    public Paciente save(Paciente paciente) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Paciente updateById(Long id, Paciente paciente) {
        return null;
    }
}
