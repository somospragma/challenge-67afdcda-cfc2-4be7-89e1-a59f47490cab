# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Optimización de Eventos Concurrentes**.

| | |
|---|---|
| Tema | Gestión de Concurrencia y Paralelismo: Optimizando el Eventos |
| Nivel | advanced-l2 |
| Chapter | Backend |
| Especialidad | Java |
| Stack | Java / Spring Boot 3.5 |
| Patron arquitectonico | hexagonal/clean con procesamiento reactivo |
| Tiempo estimado | 8 horas |

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz`
- `clase con @SpringBootApplication`
- `application.yml en src/main/resources`
- `capa de dominio con entidades y puertos`
- `capa de aplicacion con casos de uso`
- `capa de infraestructura con adaptadores y @RestController`

Trampas conocidas:

- TODA `<version>` del pom va con tres segmentos: la del parent (ej. `3.5.6`) y la de cada dependencia que la lleve (ej. Resilience4j `2.2.0`). `3.4` y `2.0` no existen como artefacto y el build muere resolviendo dependencias.
- Las dependencias que el parent POM gestiona van SIN `<version>`: `spring-boot-starter-web`, `-data-jpa`, `-validation`, `-test`, etc.
- Resilience4j publica un artefacto por linea de Spring Boot. Con Spring Boot 3 va `resilience4j-spring-boot3` con version de tres segmentos (ej. `2.2.0`, no `2.0`). `resilience4j-spring-boot2` es de Spring Boot 2 y rompe el arranque.
- Si usas anotaciones de validacion (`@NotNull`, `@Size`, `@Positive`) declara `spring-boot-starter-validation`: el starter web no las trae.
- El `spring-boot-maven-plugin` tiene que estar en `<build><plugins>` o no se empaqueta ejecutable.
- Spring Boot 3 usa `jakarta.*`, nunca `javax.*`.
- Cada archivo empieza con su `package` y con un `import` por cada clase del proyecto que viva en otro paquete. Usar `PaymentService` desde `infrastructure` sin `import com.x.application.PaymentService` no compila.

Dependencias:

- org.springframework.boot:spring-boot-starter-webflux 3.5.6
- org.springframework.boot:spring-boot-starter-data-jpa n/a
- io.projectreactor:reactor-core 3.6.8
- io.github.resilience4j:resilience4j-spring-boot3 2.2.0
- org.postgresql:postgresql n/a
- org.springframework.boot:spring-boot-starter-test n/a
- io.projectreactor:reactor-test 3.6.8
- org.testcontainers:postgresql 1.20.1

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn clean compile` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn clean compile` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Identificación de Eventos y Procesos**: Documento que detalla la categorización de eventos y la necesidad de procesos y hilos de ejecución.
- **Fase 2 — Implementación de Procesos y Hilos**: Código que implementa la gestión de procesos y hilos de ejecución para los eventos.
- **Fase 3 — Optimización y Pruebas**: Código optimizado y reporte de pruebas.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Superficie de practica (NO completes)

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs. No toques la logica que el reto pide completar.

- [ ] `src/main/java/com/pragma/eventos/infrastructure/config/Resilience4jConfig.java` — El topic pide resiliencia: este archivo es el ejercicio.

## Lo que falta y tenes que completar

### 1. Referencias colgando (17)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/main/java/com/pragma/eventos/infrastructure/controllers/EventoController.java` — `com.pragma.eventos.infrastructure.dto.EventoDTO`
      El import com.pragma.eventos.infrastructure.dto.EventoDTO usa un paquete propio del proyecto pero ningun archivo generado declara ese tipo. Falta generar la clase/interfaz, o el import esta mal escrito.
