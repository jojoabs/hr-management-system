# Usa a imagem oficial do Maven para construir o projeto
FROM maven:3.9.0-eclipse-temurin-17 AS build
WORKDIR /app

# Copia os arquivos do projeto para o container
COPY . .

# Compila o projeto e gera o JAR
RUN mvn clean install

# Usa a imagem oficial do OpenJDK para execução
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copia o JAR gerado para a imagem final
COPY --from=build /app/target/hr-management-system-0.0.1-SNAPSHOT.jar app.jar

# Define o comando de execução da aplicação
CMD ["java", "-jar", "app.jar"]
