# Usa una imagen base de Maven con OpenJDK 17
FROM maven:3.8.4-openjdk-17 AS build

# Establece el directorio de trabajo
WORKDIR /usr/src/app

# Copia el código fuente y el archivo POM
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app

# Compila el proyecto
RUN mvn clean package

# Usa una imagen base de OpenJDK 17 con Ubuntu como runtime
FROM openjdk:17-jdk-slim AS runtime

# Copia el artefacto de construcción del stage de compilación al runtime
COPY --from=build /usr/src/app/target/libreria-0.0.1-SNAPSHOT.jar /usr/app/libreria-0.0.1-SNAPSHOT.jar

# Establece el comando por defecto para ejecutar la aplicación
CMD ["java", "-jar", "/usr/app/libreria-0.0.1-SNAPSHOT.jar"]
