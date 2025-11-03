# 📋 Sistema de Gestión de Tareas - Spring Boot Fundamentals

> **Proyecto educativo** para demostrar los fundamentos de Spring Boot, incluyendo inyección de dependencias, configuración con properties, Spring Profiles y beans condicionales.

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.7-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.8+-blue.svg)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

---

## 👨‍🎓 Información del Estudiante

- **Nombre:** Ignacio Berridy
- **Legajo:** 50714
- **Institución:** Universidad Tecnológica Nacional (UTN)
- **Materia:** Desarrollo de Aplicaciones con Spring Boot

---

## 📝 Descripción del Proyecto

Este proyecto es una **aplicación de consola** desarrollada con **Spring Boot** que implementa un sistema básico de gestión de tareas. El objetivo principal es demostrar los conceptos fundamentales del framework:

### ✨ Características Principales

- ✅ **Gestión de tareas** con operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
- 🏗️ **Arquitectura en capas**: Model, Repository, Service
- 💉 **Inyección de dependencias** mediante constructor injection
- ⚙️ **Configuración externalizada** con `application.properties`
- 🌍 **Spring Profiles**: Configuración diferenciada para entornos (dev/prod)
- 🎯 **Beans condicionales** con `@Profile` annotation
- 📊 **Logging** configurado con SLF4J
- 🔄 **CommandLineRunner** para ejecución automática al iniciar

### 🎯 Conceptos Aplicados

1. **Inversión de Control (IoC)** y **Contenedor de Spring**
2. **Dependency Injection** por constructor
3. **Anotaciones Spring**: `@SpringBootApplication`, `@Service`, `@Repository`, `@Component`
4. **Configuración con `@Value`** para propiedades externas
5. **Spring Profiles** para múltiples entornos
6. **Beans condicionales** con `@Profile`
7. **Uso de Optional<T>** para manejo seguro de valores
8. **Stream API** de Java para procesamiento funcional

---

## 🛠️ Tecnologías Utilizadas

| Tecnología | Versión | Propósito |
|------------|---------|-----------|
| **Java** | 17 | Lenguaje de programación |
| **Spring Boot** | 3.5.7 | Framework principal |
| **Maven** | 3.8+ | Gestión de dependencias y construcción |
| **Lombok** | Latest | Reducción de código boilerplate |
| **SLF4J** | Latest | Logging y trazabilidad |
| **Spring Boot DevTools** | Latest | Desarrollo ágil con hot reload |

### 📦 Dependencias Principales

```xml
<dependencies>
    <!-- Spring Boot Starter -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter</artifactId>
    </dependency>
    
    <!-- Lombok para reducir código -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    
    <!-- DevTools para desarrollo -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
        <optional>true</optional>
    </dependency>
    
    <!-- Testing -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

---

## 🚀 Instrucciones de Instalación y Ejecución

### 📋 Prerrequisitos

Antes de comenzar, asegúrate de tener instalado:

- ☕ **Java 17** o superior ([Download](https://www.oracle.com/java/technologies/downloads/))
- 📦 **Maven 3.8+** (opcional, el proyecto incluye Maven Wrapper)
- 💻 **Git** para clonar el repositorio
- 🔧 **IDE recomendado**: IntelliJ IDEA, Eclipse, o VS Code con extensiones Java

### 📥 1. Clonar el Repositorio

```bash
# Clonar el repositorio
git clone https://github.com/NachoBerridy/fundamentos-spring-boot.git

# Navegar al directorio del proyecto
cd fundamentos-spring-boot
```

### 🔧 2. Compilar el Proyecto

#### Opción A: Usando Maven Wrapper (recomendado)

**Windows (PowerShell/CMD):**
```powershell
.\mvnw.cmd clean compile
```

**Linux/Mac:**
```bash
./mvnw clean compile
```

#### Opción B: Usando Maven instalado localmente

```bash
mvn clean compile
```

### ▶️ 3. Ejecutar la Aplicación

#### Opción A: Con Maven Wrapper

**Windows:**
```powershell
.\mvnw.cmd spring-boot:run
```

**Linux/Mac:**
```bash
./mvnw spring-boot:run
```

#### Opción B: Ejecutar el JAR compilado

```bash
# Compilar y empaquetar
.\mvnw.cmd clean package

# Ejecutar el JAR
java -jar target/tareas-0.0.1-SNAPSHOT.jar
```

---

## 🌍 Cambiar entre Profiles (Entornos)

La aplicación soporta **dos perfiles de ejecución**: `dev` (desarrollo) y `prod` (producción). Cada perfil tiene configuraciones específicas.

### 📋 Configuraciones por Profile

| Configuración | Profile DEV | Profile PROD |
|---------------|-------------|--------------|
| **Max tareas** | 10 | 1000 |
| **Logging level** | DEBUG | ERROR |
| **Mostrar estadísticas** | ✅ Sí | ❌ No |
| **Mensajes** | Detallados con emojis | Concisos y profesionales |

### 🔄 Métodos para Cambiar de Profile

#### Método 1: Modificar `application.properties` (Permanente)

Edita el archivo `src/main/resources/application.properties`:

```properties
# Cambiar a DEV
spring.profiles.active=dev

