# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/main/java/com/pragma/eventos/infrastructure/config/Resilience4jConfig.java` — El topic pide resiliencia: este archivo es el ejercicio.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/pragma/eventos/infrastructure/controllers/EventoController.java` — `com.pragma.eventos.infrastructure.dto.EventoDTO`: El import com.pragma.eventos.infrastructure.dto.EventoDTO usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- `src/main/java/com/pragma/eventos/EventosApplication.java` — `reactor.core.publisher`: El import reactor.core.publisher.Hooks pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/eventos/EventosApplication.java` — `reactor.core.scheduler`: El import reactor.core.scheduler.Schedulers pertenece a reactor.core.scheduler, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/eventos/domain/port/EventoRepository.java` — `reactor.core.publisher`: El import reactor.core.publisher.Flux pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/eventos/domain/port/EventoProcessor.java` — `reactor.core.publisher`: El import reactor.core.publisher.Flux pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/eventos/application/usecase/EventoUseCase.java` — `reactor.core.publisher`: El import reactor.core.publisher.Flux pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/eventos/infrastructure/adapters/EventoRepositoryAdapter.java` — `reactor.core.publisher`: El import reactor.core.publisher.Flux pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/eventos/infrastructure/adapters/EventoProcessorAdapter.java` — `reactor.core.publisher`: El import reactor.core.publisher.Flux pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/eventos/infrastructure/controllers/EventoController.java` — `reactor.core.publisher`: El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/test/java/com/pragma/eventos/application/usecase/EventoUseCaseTest.java` — `reactor.core.publisher`: El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/test/java/com/pragma/eventos/infrastructure/adapters/EventoProcessorAdapterTest.java` — `reactor.core.publisher`: El import reactor.core.publisher.Flux pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- `src/main/java/com/pragma/eventos/infrastructure/controllers/EventoController.java` — `EventoProcessor.findById`: Se invoca `findById` sobre `EventoProcessor`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/eventos/application/usecase/EventoUseCaseTest.java` — `EventoUseCase.processEvent`: Se invoca `processEvent` sobre `EventoUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/eventos/application/usecase/EventoUseCaseTest.java` — `EventoRepository.saveAll`: Se invoca `saveAll` sobre `EventoRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/eventos/application/usecase/EventoUseCaseTest.java` — `EventoUseCase.processEvents`: Se invoca `processEvents` sobre `EventoUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/eventos/infrastructure/adapters/EventoProcessorAdapterTest.java` — `EventoProcessorAdapter.processEvent`: Se invoca `processEvent` sobre `EventoProcessorAdapter`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/eventos/infrastructure/adapters/EventoProcessorAdapterTest.java` — `EventoProcessorAdapter.processEvents`: Se invoca `processEvents` sobre `EventoProcessorAdapter`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollador, Tecnología Java, Advanced

### Brecha de conocimiento
Gestiona los conceptos de concurrencia y paralelismo en su lenguaje de programación, con el fin de prevenir procesos bloqueantes. Identifica las diferencias entre un proceso y un hilo de ejecución. (En Node.js, aplica el Bucle de Eventos - Event Loop).

### Misión / candidato
Candidato con experiencia avanzada en desarrollo backend.

