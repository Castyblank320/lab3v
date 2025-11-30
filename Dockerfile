# Usar la imagen base de OpenJDK
FROM openjdk:11-ea-19-jre-slim
  
  # Establecer el directorio de trabajo
WORKDIR /app
  
  # Copiar el archivo JAR generado por Spring Boot
COPY target/lab3v-0.0.1-SNAPSHOT.jar app.jar
  
  # Exponer el puerto de la aplicación
EXPOSE 8089
  
  # Ejecutar la aplicación con límites de memoria JVM
  # -Xmx384m: Máximo heap 384MB (75% de 512Mi límite del contenedor)
  # -Xms256m: Heap inicial 256MB
  # -XX:MaxMetaspaceSize=128m: Límite para Metaspace
ENTRYPOINT ["java", "-Xmx384m", "-Xms256m", "-XX:MaxMetaspaceSize=128m", "-jar", "app.jar"]