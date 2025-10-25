# 🚀 REST API Auth – Spring Boot + JWT + MongoDB

![Java](https://img.shields.io/badge/Java-23-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.6-brightgreen?logo=springboot)
![MongoDB](https://img.shields.io/badge/MongoDB-Atlas%20%7C%20Local-green?logo=mongodb)
![JWT](https://img.shields.io/badge/Security-JWT-blue?logo=jsonwebtokens)
![Maven](https://img.shields.io/badge/Build-Maven-8A2BE2?logo=apachemaven)
![License](https://img.shields.io/badge/license-MIT-lightgrey)
![Status](https://img.shields.io/badge/status-Active-success)

---

## 🧠 Descripción

**REST API Auth** es una API desarrollada en **Spring Boot** que implementa un sistema de autenticación y autorización basado en **JWT (JSON Web Tokens)**, con persistencia en **MongoDB**.

El proyecto permite registrar, autenticar y gestionar usuarios de manera segura, aplicando buenas prácticas de arquitectura, encriptación de contraseñas con **BCrypt** y manejo de roles (`ROLE_USER`, `ROLE_ADMIN`).

---

## 🧩 Tecnologías utilizadas

| Tecnología | Descripción |
|-------------|-------------|
| ☕ **Java 23** | Lenguaje principal del backend |
| 🌱 **Spring Boot 3.5.6** | Framework para la creación del backend REST |
| 🔐 **Spring Security + JWT** | Mecanismo de autenticación y autorización |
| 🍃 **MongoDB** | Base de datos NoSQL utilizada para la persistencia |
| ⚙️ **Maven** | Sistema de construcción y gestión de dependencias |
| 🧰 **Lombok** | Simplificación de código boilerplate |
| 📘 **Swagger / OpenAPI** | Documentación interactiva de la API |

---

## 📦 Estructura del proyecto

rest-api-auth/
├── config/ # Configuración de seguridad y beans
├── controller/ # Controladores REST (Auth, User)
├── dto/ # Clases DTO (Request y Response)
├── mapper/ # Conversión entre entidades y DTOs
├── model/ # Modelos de MongoDB (User, Role)
├── repository/ # Interfaces de persistencia
├── security/ # JWT, filtros y detalles de usuario
├── service/ # Interfaces de servicios
├── service/impl/ # Implementaciones de los servicios
├── resources/
│ └── application.properties # Configuración de entorno
└── RestApiAuthApplication.java # Clase principal



---

## ⚙️ Configuración de entorno

Asegurate de configurar tus credenciales de **MongoDB** en el archivo  
`src/main/resources/application.properties`:

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/rest_api_auth
spring.data.mongodb.database=rest_api_auth

jwt.secret=tu_secreto_seguro_aqui
jwt.expiration=86400000
server.port=8080

```


💡 Si usás MongoDB Atlas, reemplazá el mongodb://localhost:27017 por tu URI de conexión.

---

## 🔑 Endpoints principales
Método	Endpoint	Descripción	Autenticación
POST	/api/auth/register	Registrar nuevo usuario	❌ No requiere
POST	/api/auth/login	Iniciar sesión y obtener token JWT	❌ No requiere
GET	/api/users	Listar todos los usuarios	✅ Requiere token
GET	/api/users/{id}	Obtener usuario por ID	✅ Requiere token
DELETE	/api/users/{id}	Eliminar usuario	✅ Requiere token ADMIN

---

## 🧠 Ejemplo de uso en Postman
Registrar usuario

```
POST http://localhost:8080/api/auth/register

{
  "name": "Nahuel",
  "lastName": "Gallardo",
  "email": "nahuel@test.com",
  "password": "123456",
  "role": "ROLE_USER"
}
```
 Login
```

POST http://localhost:8080/api/auth/login
```
```
{
  "email": "nahuel@test.com",
  "password": "123456"
}
```
 Respuesta:
```

{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI..."
}

```
Acceso con token (Bearer)

En la pestaña Authorization → Type → Bearer Token

Pegá el token generado

---

## 🧪 Ejecución del proyecto
🔹 Opción 1 – Desde IntelliJ / IDE
Ejecutar la clase principal:
```

RestApiAuthApplication.java

```
🔹 Opción 2 – Desde consola
```
mvn spring-boot:run
```
---

##🧰 Dependencias principales (pom.xml)
```
<dependencies>
    <!-- Spring Boot Starter Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Spring Boot Starter Security -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>

    <!-- MongoDB -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-mongodb</artifactId>
    </dependency>

    <!-- JWT -->
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-api</artifactId>
        <version>0.11.5</version>
    </dependency>
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-impl</artifactId>
        <version>0.11.5</version>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-jackson</artifactId>
        <version>0.11.5</version>
        <scope>runtime</scope>
    </dependency>

    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>

    <!-- Swagger -->
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.6.0</version>
    </dependency>
</dependencies>
```
---
## 📄 Licencia
Este proyecto está bajo la licencia MIT.
Podés usarlo, modificarlo y distribuirlo libremente.
---
## 👨‍💻 Autor
Nahuel Gallardo
📍 Miramar, Buenos Aires
🔗 [LinkedIn](https://www.linkedin.com/in/nahuelgallard00/)
💻 [GitHub](https://github.com/gallard00)
---
Copyright (c) 2025 Nahuel Gallardo
--
## 🌟 Inspiración
Este proyecto forma parte de mi portfolio profesional y está pensado como base sólida para sistemas de autenticación y gestión de usuarios con Spring Boot + JWT.