# O cambiar a PROD
spring.profiles.active=prod
```

#### Método 2: Variable de Entorno (Temporal)

**Windows PowerShell:**
```powershell
$env:SPRING_PROFILES_ACTIVE="dev"
.\mvnw.cmd spring-boot:run
```

**Linux/Mac:**
```bash
export SPRING_PROFILES_ACTIVE=dev
./mvnw spring-boot:run
```

#### Método 3: Argumento de Línea de Comandos (Temporal)

```bash
# Ejecutar con profile dev
.\mvnw.cmd spring-boot:run -Dspring-boot.run.profiles=dev

# Ejecutar con profile prod
.\mvnw.cmd spring-boot:run -Dspring-boot.run.profiles=prod

# Con JAR compilado
java -jar -Dspring.profiles.active=dev target/tareas-0.0.1-SNAPSHOT.jar
```

#### Método 4: Argumento del Programa (Temporal)

```bash
java -jar target/tareas-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod
```

---

## 📸 Capturas de Pantalla

### 🛠️ Profile: DEVELOPMENT (dev)

El perfil de desarrollo muestra **mensajes detallados** con emojis, logging en nivel DEBUG, y estadísticas completas.

#### Inicio y Configuración
![Dev - Inicio](capturas/Dev/Captura%20de%20pantalla%202025-11-02%20224727.png)
*Mensaje de bienvenida con tips de desarrollo y configuración del sistema*

#### Flujo de Demostración
![Dev - Flujo Principal](capturas/Dev/Captura%20de%20pantalla%202025-11-02%20224827.png)
*Ejecución del flujo completo: listar tareas, agregar nueva, marcar completada*

#### Estadísticas Detalladas
![Dev - Estadísticas](capturas/Dev/Captura%20de%20pantalla%202025-11-02%20224858.png)
*Estadísticas completas con porcentajes y distribución por prioridad*

#### Resumen y Despedida
![Dev - Resumen](capturas/Dev/Captura%20de%20pantalla%202025-11-02%20224946.png)
*Resumen final con mensaje de despedida motivacional*

---

### 🏭 Profile: PRODUCTION (prod)

El perfil de producción utiliza **mensajes concisos**, logging en nivel ERROR, y estadísticas deshabilitadas.

#### Inicio Profesional
![Prod - Inicio](capturas/Prod/Captura%20de%20pantalla%202025-11-02%20225332.png)
*Mensaje de bienvenida simple y profesional, configuración optimizada*

#### Ejecución Eficiente
![Prod - Ejecución](capturas/Prod/Captura%20de%20pantalla%202025-11-02%20225411.png)
*Flujo de operaciones sin información de debug, solo lo esencial*

#### Finalización Limpia
![Prod - Finalización](capturas/Prod/Captura%20de%20pantalla%202025-11-02%20225441.png)
*Resumen básico y despedida profesional*

---

## 🏗️ Arquitectura del Proyecto

```
📦 com.utn.tareas
 ┣ 📂 model                    # Capa de modelo (entidades)
 ┃ ┣ 📜 Tarea.java            # Entidad principal: representa una tarea
 ┃ ┗ 📜 Prioridad.java        # Enum: ALTA, MEDIA, BAJA
 ┃
 ┣ 📂 repository               # Capa de acceso a datos
 ┃ ┗ 📜 TareaRepository.java  # Almacenamiento en memoria con 5 tareas iniciales
 ┃
 ┣ 📂 service                  # Capa de lógica de negocio
 ┃ ┣ 📜 TareaService.java     # Servicio principal de gestión de tareas
 ┃ ┣ 📜 MensajeService.java   # Interfaz para mensajes condicionales
 ┃ ┣ 📜 MensajeDevService.java    # Implementación para entorno DEV
 ┃ ┗ 📜 MensajeProdService.java   # Implementación para entorno PROD
 ┃
 ┗ 📜 TareasApplication.java  # Clase principal (implements CommandLineRunner)
```

### 🔄 Flujo de Ejecución

1. **Spring Boot inicia** → Carga el contexto y crea los beans
2. **@Profile activo** → Solo instancia el bean correspondiente (MensajeDevService o MensajeProdService)
3. **Constructor injection** → Inyecta TareaService y MensajeService
4. **run() se ejecuta** → Flujo de 9 pasos:
   - Mostrar bienvenida
   - Mostrar configuración
   - Listar tareas iniciales
   - Agregar nueva tarea
   - Listar pendientes
   - Marcar completada
   - Mostrar estadísticas
   - Listar completadas
   - Mostrar despedida

---

## 📚 Archivos de Configuración

### `application.properties` (Configuración Base)
```properties
spring.application.name=tareas
spring.profiles.active=dev
app.nombre=Sistema de Gestión de Tareas UTN
```

### `application-dev.properties` (Desarrollo)
```properties
app.tareas.max-tareas=10
app.tareas.mostrar-estadisticas=true
logging.level.com.utn.tareas=DEBUG
```

### `application-prod.properties` (Producción)
```properties
app.tareas.max-tareas=1000
app.tareas.mostrar-estadisticas=false
logging.level.root=ERROR
```

---

## 🧪 Ejecutar Tests

```bash
# Ejecutar todos los tests
.\mvnw.cmd test

