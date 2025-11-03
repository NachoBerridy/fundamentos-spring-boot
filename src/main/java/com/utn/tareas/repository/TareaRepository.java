package com.utn.tareas.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.model.Tarea;

/**
 * Repositorio para gestionar las tareas en memoria
 */
@Repository
public class TareaRepository {
    
    private final List<Tarea> tareas;
    private final AtomicLong idGenerator;
    
    /**
     * Constructor que inicializa el repositorio con tareas de ejemplo
     */
    public TareaRepository() {
        this.tareas = new ArrayList<>();
        this.idGenerator = new AtomicLong(0);
        
        // Inicializar con tareas de ejemplo
        inicializarTareasDeEjemplo();
    }
    
    /**
     * Método privado para cargar tareas de ejemplo
     */
    private void inicializarTareasDeEjemplo() {
        guardar(new Tarea("Estudiar Spring Boot", false, Prioridad.ALTA));
        guardar(new Tarea("Hacer ejercicios de Java", false, Prioridad.MEDIA));
        guardar(new Tarea("Revisar documentación de Maven", false, Prioridad.BAJA));
        guardar(new Tarea("Completar proyecto final", false, Prioridad.ALTA));
        guardar(new Tarea("Preparar presentación", true, Prioridad.MEDIA));
    }
    
    /**
     * Guarda una tarea en el repositorio
     * Si la tarea no tiene ID, genera uno automáticamente
     * Si ya tiene ID, actualiza la tarea existente
     * 
     * @param tarea La tarea a guardar
     * @return La tarea guardada con su ID asignado
     */
    public Tarea guardar(Tarea tarea) {
        if (tarea.getId() == null) {
            // Nueva tarea: generar ID automático
            tarea.setId(idGenerator.incrementAndGet());
            tareas.add(tarea);
        } else {
            // Actualizar tarea existente
            eliminarPorId(tarea.getId());
            tareas.add(tarea);
        }
        return tarea;
    }
    
    /**
     * Obtiene todas las tareas del repositorio
     * 
     * @return Lista con todas las tareas
     */
    public List<Tarea> obtenerTodas() {
        return new ArrayList<>(tareas); // Retorna una copia para evitar modificaciones externas
    }
    
    /**
     * Busca una tarea por su ID
     * 
     * @param id El ID de la tarea a buscar
     * @return Optional con la tarea si existe, Optional vacío si no
     */
    public Optional<Tarea> buscarPorId(Long id) {
        return tareas.stream()
                .filter(tarea -> tarea.getId().equals(id))
                .findFirst();
    }
    
    /**
     * Elimina una tarea por su ID
     * 
     * @param id El ID de la tarea a eliminar
     * @return true si se eliminó correctamente, false si no se encontró la tarea
     */
    public boolean eliminarPorId(Long id) {
        return tareas.removeIf(tarea -> tarea.getId().equals(id));
    }
    
    /**
     * Obtiene la cantidad total de tareas
     * 
     * @return Número de tareas en el repositorio
     */
    public int contarTareas() {
        return tareas.size();
    }
}
