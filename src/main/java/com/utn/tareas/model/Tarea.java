package com.utn.tareas.model;

/**
 * Clase que representa una Tarea en el sistema
 */
public class Tarea {
    
    private Long id;
    private String descripcion;
    private boolean completada;
    private Prioridad prioridad;
    
    // Constructor vacío
    public Tarea() {
    }
    
    // Constructor completo
    public Tarea(Long id, String descripcion, boolean completada, Prioridad prioridad) {
        this.id = id;
        this.descripcion = descripcion;
        this.completada = completada;
        this.prioridad = prioridad;
    }
    
    // Constructor sin id (para crear nuevas tareas)
    public Tarea(String descripcion, boolean completada, Prioridad prioridad) {
        this.descripcion = descripcion;
        this.completada = completada;
        this.prioridad = prioridad;
    }
    
    // Getters
    public Long getId() {
        return id;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public boolean isCompletada() {
        return completada;
    }
    
    public Prioridad getPrioridad() {
        return prioridad;
    }
    
    // Setters
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void setCompletada(boolean completada) {
        this.completada = completada;
    }
    
    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }
    
    // toString
    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", completada=" + completada +
                ", prioridad=" + prioridad +
                '}';
    }
}
