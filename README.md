# AcademiaMonterrey
Actividades realizadas en Academia Backend · QE · GitHub Copilot — Monterrey (Ago 2026)

Semana 1: 
# VisualContentTracker

Un sistema de gestión interactivo por línea de comandos (CLI) desarrollado en Java para rastrear, calificar y administrar el progreso de series animadas y contenido visual. 

Este proyecto fue construido como parte de una evaluación técnica, enfocándose en la implementación de buenas prácticas de Ingeniería de Software y Programación Orientada a Objetos (POO).

## Características Principales

- **Menú Interactivo CLI:** Navegación fluida mediante un bucle infinito que permite al usuario interactuar en tiempo real con el sistema.
- **Persistencia en Memoria (Singleton):** Uso del patrón de diseño Singleton para garantizar una única instancia del catálogo, evitando pérdida de datos durante la ejecución.
- **Validación y Resiliencia:** Implementación de bloques `try-catch` y lanzamiento de excepciones (`IllegalArgumentException`) para evitar colapsos del sistema ante entradas inválidas (ej. calificaciones fuera del rango 1-10).
- **Arquitectura Escalable:** Estructura basada en clases abstractas e interfaces que permite agregar nuevos tipos de contenido (como películas o documentales) con mínimo impacto en el código existente.
- **Seguridad de Tipos:** Uso de `instanceof` y *Casting* para garantizar la integridad de las operaciones exclusivas de ciertos objetos (ej. incrementar capítulos solo en series).

Tecnologías y Conceptos Aplicados

- **Lenguaje:** Java 
- **Control de Versiones:** Git & GitHub
- **Pilares POO:** Herencia, Polimorfismo, Encapsulación y Abstracción.
- **Estructuras de Datos:** `ArrayList` con tipado genérico (`List<ContenidoVisual>`).
- **Paradigma:** Combinación de POO y algoritmos imperativos para la búsqueda y filtrado de datos.

