📝 User Task Manager API

API REST desarrollada en Java Spring Boot con MongoDB, que permite la gestión de usuarios y tareas.
Incluye autenticación con JWT, control de acceso por roles (USER / ADMIN) y soporte para Docker.

🚀 Características principales

CRUD de Usuarios y Tareas.

Relación entre usuarios y sus tareas.

Estados de tareas: PENDING, IN_PROGRESS, DONE.

Seguridad con JWT:

ROLE_USER → CRUD básico de sus tareas.

ROLE_ADMIN → administración completa, incluyendo eliminación de usuarios.

Integración con MongoDB.

Configuración con Docker y Docker Compose (API + MongoDB).

Probado con Postman.

📦 Requisitos previos

Docker Desktop
 instalado y corriendo.

(Opcional) MongoDB Compass
 para visualizar la base de datos.

(Opcional) Postman
 para probar los endpoints.

⚙️ Cómo ejecutar el proyecto
1. Clonar el repositorio
git clone https://github.com/gallard00/user-task-manager.git
cd user-task-manager

2. Generar el .jar
mvn clean package -DskipTests

3. Levantar con Docker
docker-compose up --build


Esto levantará:

API → http://localhost:8080

MongoDB → mongodb://localhost:27017/user_task_db

🔑 Endpoints principales
Autenticación

POST /api/auth/register → registrar usuario.

POST /api/auth/login → login, devuelve JWT.

Usuarios

GET /api/users → listar usuarios (solo admin).

DELETE /api/users/{id} → eliminar usuario (solo admin).

Tareas

POST /api/tasks → crear tarea.

GET /api/tasks → listar tareas.

PATCH /api/tasks/{id}/status → cambiar estado (PENDING, IN_PROGRESS, DONE).

🔒 Seguridad con JWT

Todos los endpoints (excepto register y login) requieren autenticación.
Debes incluir en Postman el header:

Authorization: Bearer <tu_token_jwt>

📊 Base de datos

La app usa MongoDB con estas colecciones:

users → usuarios registrados.

tasks → tareas con estados y relación a usuarios.

🐳 Docker

Contenedores definidos en docker-compose.yml:

app → Spring Boot API

mongo → base de datos MongoDB con volumen persistente

Comandos útiles:

docker ps                  # listar contenedores activos
docker logs -f app         # ver logs de la API
docker exec -it mongo mongosh   # entrar a Mongo
docker-compose down        # apagar todo

📌 Próximos pasos

Documentación automática con Swagger/OpenAPI.

Tests automatizados con JUnit + Mockito.

Deploy en la nube (AWS / Render / Railway).
