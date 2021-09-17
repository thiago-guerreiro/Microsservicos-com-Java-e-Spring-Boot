# Microsserviços com Java e Spring Boot

Aplicação desenvolvida com Java e Spring Boot formada por três microsserviços com responsabilidades de gerenciar usuários, produtos e compras. Desenvolvido a partir do livro [Back-end Java Microsserviços, Spring Boot e Kubernetes](https://www.casadocodigo.com.br/products/livro-backend-java?_pos=1&_sid=9d3fc4fd2&_ss=r).

## Tecnologias Utilizadas:
- Java 11
- PostgreSQL
- Maven
- Spring Web
- Spring Data JPA
- Flyway Migration 

## Endpoints criados na User API:
- Listar todos os usuários: GET - localhost:8080/users
- Buscar usuário por CPF: GET - localhost:8080/user/cpf/{cpf}?key={key}
- Buscar usuário por nome: GET - localhost:8080/user/search?nome={nome}
- Salvar usuário: POST - localhost:8080/user
- Excluir usuário: DELETE - localhost:8080/user/{id}

## Endpoints criados na Product API:
- Listar todos os produtos: GET - localhost:8081/product
- Listar produtos por categoria: GET - localhost:8081/product/category/{categoryId}
- Buscar produto pelo Id: GET - localhost:8081/product/{productIdentifier}
- Salvar produto: POST - localhost:8081/product/
- Excluir produto: DELETE - localhost:8081/product/{id}

## Endpoints criados na Shopping API:
- Listas todas as compras: GET - localhost:8082/shopping
- Listar compras por usuário: GET - localhost:8082/shopping/shopByUser/{userIdentifier}
- Listar compras por data e valor: GET - localhost:8082/shopping/search?dataInicio={data}&dataFim={data}&valorMinino={valor}
- Relatório de compras por data: GET - localhost:8082/shopping/report?dataInicio={data}&dataFim={data}
- Salvar compras do usuário: POST - localhost:8082/shopping