### Reto
- Tema: Gestión de Concurrencia y Paralelismo: Optimizando el Eventos
- Seniority: advanced-l2
- Tipo: practical
- Título: Optimización de Eventos Concurrentes
- Tiempo estimado: 8 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Identificación de Eventos y Procesos — objetivo: Identificar y categorizar los eventos recibidos por el sistema y determinar la necesidad de procesos y hilos de ejecución. — entregable (NO resolver): Documento que detalla la categorización de eventos y la necesidad de procesos y hilos de ejecución.
- Fase 2: Implementación de Procesos y Hilos — objetivo: Implementar la gestión de procesos y hilos de ejecución para los eventos categorizados. — entregable (NO resolver): Código que implementa la gestión de procesos y hilos de ejecución para los eventos.
- Fase 3: Optimización y Pruebas — objetivo: Optimizar la implementación y realizar pruebas para asegurar la eficiencia y ausencia de bloqueos. — entregable (NO resolver): Código optimizado y reporte de pruebas.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.6</version>
        <relativePath/>
    </parent>

    <groupId>com.pragma</groupId>
    <artifactId>eventos</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>eventos</name>
    <description>Sistema de procesamiento reactivo de eventos financieros</description>

    <properties>
        <java.version>21</java.version>
        <reactor.version>3.6.8</reactor.version>
        <resilience4j.version>2.2.0</resilience4j.version>
    </properties>

    <dependencies>
        <!-- Spring Boot Starters -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-webflux</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>

        <!-- Reactor -->
        <dependency>
            <groupId>io.projectreactor</groupId>
            <artifactId>reactor-core</artifactId>
            <version>${reactor.version}</version>
        </dependency>

        <!-- Resilience4j para Spring Boot 3 -->
        <dependency>
            <groupId>io.github.resilience4j</groupId>
            <artifactId>resilience4j-spring-boot3</artifactId>
            <version>${resilience4j.version}</version>
        </dependency>
        <dependency>
            <groupId>io.github.resilience4j</groupId>
            <artifactId>resilience4j-reactor</artifactId>
            <version>${resilience4j.version}</version>
        </dependency>

        <!-- Base de datos -->
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>

        <!-- Testing -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.projectreactor</groupId>
            <artifactId>reactor-test</artifactId>
            <version>${reactor.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.testcontainers</groupId>
            <artifactId>postgresql</artifactId>
            <version>1.20.1</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.testcontainers</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>1.20.1</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>${java.version}</source>
                    <target>${java.version}</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/pragma/eventos/EventosApplication.java ===
package com.pragma.eventos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Hooks;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class EventosApplication {

    public static void main(String[] args) {
        // Configuración inicial de Reactor para mejores mensajes de error en caso de bloqueos
        Hooks.onOperatorDebug();
        SpringApplication.run(EventosApplication.class, args);
    }

    @Bean
    public ExecutorService eventoExecutorService() {
        // Pool de hilos dedicado para procesamiento de eventos
        return Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors() * 2,
            r -> {
                Thread t = new Thread(r, "evento-processor");
                t.setDaemon(true);
                return t;
            }
        );
    }

    @Bean
    public Schedulers.CustomizableScheduler eventoScheduler(ExecutorService eventoExecutorService) {
        return Schedulers.fromExecutorService(eventoExecutorService);
    }
}

// === ARCHIVO: src/main/resources/application.yml ===
spring:
  application:
    name: eventos-service
  datasource:
    url: jdbc:postgresql://localhost:5432/eventos_db
    username: eventos_user
    password: eventos_pass
    driver-class-name: org.postgresql.Driver
    hikari:
      maximum-pool-size: 10
      connection-timeout: 30000
  jpa:
    database-platform: org.hibernate.dialect.PostgreSQLDialect
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        format_sql: true
        jdbc:
          lob:
            non_contextual_creation: true
    show-sql: false

server:
  port: 8080
  netty:
    connection-timeout: 10000
    idle-timeout: 30000

# Configuración de Reactor
reactor:
  scheduler:
    event-loop-threads: 4

# Configuración de Resilience4j
resilience4j:
  circuitbreaker:
    configs:
      default:
        slidingWindowType: TIME_BASED
        slidingWindowSize: 10
        minimumNumberOfCalls: 5
        permittedNumberOfCallsInHalfOpenState: 3
        automaticTransitionFromOpenToHalfOpenEnabled: true
        waitDurationInOpenState: 5s
        failureRateThreshold: 50
        eventConsumerBufferSize: 10
    instances:
      eventoProcessor:
        baseConfig: default
  retry:
    configs:
      default:
        maxAttempts: 3
        waitDuration: 100ms
        retryExceptions:
          - org.springframework.web.client.ResourceAccessException
          - java.io.IOException
    instances:
      eventoProcessor:
        baseConfig: default
  ratelimiter:
    configs:
      default:
        limitForPeriod: 100
        limitRefreshPeriod: 1s
        timeoutDuration: 25ms
    instances:
      eventoProcessor:
        baseConfig: default

logging:
  level:
    root: INFO
    com.pragma.eventos: DEBUG
    reactor.netty: INFO
    org.springframework.web: INFO
    org.hibernate: ERROR

