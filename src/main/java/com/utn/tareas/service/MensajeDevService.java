package com.utn.tareas.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Implementación del servicio de mensajes para entorno de DESARROLLO
 * Proporciona mensajes detallados y amigables para debugging
 */
@Service
@Profile("dev")
public class MensajeDevService implements MensajeService {
    
    private static final Logger logger = LoggerFactory.getLogger(MensajeDevService.class);
    
    @Override
    public void mostrarBienvenida() {
        logger.info("MensajeDevService activado - Perfil de Desarrollo");
        
        System.out.println("\n" +
            "╔═══════════════════════════════════════════════════════════════╗\n" +
            "║                                                               ║\n" +
            "║        🎉 ¡BIENVENIDO AL SISTEMA DE TAREAS UTN! 🎉           ║\n" +
            "║                                                               ║\n" +
            "║  👨‍💻 MODO DESARROLLO ACTIVO                                   ║\n" +
            "║                                                               ║\n" +
            "║  ✨ Características de desarrollo habilitadas:               ║\n" +
            "║     • Logs detallados (nivel DEBUG)                          ║\n" +
            "║     • Estadísticas visibles                                  ║\n" +
            "║     • Límite: 10 tareas                                      ║\n" +
            "║     • Hot reload activado con DevTools                       ║\n" +
            "║                                                               ║\n" +
            "║  📚 Este entorno es ideal para:                              ║\n" +
            "║     - Probar nuevas funcionalidades                          ║\n" +
            "║     - Hacer debugging detallado                              ║\n" +
            "║     - Ver logs completos de operaciones                      ║\n" +
            "║                                                               ║\n" +
            "║  💡 TIP: Revisa los logs para entender el flujo             ║\n" +
            "║                                                               ║\n" +
            "╚═══════════════════════════════════════════════════════════════╝\n");
    }
    
    @Override
    public void mostrarDespedida() {
        logger.info("Finalizando sesión en modo desarrollo");
        
        System.out.println("\n" +
            "╔═══════════════════════════════════════════════════════════════╗\n" +
            "║                                                               ║\n" +
            "║              👋 ¡HASTA LUEGO, DESARROLLADOR! 👋              ║\n" +
            "║                                                               ║\n" +
            "║  📊 Sesión de desarrollo finalizada                          ║\n" +
            "║                                                               ║\n" +
            "║  ✅ Recuerda:                                                ║\n" +
            "║     • Revisar los logs para detectar problemas               ║\n" +
            "║     • Hacer commit de tus cambios                            ║\n" +
            "║     • Ejecutar tests antes de subir a producción             ║\n" +
            "║                                                               ║\n" +
            "║  🚀 ¡Sigue programando con pasión!                           ║\n" +
            "║                                                               ║\n" +
            "╚═══════════════════════════════════════════════════════════════╝\n");
        
        logger.debug("Todos los recursos de desarrollo liberados correctamente");
    }
}
