# Imagen base con Java 17 (Spring Boot usa esto)
FROM eclipse-temurin:17-jdk-alpine

# Setear directorio de trabajo
WORKDIR /app

# Copiar el jar de la aplicación (lo vas a generar con mvn package)
COPY target/user-task-manager-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto de Spring Boot
EXPOSE 8080

# Comando para ejecutar
ENTRYPOINT ["java", "-jar", "app.jar"]