// === ARCHIVO: src/main/java/com/pragma/eventos/domain/model/Evento.java ===
package com.pragma.eventos.domain.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record Evento(
    UUID id,
    String tipo,
    String origen,
    Instant timestamp,
    BigDecimal monto,
    String estado,
    String metadata
) {
    public static final String ESTADO_PENDIENTE = "PENDIENTE";
    public static final String ESTADO_PROCESADO = "PROCESADO";
    public static final String ESTADO_FALLIDO = "FALLIDO";

    public Evento {
        if (id == null) {
            throw new IllegalArgumentException("El id del evento no puede ser nulo");
        }
        if (tipo == null || tipo.isBlank()) {
            throw new IllegalArgumentException("El tipo del evento no puede ser nulo o vacío");
        }
        if (origen == null || origen.isBlank()) {
            throw new IllegalArgumentException("El origen del evento no puede ser nulo o vacío");
        }
        if (timestamp == null) {
            throw new IllegalArgumentException("El timestamp del evento no puede ser nulo");
        }
        if (monto != null && monto.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El monto no puede ser negativo");
        }
    }

    public Evento conEstado(String nuevoEstado) {
        return new Evento(this.id, this.tipo, this.origen, this.timestamp, this.monto, nuevoEstado, this.metadata);
    }

    public boolean esDeAltoRiesgo() {
        return "MOTOR_ANTIFRAUDE".equals(this.origen) && this.monto != null && this.monto.compareTo(new BigDecimal("10000")) > 0;
    }

    public boolean requiereProcesamientoPrioritario() {
        return "GATEWAY_PAGOS".equals(this.origen);
    }
}

// === ARCHIVO: src/main/java/com/pragma/eventos/domain/port/EventoRepository.java ===
package com.pragma.eventos.domain.port;

import com.pragma.eventos.domain.model.Evento;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.UUID;

public interface EventoRepository {
    Mono<Evento> save(Evento evento);
    Mono<Evento> findById(UUID id);
    Flux<Evento> findAll();
    Flux<Evento> findByEstado(String estado);
    Flux<Evento> findByOrigen(String origen);
    Mono<Void> deleteById(UUID id);
    Flux<Evento> findEventosParaProcesar();
}

// === ARCHIVO: src/main/java/com/pragma/eventos/domain/port/EventoProcessor.java ===
package com.pragma.eventos.domain.port;

import com.pragma.eventos.domain.model.Evento;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EventoProcessor {
    Mono<Evento> procesarEvento(Evento evento);
    Flux<Evento> procesarEventos(Flux<Evento> eventos);
    Mono<Void> iniciarProcesamientoContinuo();
    Mono<Long> contarEventosProcesados();
    Mono<Long> contarEventosFallidos();
}

// === ARCHIVO: src/main/java/com/pragma/eventos/application/usecase/EventoUseCase.java ===
package com.pragma.eventos.application.usecase;

import com.pragma.eventos.domain.model.Evento;
import com.pragma.eventos.domain.port.EventoProcessor;
import com.pragma.eventos.domain.port.EventoRepository;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.reactor.circuitbreaker.operator.CircuitBreakerOperator;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EventoUseCase {

    private final EventoRepository eventoRepository;
    private final EventoProcessor eventoProcessor;
    private final CircuitBreaker circuitBreaker;

    public EventoUseCase(EventoRepository eventoRepository, EventoProcessor eventoProcessor, CircuitBreakerRegistry circuitBreakerRegistry) {
        this.eventoRepository = eventoRepository;
        this.eventoProcessor = eventoProcessor;
        this.circuitBreaker = circuitBreakerRegistry.circuitBreaker("eventoCircuitBreaker");
    }

    public Mono<Evento> procesarEvento(Evento evento) {
        return eventoProcessor.procesarEvento(evento)
               .transform(CircuitBreakerOperator.of(circuitBreaker));
    }

    public Flux<Evento> procesarEventos(Flux<Evento> eventos) {
        return eventos.flatMap(this::procesarEvento);
    }

    public Mono<Void> iniciarProcesamientoContinuo() {
        return eventoProcessor.iniciarProcesamientoContinuo();
    }

    public Mono<Long> contarEventosProcesados() {
        return eventoProcessor.contarEventosProcesados();
    }

    public Mono<Long> contarEventosFallidos() {
        return eventoProcessor.contarEventosFallidos();
    }
}

// === ARCHIVO: src/main/java/com/pragma/eventos/infrastructure/adapters/EventoRepositoryAdapter.java ===
package com.pragma.eventos.infrastructure.adapters;

