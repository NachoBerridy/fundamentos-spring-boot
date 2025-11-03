# 🔧 Configuración de Perfiles (Profiles)

Este proyecto utiliza **Spring Profiles** para gestionar diferentes configuraciones según el entorno.

## 📋 Perfiles Disponibles

### 1️⃣ **DEV (Desarrollo)**
- **Máximo de tareas**: 10
- **Mostrar estadísticas**: ✅ Sí
- **Nivel de logging**: DEBUG (detallado)
- **Uso**: Para desarrollo local y pruebas

### 2️⃣ **PROD (Producción)**
- **Máximo de tareas**: 1000
- **Mostrar estadísticas**: ❌ No
- **Nivel de logging**: ERROR (solo errores críticos)
- **Uso**: Para entorno de producción

## 🚀 Cómo Cambiar de Perfil

### Opción 1: Modificar `application.properties`
Edita el archivo `src/main/resources/application.properties`:

```properties
# Cambiar a DEV
spring.profiles.active=dev

# Cambiar a PROD
spring.profiles.active=prod
```

### Opción 2: Variable de Entorno
```bash
# Windows (PowerShell)
$env:SPRING_PROFILES_ACTIVE="prod"
.\mvnw.cmd spring-boot:run

# Linux/Mac
export SPRING_PROFILES_ACTIVE=prod
./mvnw spring-boot:run
```

### Opción 3: Parámetro de ejecución
```bash
.\mvnw.cmd spring-boot:run -Dspring-boot.run.profiles=prod
```

## 📊 Diferencias Observables

### Con perfil **DEV**:
```
🌍 Perfil activo: DEV
📊 Máximo de tareas: 10
📈 Mostrar estadísticas: Sí

# Logs detallados (DEBUG)
2025-11-02 22:31:28 - Intentando agregar nueva tarea...
2025-11-02 22:31:28 - Tarea agregada exitosamente con ID: 6
2025-11-02 22:31:28 - Detalles de la tarea: Tarea{...}
```

### Con perfil **PROD**:
```
🌍 Perfil activo: PROD
📊 Máximo de tareas: 1000
📈 Mostrar estadísticas: No

# Solo logs de errores (ERROR)
# (No se muestran logs DEBUG ni INFO)
⚠️ Las estadísticas están deshabilitadas en producción
```

## 📁 Archivos de Configuración

- `application.properties` - Configuración común
- `application-dev.properties` - Configuración específica para DEV
- `application-prod.properties` - Configuración específica para PROD

## ✨ Ventajas de usar Profiles

✅ Configuración específica por entorno  
✅ Fácil cambio entre entornos  
✅ Logging apropiado para cada caso  
✅ Límites configurables  
✅ Sin necesidad de recompilar
