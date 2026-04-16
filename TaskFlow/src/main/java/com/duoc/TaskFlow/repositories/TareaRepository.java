package com.duoc.TaskFlow.repositories;

import com.duoc.TaskFlow.exceptions.TareaException;
import com.duoc.TaskFlow.models.Tarea;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TareaRepository {

    public TareaRepository() {
        taskList.add(new Tarea(1L, "Crear Tabla", 1, "WIP", "Mañana", LocalDateTime.now()));
        taskList.add(new Tarea(2L, "Eliminar Tabla", 2, "WIP", "Sig semana", LocalDateTime.now()));
        taskList.add(new Tarea(3L, "Nadar", 3, "Por hacer", "Prox año", LocalDateTime.now()));

    }

    private List<Tarea> taskList = new ArrayList<>();

    public List<Tarea> getAll(){
        return this.taskList;
    }

    public Tarea getById(Long id) {
        for (Tarea task : taskList){
            if(task.getId().equals(id)){
                return task;
            }
        }
        return null;
    }

    // NUEVO
    public List<Tarea> getByEstado(String estado) {
        List<Tarea> tareas = new ArrayList<>();
        for (Tarea task : taskList){
            if(task.getTaskState().equalsIgnoreCase(estado)){
                tareas.add(task);
            }
        }
        return tareas;
    }


    // NUEVO
    public Tarea update(Tarea tarea) {
        int pos = -1;
        int i = 0;
        for(Tarea tarea1 : this.taskList){
            if(tarea.getId().equals(tarea1.getId())){
                pos = i;
                break;
            }
            i++;
        }
        this.taskList.set(i, tarea);
        return tarea;

    }

    // SAVE Entregado
//    public Tarea save(Tarea newTask){
//        Tarea taskId = getById(newTask.getId());
//        for (Tarea task : taskList){
//            if(newTask.getId().equals(taskId)){
//                throw new TareaException("Tarea con ID" + task.getId() + "ya existe.");
//            }
//            this.taskList.add(newTask);
//        }
//        return newTask;
//    }

    // SAVE Nuevo
    public Tarea save(Tarea tarea) {
        tarea.setId(this.taskList.size() + 1L);
        tarea.setFecha(LocalDateTime.now());
        this.taskList.add(tarea);
        return tarea;
    }

    // public Tarea update(Tarea updatedTask){ }

    public void delete(Long id){
        Tarea taskID = getById(id);
        this.taskList.remove(taskID);
    }
}
