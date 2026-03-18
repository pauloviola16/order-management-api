# Order Management API 📦

API REST desenvolvida com Java e Spring Boot para gerenciamento de pedidos.
Este projeto foi criado com o objetivo de praticar a construção de APIs backend organizadas, utilizando arquitetura em camadas e integração com banco de dados.

![Status](https://img.shields.io/badge/Status-Completo-brightgreen)
![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)
![Maven](https://img.shields.io/badge/Maven-3.8+-red)

## 🚀 Tecnologias

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven

## 📚 Funcionalidades

### 🔹 Gerenciamento de Pedidos

- Criação de pedidos
- Listagem de pedidos
- Busca de pedido por ID
- Atualização de dados
- Remoção de pedidos

## 🔗 Endpoints da API

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/orders` | Criar um novo pedido |
| GET | `/orders` | Listar todos os pedidos |
| GET | `/orders/{id}` | Buscar pedido por ID |
| PUT | `/orders/{id}` | Atualizar pedido |
| DELETE | `/orders/{id}` | Remover pedido |

## 📥 Exemplo de Requisição

### Criar pedido

```json
POST /orders

{
  "descricao": "Pedido de teste",
  "valor": 100.0
}
```

## 📂 Estrutura do Projeto

```
src/main/java/com/paulo/ordermanagementapi
├── controller
├── service
├── repository
├── entity
├��─ dto
└── exception
```

A aplicação segue uma arquitetura em camadas, separando responsabilidades entre API, regras de negócio e acesso a dados.

## 🎯 Objetivo do Projeto

Este projeto foi desenvolvido com o objetivo de praticar:

- Construção de APIs REST com Spring Boot
- Organização de projetos backend em arquitetura em camadas
- Integração com banco de dados usando JPA e Hibernate
- Implementação de CRUD completo

## 👨‍💻 Autor

**Paulo Viola** - [GitHub](https://github.com/pauloviola16)
