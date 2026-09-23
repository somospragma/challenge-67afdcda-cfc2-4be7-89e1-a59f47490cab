# Optimización de Eventos Concurrentes

En un sistema de procesamiento de eventos financieros, es crucial gestionar la concurrencia y el paralelismo para evitar procesos bloqueantes y asegurar la eficiencia del sistema. El sistema recibe eventos de múltiples fuentes (buró de riesgos, motor antifraude, gateway de pagos) y debe procesarlos de manera eficiente. Los eventos tienen atributos como id, tipo, origen, timestamp, y deben ser procesados en paralelo para mantener una latencia baja (máximo 100ms por evento). El sistema debe identificar y manejar correctamente los procesos y hilos de ejecución, asegurando que no se produzcan bloqueos innecesarios.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Gestión de Concurrencia y Paralelismo: Optimizando el Eventos |
| **Nivel** | advanced-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Identificación de Eventos y Procesos

**Objetivo:** Identificar y categorizar los eventos recibidos por el sistema y determinar la necesidad de procesos y hilos de ejecución.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Analiza las fuentes de eventos y sus atributos.
- Identifica los eventos que pueden ser procesados en paralelo y aquellos que requieren un procesamiento secuencial.
- Criterios de aceptación: Categorización clara de eventos y determinación de procesos y hilos necesarios.

**Entregable:** Documento que detalla la categorización de eventos y la necesidad de procesos y hilos de ejecución.

<details>
<summary>Pistas de conocimiento</summary>

- Considera la latencia máxima permitida por evento.
- Evalúa la dependencia entre eventos para determinar la secuencialidad o paralelismo.

</details>

### Fase 2: Implementación de Procesos y Hilos

**Objetivo:** Implementar la gestión de procesos y hilos de ejecución para los eventos categorizados.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Implementa la lógica para gestionar los procesos y hilos de ejecución de los eventos.
- Asegura que los eventos que pueden ser procesados en paralelo lo sean, y que los eventos secuenciales se manejen correctamente.
- Criterios de aceptación: Implementación funcional de procesos y hilos de ejecución.

**Entregable:** Código que implementa la gestión de procesos y hilos de ejecución para los eventos.

<details>
<summary>Pistas de conocimiento</summary>

- Utiliza mecanismos de sincronización para evitar bloqueos innecesarios.
- Considera el uso de pools de hilos para optimizar el procesamiento.

</details>

### Fase 3: Optimización y Pruebas

**Objetivo:** Optimizar la implementación y realizar pruebas para asegurar la eficiencia y ausencia de bloqueos.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Optimiza la implementación de procesos y hilos de ejecución.
- Realiza pruebas para asegurar que la latencia máxima por evento no se supera y que no hay bloqueos innecesarios.
- Criterios de aceptación: Implementación optimizada y pruebas exitosas.

**Entregable:** Código optimizado y reporte de pruebas.

<details>
<summary>Pistas de conocimiento</summary>

- Utiliza herramientas de profiling para identificar y optimizar cuellos de botella.
- Realiza pruebas de carga para asegurar la eficiencia del sistema.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué son los procesos y hilos de ejecución en el contexto de este reto?
- **paraQueSirve**: ¿Para qué sirve gestionar la concurrencia y el paralelismo en este sistema?
- **comoSeUsa**: ¿Cómo se implementan los procesos y hilos de ejecución en este reto?
- **erroresComunes**: ¿Cuáles son los errores comunes al gestionar la concurrencia y el paralelismo?
- **queDecisionesImplica**: ¿Qué decisiones implica la optimización de la implementación de procesos y hilos de ejecución?

## Criterios de Evaluacion

- Identificación correcta de eventos y determinación de procesos y hilos necesarios.
- Implementación funcional de procesos y hilos de ejecución.
- Optimización de la implementación y pruebas exitosas.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
