# java-spring-authorization-server

Implementação de autenticação e autorização com OAuth2 e OpenID Connect usando Spring Security.

## Sobre o projeto

Este projeto é uma implementação prática baseada no [tutorial do YouTube](https://www.youtube.com/watch?v=hgLKOPHfuis&t=1s) e demonstra como configurar e integrar os principais componentes de segurança OAuth2 em uma aplicação Java com Spring Boot.

### Estrutura

- **auth-server**  
  Servidor de autorização OAuth2 com suporte a OpenID Connect, construído com `spring-boot-starter-oauth2-authorization-server`.

- **resource-server**  
  Servidor de recursos protegido, que valida tokens emitidos pelo `auth-server` utilizando `spring-boot-starter-oauth2-resource-server`.

- **client-server**  
  Aplicação cliente que realiza autenticação com o `auth-server` e consome recursos protegidos no `resource-server`.

## Requisitos

- Java 17+
- Docker e Docker Compose
- PostgreSQL (pode ser iniciado via Docker)

## Banco de dados

Este projeto utiliza PostgreSQL como base de dados. Para iniciar o banco localmente:

```bash
docker-compose -f docker-compose-dev.yaml up -d
```

## Executando os serviços

Para subir todos os serviços com Docker Compose:

```bash
docker-compose up --build
```

⚠️ Em ambientes locais, pode ser necessário configurar DNS ou editar o resolv.conf para garantir a resolução correta de nomes entre os containers (auth-server, client-server e resource-server).