- [ ] `src/main/java/com/pragma/eventos/EventosApplication.java` — `reactor.core.publisher`
      El import reactor.core.publisher.Hooks pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/pragma/eventos/EventosApplication.java` — `reactor.core.scheduler`
      El import reactor.core.scheduler.Schedulers pertenece a reactor.core.scheduler, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/pragma/eventos/domain/port/EventoRepository.java` — `reactor.core.publisher`
      El import reactor.core.publisher.Flux pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/pragma/eventos/domain/port/EventoProcessor.java` — `reactor.core.publisher`
      El import reactor.core.publisher.Flux pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/pragma/eventos/application/usecase/EventoUseCase.java` — `reactor.core.publisher`
      El import reactor.core.publisher.Flux pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/pragma/eventos/infrastructure/adapters/EventoRepositoryAdapter.java` — `reactor.core.publisher`
      El import reactor.core.publisher.Flux pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/pragma/eventos/infrastructure/adapters/EventoProcessorAdapter.java` — `reactor.core.publisher`
      El import reactor.core.publisher.Flux pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/pragma/eventos/infrastructure/controllers/EventoController.java` — `reactor.core.publisher`
      El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/test/java/com/pragma/eventos/application/usecase/EventoUseCaseTest.java` — `reactor.core.publisher`
      El import reactor.core.publisher.Mono pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/test/java/com/pragma/eventos/infrastructure/adapters/EventoProcessorAdapterTest.java` — `reactor.core.publisher`
      El import reactor.core.publisher.Flux pertenece a reactor.core.publisher, pero ninguna dependencia declarada en el pom.xml cubre ese paquete. Falta agregar la dependencia o el import esta mal (libreria equivocada).
- [ ] `src/main/java/com/pragma/eventos/infrastructure/controllers/EventoController.java` — `EventoProcessor.findById`
      Se invoca `findById` sobre `EventoProcessor`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/eventos/application/usecase/EventoUseCaseTest.java` — `EventoUseCase.processEvent`
      Se invoca `processEvent` sobre `EventoUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/eventos/application/usecase/EventoUseCaseTest.java` — `EventoRepository.saveAll`
      Se invoca `saveAll` sobre `EventoRepository`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/eventos/application/usecase/EventoUseCaseTest.java` — `EventoUseCase.processEvents`
      Se invoca `processEvents` sobre `EventoUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/eventos/infrastructure/adapters/EventoProcessorAdapterTest.java` — `EventoProcessorAdapter.processEvent`
      Se invoca `processEvent` sobre `EventoProcessorAdapter`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/eventos/infrastructure/adapters/EventoProcessorAdapterTest.java` — `EventoProcessorAdapter.processEvents`
      Se invoca `processEvents` sobre `EventoProcessorAdapter`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Presentes (15)

- `pom.xml`
- `src/main/java/com/pragma/eventos/EventosApplication.java`
- `src/main/resources/application.yml`
- `src/main/java/com/pragma/eventos/domain/model/Evento.java`
- `src/main/java/com/pragma/eventos/domain/port/EventoRepository.java`
- `src/main/java/com/pragma/eventos/domain/port/EventoProcessor.java`
- `src/main/java/com/pragma/eventos/application/usecase/EventoUseCase.java`
- `src/main/java/com/pragma/eventos/infrastructure/adapters/EventoRepositoryAdapter.java`
- `src/main/java/com/pragma/eventos/infrastructure/adapters/EventoProcessorAdapter.java`
- `src/main/java/com/pragma/eventos/infrastructure/config/ReactorConfig.java`
- `src/main/java/com/pragma/eventos/infrastructure/config/Resilience4jConfig.java`
- `src/main/java/com/pragma/eventos/infrastructure/controllers/EventoController.java`
- `src/main/java/com/pragma/eventos/infrastructure/controllers/EventoControllerIT.java`
- `src/test/java/com/pragma/eventos/application/usecase/EventoUseCaseTest.java`
- `src/test/java/com/pragma/eventos/infrastructure/adapters/EventoProcessorAdapterTest.java`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `src/main/java/com/pragma/eventos`
- `src/main/java/com/pragma/eventos/domain`
- `src/main/java/com/pragma/eventos/domain/model`
- `src/main/java/com/pragma/eventos/domain/port`
- `src/main/java/com/pragma/eventos/application`
- `src/main/java/com/pragma/eventos/application/usecase`
- `src/main/java/com/pragma/eventos/infrastructure`
- `src/main/java/com/pragma/eventos/infrastructure/adapters`
- `src/main/java/com/pragma/eventos/infrastructure/config`
- `src/main/java/com/pragma/eventos/infrastructure/controllers`
- `src/test/java/com/pragma/eventos`

## Verificacion

```bash
mvn clean compile
```

El comando tiene que pasar SIN implementar los archivos de la superficie de practica: solo andamiaje.

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **hexagonal/clean con procesamiento reactivo**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Backend, Especialidad Desarrollador, Tecnología Java, Advanced
- Brecha que el reto ataca: Gestiona los conceptos de concurrencia y paralelismo en su lenguaje de programación, con el fin de prevenir procesos bloqueantes. Identifica las diferencias entre un proceso y un hilo de ejecución. (En Node.js, aplica el Bucle de Eventos - Event Loop).
- Mision: Candidato con experiencia avanzada en desarrollo backend.

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
