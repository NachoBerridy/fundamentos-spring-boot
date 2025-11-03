package com.utn.tareas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.model.Tarea;
import com.utn.tareas.repository.TareaRepository;

/**
 * Servicio que contiene la lógica de negocio para gestionar tareas
 */
@Service
public class TareaService {
    
    private final TareaRepository tareaRepository;
    
    /**
     * Constructor con inyección de dependencias
     * @param tareaRepository Repositorio de tareas
     */
    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }
    
    /**
     * Agrega una nueva tarea al sistema
     * 
     * @param descripcion Descripción de la tarea
     * @param prioridad Prioridad de la tarea
     * @return La tarea creada con su ID asignado
     */
    public Tarea agregarTarea(String descripcion, Prioridad prioridad) {
        Tarea nuevaTarea = new Tarea(descripcion, false, prioridad);
        return tareaRepository.guardar(nuevaTarea);
    }
    
    /**
     * Lista todas las tareas del sistema
     * 
     * @return Lista con todas las tareas
     */
    public List<Tarea> listarTodasLasTareas() {
        return tareaRepository.obtenerTodas();
    }
    
    /**
     * Lista solo las tareas pendientes (no completadas)
     * 
     * @return Lista de tareas pendientes
     */
    public List<Tarea> listarTareasPendientes() {
        return tareaRepository.obtenerTodas().stream()
                .filter(tarea -> !tarea.isCompletada())
                .collect(Collectors.toList());
    }
    
    /**
     * Lista solo las tareas completadas
     * 
     * @return Lista de tareas completadas
     */
    public List<Tarea> listarTareasCompletadas() {
        return tareaRepository.obtenerTodas().stream()
                .filter(Tarea::isCompletada)
                .collect(Collectors.toList());
    }
    
    /**
     * Marca una tarea como completada
     * 
     * @param id ID de la tarea a marcar como completada
     * @return true si se marcó correctamente, false si no se encontró la tarea
     */
    public boolean marcarComoCompletada(Long id) {
        return tareaRepository.buscarPorId(id)
                .map(tarea -> {
                    tarea.setCompletada(true);
                    tareaRepository.guardar(tarea);
                    return true;
                })
                .orElse(false);
    }
    
    /**
     * Obtiene estadísticas de las tareas
     * 
     * @return String formateado con estadísticas (total, completadas, pendientes)
     */
    public String obtenerEstadisticas() {
        List<Tarea> todasLasTareas = tareaRepository.obtenerTodas();
        
        long total = todasLasTareas.size();
        long completadas = todasLasTareas.stream()
                .filter(Tarea::isCompletada)
                .count();
        long pendientes = total - completadas;
        
        return String.format(
            "📊 ESTADÍSTICAS DE TAREAS\n" +
            "━━━━━━━━━━━━━━━━━━━━━━━━━━\n" +
            "Total de tareas:    %d\n" +
            "✅ Completadas:     %d (%.1f%%)\n" +
            "⏳ Pendientes:      %d (%.1f%%)\n" +
            "━━━━━━━━━━━━━━━━━━━━━━━━━━",
            total,
            completadas,
            total > 0 ? (completadas * 100.0 / total) : 0.0,
            pendientes,
            total > 0 ? (pendientes * 100.0 / total) : 0.0
        );
    }
    
    /**
     * Elimina una tarea por su ID
     * 
     * @param id ID de la tarea a eliminar
     * @return true si se eliminó correctamente, false si no se encontró
     */
    public boolean eliminarTarea(Long id) {
        return tareaRepository.eliminarPorId(id);
    }
    
    /**
     * Busca una tarea por su ID
     * 
     * @param id ID de la tarea a buscar
     * @return La tarea si existe, null si no se encuentra
     */
    public Tarea buscarTareaPorId(Long id) {
        return tareaRepository.buscarPorId(id).orElse(null);
    }
}
