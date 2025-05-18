# Prueba-técnica
## Descripción
Este proyecto contiene dos microservicios:
- **ms-productos**: Gestiona productos permitiendo crear, actualizar, listar y eliminar productos.
- **ms-inventario**: Gestiona el inventario de productos, permitiendo consultar la cantidad disponible y actualizarla.

## Arquitectura
Cada microservicio sigue una arquitectura de microservicios independiente basada en Spring Boot, utilizando:
- Spring Web para controladores REST.
- Spring Data JPA para persistencia de datos.
- Feign Client para comunicación entre microservicios.
- MySQL como base de datos para el microservicio de Productos.
- PostgreSQL como base de datos para el microservicio de Inventario.

## Instrucciones de Instalación y Ejecución

### Prerrequisitos

- Java 17.
- Maven instalado.

### Pasos para ejecutar

1. Clonar el repositorio:

```bash
git clone https://github.com/Cesar183/prueba-tecnica.git
```

## Ejecución
1. Navega a cada microservicio:
   ```bash
   cd ms-productos
   mvn spring-boot:run

   cd ms-invetario
   mvn spring-boot:run
   ```

### Acceder a las APIs:

    Productos: http://localhost:8001/app/productos

    Inventario: http://localhost:8002/app/inventario

#### Documentación Swagger UI:

    Productos: http://localhost:8001/swagger-ui/index.html

    Inventario: http://localhost:8002/swagger-ui/index.html

## Diagrama

![imagen](https://github.com/user-attachments/assets/d7710cee-abe9-4495-8aa9-c2f2968bc5b1)

## Estructura del Proyecto
```bash

├── ms-invetario
│   ├── docker-compose.yaml
│   ├── Dockerfile
│   ├── HELP.md
│   ├── mvnw
│   ├── mvnw.cmd
│   ├── pom.xml
│   └── src
│       ├── main
│       │   ├── java
│       │   │   └── com
│       │   │       └── app
│       │   │           └── ms_invetario
│       │   │               ├── client
│       │   │               │   └── ProductClient.java
│       │   │               ├── config
│       │   │               │   └── SwaggerConfig.java
│       │   │               ├── controller
│       │   │               │   └── InventoryController.java
│       │   │               ├── dto
│       │   │               │   └── ProductDto.java
│       │   │               ├── entity
│       │   │               │   └── Inventory.java
│       │   │               ├── http
│       │   │               │   └── response
│       │   │               │       └── ProductByIdProductResponse.java
│       │   │               ├── MsInvetarioApplication.java
│       │   │               ├── repository
│       │   │               │   └── InventoryRepository.java
│       │   │               └── service
│       │   │                   ├── InventoryServiceImpl.java
│       │   │                   └── InventoryService.java
│       │   └── resources
│       │       ├── application.properties
│       │       ├── import.sql
│       │       ├── static
│       │       └── templates
│       └── test
│           └── java
│               └── com
│                   └── app
│                       └── ms_invetario
│                           ├── controller
│                           │   └── InventoryControllerTest.java
│                           ├── MsInvetarioApplicationTests.java
│                           └── service
│                               └── InventoryServiceImplTest.java
├── ms-productos
│   ├── docker-compose.yaml
│   ├── Dockerfile
│   ├── HELP.md
│   ├── mvnw
│   ├── mvnw.cmd
│   ├── pom.xml
│   └── src
│       ├── main
│       │   ├── java
│       │   │   └── com
│       │   │       └── app
│       │   │           └── ms_productos
│       │   │               ├── config
│       │   │               │   └── SwaggerConfig.java
│       │   │               ├── controller
│       │   │               │   └── ProductController.java
│       │   │               ├── entity
│       │   │               │   └── Product.java
│       │   │               ├── MsProductosApplication.java
│       │   │               ├── repository
│       │   │               │   └── ProductRepository.java
│       │   │               └── service
│       │   │                   ├── ProductServiceImpl.java
│       │   │                   └── ProductService.java
│       │   └── resources
│       │       ├── application.properties
│       │       ├── import.sql
│       │       ├── static
│       │       └── templates
│       └── test
│           └── java
│               └── com
│                   └── app
│                       └── ms_productos
│                           ├── controller
│                           │   └── ProductControllerTest.java
│                           ├── MsProductosApplicationTests.java
│                           └── service
│                               └── ProductServiceImplTest.java
├── pom.xml
└── README.md

```