# Ejecutar tests con reporte detallado
.\mvnw.cmd test -X
```

---

## 📖 Conceptos Clave Implementados

### 1. **Inyección de Dependencias por Constructor**
```java
private final TareaService tareaService;
private final MensajeService mensajeService;

public TareasApplication(TareaService tareaService, MensajeService mensajeService) {
    this.tareaService = tareaService;
    this.mensajeService = mensajeService;
}
```

### 2. **Configuración con @Value**
```java
@Value("${app.tareas.max-tareas}")
private int maxTareas;

@Value("${app.nombre}")
private String nombreApp;
```

### 3. **Beans Condicionales con @Profile**
```java
@Service
@Profile("dev")
public class MensajeDevService implements MensajeService { }

@Service
@Profile("prod")
public class MensajeProdService implements MensajeService { }
```

### 4. **CommandLineRunner**
```java
@SpringBootApplication
public class TareasApplication implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        // Lógica que se ejecuta al iniciar
    }
}
```

---

## 💡 Conclusiones Personales

### 🎓 Aprendizajes Adquiridos

Durante el desarrollo de este proyecto, he logrado **comprender y aplicar** los fundamentos esenciales de Spring Boot:

1. **Inversión de Control (IoC)**: Entendí cómo Spring gestiona el ciclo de vida de los objetos (beans) y cómo el contenedor se encarga de crear, configurar y destruir instancias según las necesidades de la aplicación.

2. **Inyección de Dependencias**: Aprendí la importancia de la **inyección por constructor** como mejor práctica, ya que garantiza inmutabilidad, facilita el testing y hace explícitas las dependencias de una clase.

3. **Configuración Externalizada**: La separación de la configuración del código mediante `application.properties` permite **adaptabilidad sin recompilar**, lo cual es crucial en entornos empresariales donde la misma aplicación debe ejecutarse en múltiples ambientes.

4. **Spring Profiles**: Este concepto es **fundamental en el desarrollo profesional**. Poder tener configuraciones específicas por entorno (desarrollo, testing, producción) sin duplicar código es una ventaja enorme que simplifica el despliegue y mantenimiento.

5. **Beans Condicionales**: El uso de `@Profile` para crear beans específicos según el entorno activo demuestra el poder de Spring para **adaptar el comportamiento** de la aplicación de forma declarativa y limpia.

### 🚀 Aplicaciones Prácticas

Este conocimiento me permitirá:

- ✅ Desarrollar aplicaciones **escalables y mantenibles**
- ✅ Implementar **arquitecturas limpias** con separación de responsabilidades
- ✅ Configurar aplicaciones para **múltiples entornos** sin cambios de código
- ✅ Aplicar **mejores prácticas** de desarrollo con Spring Boot
- ✅ Preparar el camino hacia **microservicios** y aplicaciones REST

### 🔮 Próximos Pasos

Con estos fundamentos claros, los siguientes pasos naturales serían:

1. **Spring Data JPA** para persistencia en base de datos real
2. **Spring Web** para crear APIs REST
3. **Spring Security** para autenticación y autorización
4. **Spring Cloud** para arquitecturas de microservicios
5. **Testing avanzado** con Mockito y TestContainers

### 💬 Reflexión Final

Spring Boot elimina gran parte de la configuración repetitiva del desarrollo Java tradicional, permitiendo enfocarse en la **lógica de negocio** en lugar de en configuraciones XML interminables. Su filosofía de "convention over configuration" y el amplio ecosistema Spring lo convierten en una herramienta **indispensable** para cualquier desarrollador Java moderno.

Este proyecto me ha dado una **base sólida** para continuar explorando el ecosistema Spring y aplicar estos conceptos en proyectos más complejos.

---

## 📞 Contacto

**Ignacio Berridy**  
Legajo: 50714  
Universidad Tecnológica Nacional (UTN)

---

## 📄 Licencia

Este proyecto es de uso educativo para la UTN.

---

## 🙏 Agradecimientos

- A la **Universidad Tecnológica Nacional** por la formación académica
- A la comunidad de **Spring Boot** por la excelente documentación
- A **Pivotal/VMware** por el desarrollo y mantenimiento de Spring Framework

---

<div align="center">

**⭐ Si este proyecto te fue útil, no olvides darle una estrella ⭐**

Desarrollado con ❤️ usando Spring Boot

</div>
