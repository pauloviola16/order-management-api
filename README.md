# Order Management API 📦

API REST desenvolvida com Java e Spring Boot para gerenciamento de pedidos.
Projeto backend construído com arquitetura em camadas, seguindo boas práticas de mercado, com foco em organização, escalabilidade e integração com banco de dados.

![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow)
![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)
![Maven](https://img.shields.io/badge/Maven-3.8+-red)

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

## 📂 Estrutura do Projeto

```
src/main/java/com/paulo/ordermanagementapi
├── controller
├── service
├── repository
├── entity
├── dto
└── exception
```


A aplicação segue uma arquitetura em camadas, separando responsabilidades entre API, regras de negócio e acesso a dados.

## 🎯 Objetivo do Projeto

Este projeto foi desenvolvido com o objetivo de simular uma API backend utilizada em ambiente corporativo, aplicando boas práticas de desenvolvimento, como:

- Arquitetura em camadas
- Separação de responsabilidades
- Integração com banco de dados relacional
- Implementação de CRUD completo com boas práticas

## ▶️ Como rodar o projeto

### 🔹 Pré-requisitos
- Java 17+
- Maven
- MySQL

### 🔹 Passos

```bash
# Clonar o repositório
git clone https://github.com/pauloviola16/order-management-api.git

# Entrar na pasta
cd order-management-api

# Rodar o projeto
./mvnw spring-boot:run

## 👨‍💻 Autor

**Paulo Viola** - [GitHub](https://github.com/pauloviola16)
