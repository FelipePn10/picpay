# Desafio Backend PicPay - Solução

Este projeto é uma solução para o Desafio Backend do PicPay, implementando uma API RESTful para transferências entre usuários e lojistas com todas as regras de negócio especificadas.

## 📌 Visão Geral

O projeto implementa os seguintes requisitos:
- Cadastro de carteiras (usuários e lojistas)
- Transferência de valores entre carteiras
- Validação de saldo e tipo de usuário
- Integração com serviço autorizador externo
- Notificação assíncrona ao recebedor
- Tratamento transacional das operações

## 🚀 Tecnologias Utilizadas

- **Spring Boot** - Framework para construção da API
- **Jakarta Persistence** - Mapeamento de entidades
- **MySQL** - Banco de dados (rodando em container Docker)
- **Spring Cloud OpenFeign** - Comunicação com APIs externas
- **CompletableFuture** - Processamento assíncrono
- **Hibernate Validator** - Validação de dados
- **Problem Details (RFC 7807)** - Tratamento de exceções
- **Log4J** - Logging da aplicação

## 🔧 Pré-requisitos

- Java 17+
- Docker
- Maven

## 🛠️ Configuração e Execução

1. **Banco de dados MySQL via Docker:**
   ```bash
   docker run --name picpay-mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=picpay -p 3306:3306 -d mysql:8.0
   ```

2. **Configuração da aplicação:**
    - Crie um arquivo `application.properties` ou `application.yml` com as configurações do banco:
      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/picpay
      spring.datasource.username=root
      spring.datasource.password=root
      spring.jpa.hibernate.ddl-auto=update
      ```

3. **Build e execução:**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

## 📚 Endpoints

### POST /wallets
Cadastra uma nova carteira (usuário ou lojista)

**Request body:**
```json
{
  "fullName": "Nome Completo",
  "cpfCnpj": "12345678901",
  "email": "email@example.com",
  "password": "senha123",
  "type": "USER"
}
```

### POST /transfer
Realiza uma transferência entre carteiras

**Request body:**
```json
{
  "value": 100.50,
  "payer": 1,
  "payee": 2
}
```

## 🔄 Fluxo de Transferência

1. Valida se o pagador é usuário (lojistas não podem transferir)
2. Valida se o pagador tem saldo suficiente
3. Consulta serviço autorizador externo
4. Realiza a transferência (transação atômica)
5. Envia notificação ao recebedor (processamento assíncrono)

## 🗼 Arquitetura

O projeto segue uma arquitetura limpa com:
- Camada de **Controller** (exposição da API)
- Camada de **Service** (regras de negócio)
- Camada de **Repository** (acesso a dados)
- Integração com **serviços externos** (autorizador e notificador)

## 🎯 Desafio Original

Consulte o desafio original no repositório do PicPay:
[https://github.com/PicPay/picpay-desafio-backend](https://github.com/PicPay/picpay-desafio-backend)
