package com.utn.tareas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.service.TareaService;

@SpringBootApplication
public class TareasApplication {

	public static void main(String[] args) {
		SpringApplication.run(TareasApplication.class, args);
	}

	/**
	 * Bean para probar el servicio de tareas al iniciar la aplicación
	 */
	@Bean
	public CommandLineRunner demo(TareaService tareaService) {
		return (args) -> {
			System.out.println("\n╔════════════════════════════════════════╗");
			System.out.println("║  🚀 PRUEBA DEL SERVICIO DE TAREAS  🚀  ║");
			System.out.println("╚════════════════════════════════════════╝\n");
			
			// 0. Mostrar configuración de la aplicación
			System.out.println("0️⃣  CONFIGURACIÓN DE LA APLICACIÓN:");
			System.out.println("─────────────────────────────────────────");
			System.out.println(tareaService.obtenerConfiguracion());
			
			// 1. Listar todas las tareas iniciales
			System.out.println("\n1️⃣  LISTANDO TODAS LAS TAREAS:");
			System.out.println("─────────────────────────────────────────");
			tareaService.listarTodasLasTareas().forEach(System.out::println);
			
			// 2. Listar tareas pendientes
			System.out.println("\n2️⃣  TAREAS PENDIENTES:");
			System.out.println("─────────────────────────────────────────");
			tareaService.listarTareasPendientes().forEach(System.out::println);
			
			// 3. Listar tareas completadas
			System.out.println("\n3️⃣  TAREAS COMPLETADAS:");
			System.out.println("─────────────────────────────────────────");
			tareaService.listarTareasCompletadas().forEach(System.out::println);
			
			// 4. Agregar una nueva tarea
			System.out.println("\n4️⃣  AGREGANDO NUEVA TAREA:");
			System.out.println("─────────────────────────────────────────");
			var nuevaTarea = tareaService.agregarTarea(
				"Implementar API REST con Spring Boot", 
				Prioridad.ALTA
			);
			System.out.println("✅ Tarea creada: " + nuevaTarea);
			
			// 5. Marcar tarea como completada
			System.out.println("\n5️⃣  MARCANDO TAREA ID=1 COMO COMPLETADA:");
			System.out.println("─────────────────────────────────────────");
			boolean marcada = tareaService.marcarComoCompletada(1L);
			System.out.println(marcada ? 
				"✅ Tarea marcada como completada" : 
				"❌ Tarea no encontrada");
			
			// 6. Mostrar estadísticas (solo si está configurado)
			System.out.println("\n6️⃣  ESTADÍSTICAS DEL SISTEMA:");
			System.out.println("─────────────────────────────────────────");
			if (tareaService.debeMostrarEstadisticas()) {
				System.out.println(tareaService.obtenerEstadisticas());
			} else {
				System.out.println("⚠️ Las estadísticas están deshabilitadas en la configuración");
			}
			
			// 7. Probar validación de límite máximo
			System.out.println("\n7️⃣  PROBANDO VALIDACIÓN DE LÍMITE MÁXIMO:");
			System.out.println("─────────────────────────────────────────");
			System.out.println("📋 Tareas actuales: " + tareaService.listarTodasLasTareas().size() + 
			                   " / " + tareaService.getMaxTareas() + " (máximo permitido)");
			
			// Intentar agregar tareas hasta alcanzar el límite
			try {
				for (int i = 1; i <= 10; i++) {
					tareaService.agregarTarea("Tarea de prueba " + i, Prioridad.BAJA);
					System.out.println("✅ Tarea " + i + " agregada correctamente");
				}
			} catch (IllegalStateException e) {
				System.out.println(e.getMessage());
			}
			
			// 8. Estado final de todas las tareas
			System.out.println("\n8️⃣  ESTADO FINAL DE TODAS LAS TAREAS:");
			System.out.println("─────────────────────────────────────────");
			tareaService.listarTodasLasTareas().forEach(System.out::println);
			
			System.out.println("\n╔════════════════════════════════════════╗");
			System.out.println("║     ✅ PRUEBA COMPLETADA CON ÉXITO     ║");
			System.out.println("╚════════════════════════════════════════╝\n");
		};
	}
}
