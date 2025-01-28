# Usar uma imagem base do Java
FROM openjdk:17-jdk-slim

# Criar diretório de trabalho
WORKDIR /app

# Copiar o arquivo JAR gerado
COPY target/hr-management-system-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta da aplicação
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
