# Usa imagem oficial do OpenJDK como base
FROM openjdk:17-jdk-alpine

LABEL author="Sebastian"

# Copia o jar da aplicação para dentro do container
COPY target/app.jar /app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Comando para rodar o jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
