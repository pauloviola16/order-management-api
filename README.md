# 🧾 Order Management API

API REST desenvolvida com Java e Spring Boot para gerenciamento de pedidos, produtos e itens de pedido.

## 🚀 Tecnologias utilizadas

* Java 17+
* Spring Boot
* Spring Data JPA
* Hibernate
* Banco de dados relacional (MySQL ou H2)
* Lombok
* Maven

---

## 📌 Funcionalidades

* Cadastro de produtos
* Criação de pedidos com múltiplos itens
* Associação entre pedidos e produtos
* Cálculo automático do valor total do pedido
* Tratamento global de exceções
* Validação de dados de entrada

---

## 🧱 Estrutura do projeto

```
src/main/java/com/seuusuario/order_management_api
│
├── controller        # Camada de entrada (API REST)
├── service           # Regras de negócio
├── repository        # Acesso ao banco de dados
├── entity            # Entidades JPA
├── dto               # Objetos de transferência de dados
│   ├── request
│   └── response
└── exception         # Tratamento de erros
```

---

## 📥 Exemplo de requisição (Criar Pedido)

```json
{
  "customerId": 1,
  "items": [
    {
      "productId": 2,
      "quantity": 3
    }
  ]
}
```

---

## 📤 Exemplo de resposta

```json
{
  "id": 1,
  "customerId": 1,
  "items": [
    {
      "productName": "Mouse",
      "quantity": 3,
      "price": 50.0
    }
  ],
  "total": 150.0
}
```

---

## ⚠️ Tratamento de erros

A API possui tratamento global de exceções, retornando respostas padronizadas:

```json
{
  "status": 404,
  "message": "Produto não encontrado",
  "timestamp": "2026-01-01T10:00:00"
}
```

---

## ▶️ Como executar o projeto

1. Clone o repositório:

```
git clone https://github.com/seuusuario/order-management-api.git
```

2. Acesse a pasta do projeto:

```
cd order-management-api
```

3. Execute o projeto:

```
./mvnw spring-boot:run
```

---

## 🎯 Objetivo do projeto

Este projeto