import com.pragma.eventos.domain.model.Evento;
import com.pragma.eventos.domain.port.EventoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class EventoRepositoryAdapter implements EventoRepository {

    @Override
    public Mono<Evento> save(Evento evento) {
        // Implementación con Spring Data JPA
        return Mono.empty();
    }

    @Override
    public Mono<Evento> findById(UUID id) {
        // Implementación con Spring Data JPA
        return Mono.empty();
    }

    @Override
    public Flux<Evento> findAll() {
        // Implementación con Spring Data JPA
        return Flux.empty();
    }

    @Override
    public Flux<Evento> findByEstado(String estado) {
        // Implementación con Spring Data JPA
        return Flux.empty();
    }

    @Override
    public Flux<Evento> findByOrigen(String origen) {
        // Implementación con Spring Data JPA
        return Flux.empty();
    }

    @Override
    public Mono<Void> deleteById(UUID id) {
        // Implementación con Spring Data JPA
        return Mono.empty();
    }

    @Override
    public Flux<Evento> findEventosParaProcesar() {
        // Implementación con Spring Data JPA
        return Flux.empty();
    }
}

// === ARCHIVO: src/main/java/com/pragma/eventos/infrastructure/adapters/EventoProcessorAdapter.java ===
package com.pragma.eventos.infrastructure.adapters;

import com.pragma.eventos.domain.model.Evento;
import com.pragma.eventos.domain.port.EventoProcessor;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.reactor.circuitbreaker.operator.CircuitBreakerOperator;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class EventoProcessorAdapter implements EventoProcessor {

    private final CircuitBreaker circuitBreaker;

    public EventoProcessorAdapter(CircuitBreakerRegistry circuitBreakerRegistry) {
        this.circuitBreaker = circuitBreakerRegistry.circuitBreaker("eventoCircuitBreaker");
    }

    @Override
    public Mono<Evento> procesarEvento(Evento evento) {
        // Implementación con Reactor y Resilience4j
        return Mono.just(evento);
    }

    @Override
    public Flux<Evento> procesarEventos(Flux<Evento> eventos) {
        return eventos.flatMap(this::procesarEvento);
    }

    @Override
    public Mono<Void> iniciarProcesamientoContinuo() {
        // Implementación con Reactor y Resilience4j
        return Mono.empty();
    }

    @Override
    public Mono<Long> contarEventosProcesados() {
        // Implementación con Reactor y Resilience4j
        return Mono.just(0L);
    }

    @Override
    public Mono<Long> contarEventosFallidos() {
        // Implementación con Reactor y Resilience4j
        return Mono.just(0L);
    }
}

// === ARCHIVO: src/main/java/com/pragma/eventos/infrastructure/config/ReactorConfig.java ===
package com.pragma.eventos.infrastructure.config;

import io.projectreactor.core.publisher.Schedulers;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReactorConfig {

    private static final int POOL_SIZE = 10;

    @Bean
    public ExecutorService eventoExecutorService() {
        return Executors.newFixedThreadPool(POOL_SIZE);
    }

    @Bean
    public Schedulers.CustomizableScheduler eventoScheduler(ExecutorService eventoExecutorService) {
        return Schedulers.fromExecutorService(eventoExecutorService);
    }
}

// === ARCHIVO: src/main/java/com/pragma/eventos/infrastructure/config/Resilience4jConfig.java ===
package com.pragma.eventos.infrastructure.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.springboot3.circuitbreaker.annotation.CircuitBreakerConfigs;
import io.github.resilience4j.springboot3.retry.annotation.RetryConfigs;
import io.github.resilience4j.springboot3.ratelimiter.annotation.RateLimiterConfigs;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Resilience4jConfig {

    @Bean
    @CircuitBreakerConfigs
    public CircuitBreakerConfig customCircuitBreakerConfig() {
        return CircuitBreakerConfig.custom()
               .failureRateThreshold(50)
               .waitDurationInOpenState(java.time.Duration.ofSeconds(60))
               .build();
    }

    @Bean
    @RetryConfigs
    public RetryConfig customRetryConfig() {
        return RetryConfig.custom()
               .maxAttempts(3)
               .waitDuration(java.time.Duration.ofSeconds(1))
               .build();
    }

    @Bean
    @RateLimiterConfigs
    public RateLimiterConfig customRateLimiterConfig() {
        return RateLimiterConfig.custom()
               .limitForPeriod(10)
               .limitRefreshPeriod(java.time.Duration.ofSeconds(1))
               .timeoutDuration(java.time.Duration.ofSeconds(2))
               .build();
    }
}

// === ARCHIVO: src/main/java/com/pragma/eventos/infrastructure/controllers/EventoController.java ===
package com.pragma.eventos.infrastructure.controllers;

