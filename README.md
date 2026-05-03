# Sistema de Gestión de Pedidos - Clean Architecture (UFPS)

Este proyecto implementa un módulo de gestión de pedidos aplicando los principios de **Clean Architecture** (Arquitectura Limpia). La estructura está diseñada en círculos concéntricos donde la lógica de negocio es el núcleo y las dependencias solo apuntan hacia adentro, protegiendo el dominio de cambios en frameworks o bases de datos.



## 🏗️ Estructura de Círculos
El sistema se organiza estrictamente bajo la **Dependency Rule**:

### 1. Círculo de Entities (Dominio)
Es el núcleo más estable del sistema. No tiene dependencias de ningún framework externo.
* **Aggregate Root (`Pedido`)**: Controla las reglas de negocio empresariales, como la validación de líneas y el cambio de estados.
* **Value Objects**: Objetos inmutables con validación propia en el constructor:
    * `Dinero`: Maneja montos monetarios de forma segura.
    * `PedidoId`: Identidad tipada basada en UUID.
    * `LineaPedido`: Representa los ítems del pedido.

### 2. Círculo de Use Cases (Reglas de Aplicación)
Define las operaciones específicas del sistema.
* **Ports (`port/`)**: Interfaces que definen cómo el sistema se comunica con el exterior (ej. `PedidoRepositoryPort`).
* **Services (`impl/`)**: Implementaciones de los casos de uso (ej. `CrearPedidoService`) que orquestan las entidades para cumplir con un flujo de proceso.

### 3. Círculo de Interface Adapters
Traduce los datos entre el formato más conveniente para el dominio y el formato más conveniente para agentes externos.
* **Controllers**: Reciben peticiones HTTP y las transforman en llamadas a los casos de uso.
* **Presenters/DTOs**: Estructuras de datos para la comunicación con la API.
* **Repositories**: Implementan los puertos de salida, mapeando objetos de dominio a entidades de persistencia.

### 4. Círculo de Frameworks & Drivers
Es la capa más externa y cambiante.
* **Spring Boot 3**: Motor de inyección de dependencias y servidor web.
* **JPA / H2**: Detalles técnicos de la persistencia de datos.

## 🚀 Guía de Ejecución

### Prerrequisitos
* **Java JDK 17** o superior.
* **Maven 3.8+**.

### Instalación y Arranke
1.  Clonar el repositorio:
    ```bash
    git clone [https://github.com/juandiego305/Contreras-post1-u8.git](https://github.com/juandiego305/Contreras-post1-u8.git)
    ```
2.  Compilar el proyecto:
    ```bash
    mvn clean compile
    ```
3.  Ejecutar la aplicación:
    ```bash
    mvn spring-boot:run
    ```

## 🛰️ Endpoints Principales

| Método | Endpoint | Descripción |
| :--- | :--- | :--- |
| **POST** | `/api/pedidos` | Crea un pedido validando reglas de dominio. |
| **GET** | `/api/pedidos/{id}` | Consulta un pedido con el total calculado. |
| **GET** | `/api/pedidos` | Lista todos los pedidos registrados. |

## ✅ Checkpoints de Verificación
* **Aislamiento**: El paquete `domain/` no contiene ningún import de Spring o JPA.
* **Lógica de Negocio**: No se pueden agregar líneas a un pedido que ya ha sido confirmado.
* **Validación**: Intentar crear un pedido con cantidades negativas devuelve un error **400 Bad Request**.

## 🧑‍💻 Autor
* **Nombre**: Juan Diego Contreras Garcia
* **Institución**: Universidad Francisco de Paula Santander (UFPS)
* **Programa**: Ingeniería de Sistemas - 2026

---
© 2026 UFPS - Facultad de Ingeniería
