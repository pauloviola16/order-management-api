# Order Management API 📦

API REST desenvolvida com Java e Spring Boot para gerenciamento de pedidos. Projeto backend construído com arquitetura em camadas, seguindo boas práticas de mercado, com foco em organização, escalabilidade e integração com banco de dados.

![Status](https://img.shields.io/badge/Status-Conclu%C3%ADdo-brightgreen)
![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)
![Maven](https://img.shields.io/badge/Maven-3.8+-red)
![Docker](https://img.shields.io/badge/Docker-2496ED?logo=docker&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-UI-85EA2D?logo=swagger&logoColor=black)

## 🚀 Tecnologias

### 🔹 Backend
- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate

### 🔹 Banco de Dados
- MySQL

### 🔹 Build Tool
- Maven

### 🔹 Containerização
- Docker

### 🔹 Documentação
- SpringDoc OpenAPI (Swagger UI)

## 📚 Funcionalidades

### 🔹 Gerenciamento de Pedidos
- Criação de pedidos
- Listagem de pedidos
- Busca de pedido por ID
- Atualização de dados
- Remoção de pedidos

### 🔹 Recursos adicionais
- Validação de dados de entrada
- Uso de DTO para comunicação entre camadas
- Tratamento de exceções personalizado
- Padronização de respostas da API

## 🔗 Endpoints da API

| Método | Endpoint | Descrição | Status |
|--------|----------|-----------|--------|
| POST | `/orders` | Criar um novo pedido | 201 Created |
| GET | `/orders` | Listar todos os pedidos | 200 OK |
| GET | `/orders/{id}` | Buscar pedido por ID | 200 OK |
| PUT | `/orders/{id}` | Atualizar pedido | 200 OK |
| DELETE | `/orders/{id}` | Remover pedido | 204 No Content |

## 📥 Exemplo de Requisição e Resposta

### 🔹 Criar Pedido

**POST /orders**

**Request:**
```json
{
  "customerName": "João Silva",
  "product": "Notebook",
  "quantity": 2,
  "price": 3500.00
}
```

**Response (201 Created):**
```json
{
  "id": 1,
  "customerName": "João Silva",
  "product": "Notebook",
  "quantity": 2,
  "totalPrice": 7000.00
}
```

## 📂 Estrutura do Projeto
```
src/main/java/com/paulo/ordermanagementapi
├── controller
├── service
├── repository
├── entity
├── dto
│   ├── request
│   └── response
└── exception
```

A aplicação segue uma arquitetura em camadas, separando responsabilidades entre API, regras de negócio e acesso a dados.

## 📖 Documentação

A API conta com documentação interativa gerada automaticamente pelo **SpringDoc OpenAPI**, permitindo visualizar e testar todos os endpoints diretamente pelo navegador.

Com a aplicação rodando, acesse:
```
http://localhost:8080/swagger-ui/index.html
```

> Caso a URL acima não funcione, tente: `http://localhost:8080/swagger-ui.html`

## ▶️ Como rodar o projeto

### 🐳 Com Docker
```bash
docker pull pauloviola16/spring-ordermanagement-api
```

🔗 [Ver imagem no Docker Hub](https://hub.docker.com/r/pauloviola16/spring-ordermanagement-api)

### 🔹 Sem Docker

Pré-requisitos: Java 17+, Maven e MySQL configurados localmente.
```bash
git clone https://github.com/pauloviola16/order-management-api.git
cd order-management-api
./mvnw spring-boot:run
```

A aplicação estará disponível em: http://localhost:8080

## 🎯 Objetivo do Projeto

Este projeto foi desenvolvido para demonstrar habilidades em desenvolvimento backend com Java e Spring Boot, incluindo:

- Construção de APIs RESTful
- Aplicação de arquitetura em camadas
- Uso de boas práticas (DTOs, validação, tratamento de exceções)
- Integração com banco de dados relacional (MySQL)
- Containerização com Docker
- Documentação com Swagger UI

## 👨‍💻 Autor

**Paulo Viola** - [GitHub](https://github.com/pauloviola16)
