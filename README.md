# 🛡️ REST API Auth - Spring Boot 3 + JWT + MariaDB

![Java](https://img.shields.io/badge/Java-23-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.6-brightgreen)
![JWT](https://img.shields.io/badge/Security-JWT-blue)
![Database](https://img.shields.io/badge/Database-MariaDB-lightblue)
![License](https://img.shields.io/badge/license-MIT-yellow)
![Status](https://img.shields.io/badge/status-Active-success)

---

## 📖 Descripción

Este proyecto es una **API REST de autenticación** desarrollada con **Spring Boot 3**, **Spring Security 6** y **JWT (JSON Web Tokens)**.  
Permite el registro, login y autenticación de usuarios, gestionando roles y tokens de acceso.  
Ideal como base para proyectos que necesiten seguridad y control de usuarios.

---

## ⚙️ Tecnologías utilizadas

- ☕ **Java 23 (Valhalla EA)**
- 🌱 **Spring Boot 3.5.6**
- 🔐 **Spring Security 6.5.5**
- 💾 **JPA / Hibernate**
- 🧩 **MariaDB**
- 🧰 **Lombok**
- 📘 **Swagger / OpenAPI**
- 🧪 **Postman (para testing de endpoints)**

---

## 📂 Estructura del proyecto

src/
├── config/ # Configuración de seguridad
├── controller/ # Controladores REST
├── dto/ # Objetos de transferencia (Request/Response)
├── exception/ # Manejo global de errores
├── mapper/ # Conversión entre entidades y DTOs
├── model/ # Entidades JPA
├── repository/ # Interfaces de persistencia
├── security/
│ ├── jwt/ # Filtros y utilidades JWT
│ └── user/ # Implementación de UserDetails
├── service/ # Interfaces de lógica de negocio
├── service/impl/ # Implementaciones de servicios
└── RestApiAuthApplication # Clase principal

---

## 🚀 Cómo ejecutar el proyecto

### 1️⃣ Clonar el repositorio
```bash
git clone https://github.com/gallard00/rest-api-auth.git
cd rest-api-auth
2️⃣ Configurar la base de datos
Editar el archivo src/main/resources/application.properties:

properties
spring.datasource.url=jdbc:mariadb://localhost:3306/rest_api_auth
spring.datasource.username=root
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# JWT
jwt.secret=secret_key_123456
jwt.expiration=86400000
3️⃣ Ejecutar la aplicación
bash
Copiar código
./mvnw spring-boot:run
La API correrá en:
👉 http://localhost:8080

🔐 Endpoints principales
🔸 Autenticación
Método	Endpoint	Descripción
POST	/api/auth/register	Registra un nuevo usuario
POST	/api/auth/login	Inicia sesión y devuelve el token JWT

🔸 Usuarios (Requiere token)
Método	Endpoint	Descripción
GET	/api/users	Obtiene todos los usuarios
GET	/api/users/{id}	Obtiene un usuario por ID
POST	/api/users	Crea un nuevo usuario
PUT	/api/users/{id}	Actualiza un usuario
DELETE	/api/users/{id}	Elimina un usuario

🧩 Ejemplo de uso con Postman
1️⃣ Registro
json
Copiar código
POST http://localhost:8080/api/auth/register
{
  "name": "Nahuel",
  "lastName": "Gallardo",
  "email": "nahuel@test.com",
  "password": "123456",
  "role": "ROLE_USER"
}
2️⃣ Login
json
Copiar código
POST http://localhost:8080/api/auth/login
{
  "email": "nahuel@test.com",
  "password": "123456"
}
🔁 Respuesta:

json
Copiar código
{
  "token": "eyJhbGciOiJIUzI1NiIs..."
}
3️⃣ Acceso a endpoints protegidos
Agregar en el header:


Authorization: Bearer <token>
🧱 Base de datos
Campo	Tipo	Descripción
id	BIGINT	ID autogenerado
email	VARCHAR	Correo único
name	VARCHAR	Nombre
last_name	VARCHAR	Apellido
password	VARCHAR	Contraseña cifrada
role	VARCHAR	Rol del usuario

🧑‍💻 Autor
Nahuel Gallardo
💼 Analista en Programación y Desarrollo de Aplicaciones
🔗 https://www.linkedin.com/in/nahuelgallard00/
🐙 [GitHub](https://github.com/gallard00)

🪪 Licencia
Este proyecto está bajo la licencia MIT — podés usarlo, modificarlo y distribuirlo libremente.

r
Copiar código
Copyright (c) 2025 Nahuel Gallardo
🌟 Inspiración
Este proyecto forma parte de mi portfolio profesional y está pensado como base sólida para sistemas de autenticación y gestión de usuarios con Spring Boot + JWT.
