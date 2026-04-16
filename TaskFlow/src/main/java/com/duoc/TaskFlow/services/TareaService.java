package com.duoc.TaskFlow.services;

import com.duoc.TaskFlow.exceptions.TareaException;
import com.duoc.TaskFlow.models.Tarea;
import com.duoc.TaskFlow.repositories.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {
    @Autowired
    private TareaRepository tareaRepository;

//    ANTIGUO
//    public List<Tarea> getAll(){ return tareaRepository.getAll(); }
//
//    public Tarea getById(Long id){ return tareaRepository.getById(id); }
//
//    // public Tarea update(Long id){ return tareaRepository.update(task); }
//
//    public Tarea save(Tarea task) { return tareaRepository.save(task); }
//
//    public String delete(Long id) {
//        this.tareaRepository.delete(id);
//        return "Tarea eliminada con exito";
//    }

    public Tarea getById(Long id) {
        Tarea tarea = this.tareaRepository.getById(id);
        if (tarea != null) {
            return tarea;
        }
        // No se ocupa else pues el RETURN automaticamente termina el metodo.
        throw new TareaException("La tarea con id " + id + " no existe");
    }

    public List<Tarea> getAll() {
        return this.tareaRepository.getAll();
    }

    public List<Tarea> getByStatus(String status) {
        return this.tareaRepository.getByEstado(status);
    }

    public Tarea update(Tarea tarea) {
        // Si existe la tarea pasada por parametro, se updatea la tarea, si no, la excepción.
        if (this.tareaRepository.getById(tarea.getId()) != null) {
            return this.tareaRepository.update(tarea);
        }else {
            throw new TareaException("La tarea con id " + tarea.getId() + " no existe");
        }
    }

    public Tarea save(Tarea tarea) {
        if (this.tareaRepository.getById(tarea.getId()) == null) {
            return this.tareaRepository.save(tarea);
        }
        throw new TareaException("La tarea con id " + tarea.getId() + " no existe");
    }

    public void delete(Long id) {
        this.tareaRepository.delete(id);
    }

}