import com.pragma.eventos.domain.model.Evento;
import com.pragma.eventos.domain.port.EventoProcessor;
import com.pragma.eventos.infrastructure.dto.EventoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    @Autowired
    private EventoProcessor eventoProcessor;

    @PostMapping
    public Mono<ResponseEntity<EventoDTO>> recibirEvento(@RequestBody Evento evento) {
        return eventoProcessor.procesarEvento(evento)
               .map(e -> ResponseEntity.status(HttpStatus.CREATED).body(new EventoDTO(e)))
               .onErrorResume(e -> Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()));
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<EventoDTO>> obtenerEstadoEvento(@PathVariable UUID id) {
        return eventoProcessor.findById(id)
               .map(e -> ResponseEntity.ok(new EventoDTO(e)))
               .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()))
               .onErrorResume(e -> Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()));
    }
}

// === ARCHIVO: src/main/java/com/pragma/eventos/infrastructure/controllers/EventoControllerIT.java ===
package com.pragma.eventos.infrastructure.controllers;

import com.pragma.eventos.domain.model.Evento;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
@AutoConfigureWebTestClient
class EventoControllerIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreateEvent() {
        Evento evento = new Evento(UUID.randomUUID(), "tipo", "origen", "timestamp");
        webTestClient.post()
               .uri("/eventos")
               .bodyValue(evento)
               .exchange()
               .expectStatus().isCreated()
               .expectBody(Evento.class);
    }

    @Test
    void testGetEventById() {
        UUID id = UUID.randomUUID();
        webTestClient.get()
               .uri("/eventos/" + id)
               .exchange()
               .expectStatus().isOk()
               .expectBody(Evento.class);
    }

    @Test
    void testGetAllEvents() {
        webTestClient.get()
               .uri("/eventos")
               .exchange()
               .expectStatus().isOk()
               .expectBodyList(Evento.class);
    }
}

// === ARCHIVO: src/test/java/com/pragma/eventos/application/usecase/EventoUseCaseTest.java ===
package com.pragma.eventos.application.usecase;

import com.pragma.eventos.domain.model.Evento;
import com.pragma.eventos.domain.port.EventoProcessor;
import com.pragma.eventos.domain.port.EventoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class EventoUseCaseTest {

    @Mock
    private EventoRepository eventoRepository;

    @Mock
    private EventoProcessor eventoProcessor;

    @InjectMocks
    private EventoUseCase eventoUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testProcessEvent() {
        Evento evento = new Evento(UUID.randomUUID(), "tipo", "origen", "timestamp");
        when(eventoRepository.save(evento)).thenReturn(Mono.just(evento));
        when(eventoProcessor.procesarEvento(evento)).thenReturn(Mono.just(evento));

        StepVerifier.create(eventoUseCase.processEvent(evento))
               .expectNext(evento)
               .verifyComplete();
    }

    @Test
    void testProcessEvents() {
        Evento evento1 = new Evento(UUID.randomUUID(), "tipo1", "origen1", "timestamp1");
        Evento evento2 = new Evento(UUID.randomUUID(), "tipo2", "origen2", "timestamp2");
        when(eventoRepository.saveAll(any())).thenReturn(Mono.just(evento1));
        when(eventoProcessor.procesarEventos(any())).thenReturn(Mono.just(evento1));

        StepVerifier.create(eventoUseCase.processEvents(Flux.just(evento1, evento2)))
               .expectNext(evento1)
               .verifyComplete();
    }
}

// === ARCHIVO: src/test/java/com/pragma/eventos/infrastructure/adapters/EventoProcessorAdapterTest.java ===
package com.pragma.eventos.infrastructure.adapters;

import com.pragma.eventos.domain.model.Evento;
import com.pragma.eventos.domain.port.EventoProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class EventoProcessorAdapterTest {

    @Mock
    private EventoProcessor eventoProcessor;

    @InjectMocks
    private EventoProcessorAdapter eventoProcessorAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testProcessEvent() {
        Evento evento = new Evento(UUID.randomUUID(), "tipo", "origen", "timestamp");
        when(eventoProcessor.procesarEvento(evento)).thenReturn(Mono.just(evento));

        StepVerifier.create(eventoProcessorAdapter.processEvent(evento))
               .expectNext(evento)
               .verifyComplete();
    }

    @Test
    void testProcessEvents() {
        Evento evento1 = new Evento(UUID.randomUUID(), "tipo1", "origen1", "timestamp1");
        Evento evento2 = new Evento(UUID.randomUUID(), "tipo2", "origen2", "timestamp2");
        when(eventoProcessor.procesarEventos(any())).thenReturn(Flux.just(evento1));

        StepVerifier.create(eventoProcessorAdapter.processEvents(Flux.just(evento1, evento2)))
               .expectNext(evento1)
               .verifyComplete();
    }
}
```
