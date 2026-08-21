# Entregables - Semana 2

## Proyecto 1: API REST con Spring Data JPA y MySQL (Magos)

Una API RESTful completa para administrar un directorio de magos (inspirado en la escuela de Harry Potter, Hogwarts).

* **Características:**
    * Uso de JPA para mapear la entidad `Mago` a una tabla relacional.
    * Endpoints CRUD completos (`GET`, `POST`, `PUT`, `PATCH`, `DELETE`) en la ruta `/api/magos`.
    * Arquitectura en tres capas: `RestController`, `Service` y `Repository`.
    * Control de excepciones básico para registros no encontrados.

---

## Proyecto 2: API REST con Spring Data MongoDB (Magos)

Evolución del primer proyecto, a una base de datos NoSQL basada en documentos (MongoDB), manteniendo la misma temática.

* **Características:**
    * Sustitución de las anotaciones de JPA (`@Entity`, `@Table`) por las de MongoDB (`@Document`).
    * Uso de identificadores `String` (ObjectId hexadecimales) en lugar de enteros auto-incrementables.
    * Demostración de la flexibilidad de los esquemas NoSQL (eliminación de anotaciones restrictivas como `@Column`).
    * Conexión exitosa a contenedores de MongoDB desplegados localmente.

---

## Proyecto 3: Inyección de Dependencias en Java Puro (Animal Crossing)

Un programa en Java nativo diseñado para explicar de forma práctica el patrón de Inyección de Dependencias (DI), sin la intervención de frameworks ni contenedores automáticos (como Spring). Se utiliza una temática del videojuego de nintendo *Animal Crossing* para demostrar la flexibilidad del código.

### ¿Por qué usamos Inyección de Dependencias?

El objetivo de este proyecto es demostrar cómo resolver dos problemas críticos en el diseño de software:

1. **Bajo Acoplamiento (Coupling):**
   En una mala práctica (documentada en el código), una clase instancia sus propias dependencias usando la palabra `new` (por ejemplo, un aldeano fabricando su propia caña de pescar de forma rígida). Inyectamos la dependencia a través del **constructor** recibiendo una interfaz genérica (`Herramienta`). Esto permite intercambiar la herramienta en tiempo de ejecución (de caña a red) sin necesidad de modificar el código fuente de la clase constructora.

