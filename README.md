# Sistema de Gerenciamento de Recursos Humanos (HR Management System)

Este projeto é um sistema simples de **Gerenciamento de Recursos Humanos** desenvolvido em **Spring Boot** e **MySQL**. Ele fornece operações básicas de CRUD para gerenciar funcionários e expõe endpoints para interação com o sistema.

---

## Funcionalidades

- Operações CRUD (Create, Read, Update, Delete) para funcionários.
- Paginação para recuperação de dados em partes.
- Integração com MySQL para persistência de dados.
- API RESTful.

---

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.4.2**
- **Spring Data JPA**
- **MySQL**
- **Lombok**
- **Postman/Insomnia** (para testar os endpoints da API)

---

## Instruções de Configuração

### Pré-requisitos

1. **Java 17** deve estar instalado.
2. Instale o **Maven** para compilar o projeto.
3. Configure um banco de dados **MySQL**.

### Configuração do Banco de Dados

1. Crie um banco de dados chamado `hr_management` no MySQL.
2. Atualize o arquivo `application.properties` com suas credenciais do MySQL:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/hr_management
   spring.datasource.username=SEU_USUARIO_MYSQL
   spring.datasource.password=SUA_SENHA_MYSQL
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
   ```

### Construção e Execução da Aplicação

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/hr-management-system.git
   cd hr-management-system
   ```
2. Compile o projeto usando Maven:
   ```bash
   mvn clean install
   ```
3. Execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```

---

## Endpoints da API

### URL Base
`http://localhost:8080/api/employee`

### Endpoints Disponíveis

1. **Listar Todos os Funcionários**
   - **URL:** `/`
   - **Método:** `GET`
   - **Resposta:** Lista de todos os funcionários.

2. **Obter Funcionário por ID**
   - **URL:** `/{id}`
   - **Método:** `GET`
   - **Variável de Caminho:** `id` (ID do Funcionário)
   - **Resposta:** Detalhes do funcionário.

3. **Criar Funcionário**
   - **URL:** `/`
   - **Método:** `POST`
   - **Corpo da Requisição:**
     ```json
     {
       "name": "João Silva",
       "department": "RH",
       "position": "Gerente",
       "salary": 7000.0
     }
     ```
   - **Resposta:** Detalhes do funcionário criado.

4. **Atualizar Funcionário**
   - **URL:** `/{id}`
   - **Método:** `PUT`
   - **Variável de Caminho:** `id` (ID do Funcionário)
   - **Corpo da Requisição:**
     ```json
     {
       "name": "Maria Oliveira",
       "department": "Financeiro",
       "position": "Analista",
       "salary": 8000.0
     }
     ```
   - **Resposta:** Detalhes do funcionário atualizado.

5. **Deletar Funcionário**
   - **URL:** `/{id}`
   - **Método:** `DELETE`
   - **Variável de Caminho:** `id` (ID do Funcionário)
   - **Resposta:** Sem conteúdo (204).

6. **Listar Funcionários com Paginação**
   - **URL:** `/paged`
   - **Método:** `GET`
   - **Parâmetros de Consulta:**
      - `page` (padrão: 0)
      - `size` (padrão: 10)
   - **Resposta:** Lista paginada de funcionários.

---

## Executando Testes

1. Para rodar os testes, execute o seguinte comando:
   ```bash
   mvn test
   ```
2. Certifique-se de verificar os logs no terminal para validar o sucesso dos testes.

---

## Melhorias Futuras

- Implementar autenticação e autorização com **Spring Security**.
- Adicionar documentação automática usando Swagger ou OpenAPI.
- Implementar testes de integração e testes de carga.
- Escalar o projeto para incluir múltiplos módulos, como gestão de departamentos ou folha de pagamento.

---

## Licença
Este projeto está licenciado sob a [Licença MIT](LICENSE).

Sinta-se à vontade para modificar e aprimorar o projeto conforme suas necessidades!
