package com.utn.tareas.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Implementación del servicio de mensajes para entorno de PRODUCCIÓN
 * Proporciona mensajes simples y concisos
 */
@Service
@Profile("prod")
public class MensajeProdService implements MensajeService {
    
    private static final Logger logger = LoggerFactory.getLogger(MensajeProdService.class);
    
    @Override
    public void mostrarBienvenida() {
        logger.info("Sistema iniciado en modo producción");
        
        System.out.println("\n" +
            "═══════════════════════════════════════\n" +
            "  Sistema de Gestión de Tareas UTN\n" +
            "  Versión 1.0 - Producción\n" +
            "  Estado: Operativo\n" +
            "═══════════════════════════════════════\n");
    }
    
    @Override
    public void mostrarDespedida() {
        logger.info("Sistema finalizado correctamente");
        
        System.out.println("\n" +
            "═══════════════════════════════════════\n" +
            "  Sesión finalizada\n" +
            "  Gracias por usar el sistema\n" +
            "═══════════════════════════════════════\n");
    }
}
