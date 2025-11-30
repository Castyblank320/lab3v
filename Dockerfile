# Usar la imagen base de OpenJDK
FROM openjdk:11-ea-19-jre-slim
  
  # Establecer el directorio de trabajo
WORKDIR /app
  
  # Copiar el archivo JAR generado por Spring Boot
COPY target/lab3v-0.0.1-SNAPSHOT.jar app.jar
  
  # Exponer el puerto de la aplicación
EXPOSE 8089
  
  # Ejecutar la aplicación con límites de memoria JVM
  # -Xmx320m: Máximo heap 320MB (deja ~190MB para metaspace, overhead, etc)
  # -Xms256m: Heap inicial 256MB
  # -XX:MaxMetaspaceSize=96m: Límite para Metaspace
ENTRYPOINT ["java", "-Xmx320m", "-Xms256m", "-XX:MaxMetaspaceSize=96m", "-jar", "app.jar"]