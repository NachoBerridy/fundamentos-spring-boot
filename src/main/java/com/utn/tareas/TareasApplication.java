package com.utn.tareas;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.service.MensajeService;
import com.utn.tareas.service.TareaService;

/**
 * Clase principal de la aplicación de gestión de tareas
 * Implementa CommandLineRunner para ejecutar lógica al iniciar
 */
@SpringBootApplication
public class TareasApplication implements CommandLineRunner {

	@Value("${spring.profiles.active:default}")
	private String perfilActivo;
	
	private final TareaService tareaService;
	private final MensajeService mensajeService;
	
	/**
	 * Constructor con inyección de dependencias
	 * @param tareaService Servicio de gestión de tareas
	 * @param mensajeService Servicio de mensajes (según el perfil activo)
	 */
	public TareasApplication(TareaService tareaService, MensajeService mensajeService) {
		this.tareaService = tareaService;
		this.mensajeService = mensajeService;
	}

	public static void main(String[] args) {
		SpringApplication.run(TareasApplication.class, args);
	}

	/**
	 * Método que se ejecuta después de que Spring Boot inicia
	 * Implementa el flujo completo de demostración del sistema
	 */
	@Override
	public void run(String... args) throws Exception {
		// DEMOSTRACIÓN: Verificar que solo UN bean de MensajeService se crea
		System.out.println("\n╔════════════════════════════════════════════════════════╗");
		System.out.println("║  🔍 VERIFICACIÓN DE BEANS CONDICIONALES (@Profile)    ║");
		System.out.println("╚════════════════════════════════════════════════════════╝");
		System.out.println("🌍 Perfil activo: " + perfilActivo.toUpperCase());
		System.out.println("📦 Bean MensajeService inyectado: " + mensajeService.getClass().getSimpleName());
		System.out.println("✅ Solo este bean fue creado por Spring");
		System.out.println();
		
		// 1. Mostrar mensaje de bienvenida (usando MensajeService)
		mensajeService.mostrarBienvenida();
		
		System.out.println("\n╔════════════════════════════════════════╗");
		System.out.println("║  🚀 FLUJO DE DEMOSTRACIÓN DEL SISTEMA  ║");
		System.out.println("╚════════════════════════════════════════╝\n");
		
		// 2. Mostrar la configuración actual
		System.out.println("📋 PASO 1: MOSTRAR CONFIGURACIÓN ACTUAL");
		System.out.println("═══════════════════════════════════════════");
		System.out.println(tareaService.obtenerConfiguracion());
		
		// 3. Listar todas las tareas iniciales
		System.out.println("\n📋 PASO 2: LISTAR TODAS LAS TAREAS INICIALES");
		System.out.println("═══════════════════════════════════════════");
		tareaService.listarTodasLasTareas().forEach(System.out::println);
		
		// 4. Agregar una nueva tarea
		System.out.println("\n📋 PASO 3: AGREGAR UNA NUEVA TAREA");
		System.out.println("═══════════════════════════════════════════");
		var nuevaTarea = tareaService.agregarTarea(
			"Aprender Spring Boot Profiles", 
			Prioridad.ALTA
		);
		System.out.println("✅ Nueva tarea agregada: " + nuevaTarea);
		
		// 5. Listar tareas pendientes
		System.out.println("\n📋 PASO 4: LISTAR TAREAS PENDIENTES");
		System.out.println("═══════════════════════════════════════════");
		var tareasPendientes = tareaService.listarTareasPendientes();
		System.out.println("Total de tareas pendientes: " + tareasPendientes.size());
		tareasPendientes.forEach(System.out::println);
		
		// 6. Marcar una tarea como completada
		System.out.println("\n📋 PASO 5: MARCAR TAREA ID=3 COMO COMPLETADA");
		System.out.println("═══════════════════════════════════════════");
		boolean marcada = tareaService.marcarComoCompletada(3L);
		if (marcada) {
			System.out.println("✅ Tarea ID=3 marcada como completada exitosamente");
		} else {
			System.out.println("❌ No se pudo marcar la tarea (no encontrada)");
		}
		
		// 7. Mostrar estadísticas
		System.out.println("\n📋 PASO 6: MOSTRAR ESTADÍSTICAS");
		System.out.println("═══════════════════════════════════════════");
		if (tareaService.debeMostrarEstadisticas()) {
			System.out.println(tareaService.obtenerEstadisticas());
		} else {
			System.out.println("⚠️  Las estadísticas están deshabilitadas (perfil producción)");
			System.out.println("📊 Total: " + tareaService.listarTodasLasTareas().size() + 
			                   " | Completadas: " + tareaService.listarTareasCompletadas().size() +
			                   " | Pendientes: " + tareaService.listarTareasPendientes().size());
		}
		
		// 8. Listar tareas completadas
		System.out.println("\n📋 PASO 7: LISTAR TAREAS COMPLETADAS");
		System.out.println("═══════════════════════════════════════════");
		var tareasCompletadas = tareaService.listarTareasCompletadas();
		System.out.println("Total de tareas completadas: " + tareasCompletadas.size());
		tareasCompletadas.forEach(System.out::println);
		
		// Resumen final
		System.out.println("\n╔════════════════════════════════════════╗");
		System.out.println("║        📊 RESUMEN FINAL                ║");
		System.out.println("╚════════════════════════════════════════╝");
		System.out.println("� Total de tareas: " + tareaService.listarTodasLasTareas().size() + 
		                   " / " + tareaService.getMaxTareas() + " (máximo permitido)");
		System.out.println("✅ Completadas: " + tareasCompletadas.size());
		System.out.println("⏳ Pendientes: " + tareasPendientes.size());
		System.out.println("🌍 Perfil ejecutado: " + perfilActivo.toUpperCase());
		
		System.out.println("\n╔════════════════════════════════════════╗");
		System.out.println("║     ✅ FLUJO COMPLETADO CON ÉXITO      ║");
		System.out.println("╚════════════════════════════════════════╝\n");
		
		// 9. Mostrar mensaje de despedida
		mensajeService.mostrarDespedida();
	}
}
