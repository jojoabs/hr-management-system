# Usa a imagem oficial do Maven para construir o projeto
FROM maven:3.8.5-openjdk-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Usa a imagem oficial do OpenJDK para execução
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/hr-management-system-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]
