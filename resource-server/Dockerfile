# Etapa 1: Build da aplicação
FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

# Copia os arquivos de configuração e dependências primeiro (melhor uso de cache)
COPY pom.xml .
COPY src ./src

# Compila o projeto
RUN mvn clean package -DskipTests

# Etapa 2: Imagem final com JDK leve
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copia o jar da etapa de build
COPY --from=builder /app/target/*.jar app.jar

# Expõe a porta do Spring Boot (ajuste conforme sua config)
EXPOSE 9000

# Comando para iniciar o app
ENTRYPOINT ["java", "-jar", "app.jar"]
