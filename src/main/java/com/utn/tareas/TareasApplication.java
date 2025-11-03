package com.utn.tareas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.model.Tarea;
import com.utn.tareas.repository.TareaRepository;

@SpringBootApplication
public class TareasApplication {

	public static void main(String[] args) {
		SpringApplication.run(TareasApplication.class, args);
	}

	/**
	 * Bean para probar el repositorio al iniciar la aplicación
	 */
	@Bean
	public CommandLineRunner demo(TareaRepository repository) {
		return (args) -> {
			System.out.println("\n========================================");
			System.out.println("🚀 PRUEBA DEL REPOSITORIO DE TAREAS");
			System.out.println("========================================\n");
			
			// Mostrar todas las tareas iniciales
			System.out.println("📋 Tareas iniciales (" + repository.contarTareas() + " tareas):");
			repository.obtenerTodas().forEach(System.out::println);
			
			// Guardar una nueva tarea
			System.out.println("\n➕ Guardando nueva tarea...");
			Tarea nuevaTarea = new Tarea("Aprender Spring Data JPA", false, Prioridad.ALTA);
			repository.guardar(nuevaTarea);
			System.out.println("✅ Tarea guardada: " + nuevaTarea);
			
			// Buscar por ID
			System.out.println("\n🔍 Buscando tarea con ID 3...");
			repository.buscarPorId(3L).ifPresentOrElse(
				tarea -> System.out.println("✅ Encontrada: " + tarea),
				() -> System.out.println("❌ No encontrada")
			);
			
			// Eliminar una tarea
			System.out.println("\n🗑️ Eliminando tarea con ID 2...");
			boolean eliminada = repository.eliminarPorId(2L);
			System.out.println(eliminada ? "✅ Tarea eliminada" : "❌ Tarea no encontrada");
			
			// Mostrar todas las tareas finales
			System.out.println("\n📋 Tareas finales (" + repository.contarTareas() + " tareas):");
			repository.obtenerTodas().forEach(System.out::println);
			
			System.out.println("\n========================================");
			System.out.println("✅ PRUEBA COMPLETADA");
			System.out.println("========================================\n");
		};
	}
}
