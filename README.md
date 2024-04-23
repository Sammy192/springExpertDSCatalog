# Projeto Final - Sistema DS Catalog
## Projeto JAVA Springboot JPA

![image](https://github.com/Sammy192/classProject_dsCommerce_v2_api/assets/53224915/b378f1d6-98f2-4e58-83a3-67587171c1b9)
![image](https://github.com/Sammy192/classProject_dsCommerce_v2_api/assets/53224915/4c049725-54c9-4793-8f96-151eea27443a)

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)


Esse repositório contém o projeto final desenvolvido para conclusão do treinamento Java Spring Expert, da plataforma Dev Superior.

Este projeto visa criar uma API RESTful de um sistema de catágolo de produtos usando tecnologias como
● Java 

● Spring Boot Framework

● Spring Security

● Bean Validation

● PostgresSQL como banco de dados

● JWT para controle de autenticação

● JUnit e Mockito para testes unitários e integrados

● JaCoCo para cobertura de testes.

# Visão geral do sistema

O sistema desenvolvido é uma aplicaćão completa de sistema de catálogo de produtos, abrangendo cadastro de usuários, produtos e categorias. Cada usuário, seja cliente ou administrador, tem sua própria área de interação com o sistema. O sistema permite a consulta de produtos, categorias, usuários e alteração de senha a partir de envio de email.

# Funcionalidades Principais

- Cadastro e autenticaćão de usuários com diferentes papéis (cliente, administrador).
- Catálogo de produtos com capacidade de filtragem por nome ou categoria.
- Área administrativa para gerenciamento de usuários, produtos e categorias.
- Recuperação de senha através de requisição e envio de email do sistema para o usuário.

## Collections Postman
Pode ser encontrado dentro de pasta específica aqui no repo.

# Github dos recursos para o DSCatalog
https://github.com/devsuperior/dscatalog-resources

# Figma do DSCatalog
https://www.figma.com/file/cNa2l3TqZXxbU6NBDPruNw/BDS-DSCatalog

# Modelo conceitual do DSCatalog

![image](https://github.com/Sammy192/springExpertDSCatalog/assets/53224915/87907507-d4f5-4619-a979-2ef8210c822d)



```
POST /oauth2/token - Autenticação na API.

POST /auth/recover-token - Retorna token para recuperação de senha; envio de email com endereço de recuperação de senha.

PUT /auth/new-password - Atualiza senha de usuário (requer Token válido).

GET /users - Retorna lista de usuários (requer privilégio ADMIN).

GET /users/{id} - Retorna usuário por id (requer privilégio ADMIN).

POST /users - Cadastra usuário com privilégio OPERATOR.

PUT /users - Atualiza dados do usuário (requer privilégio ADMIN).

DELETE /users/{id} - Deleta usuário por id (requer privilégio ADMIN).

GET /me - Retorna dados do usuário logado (requer login).

GET /categories - Retorna lista de categorias.

GET /categories/{id} - Retorna categoria por id.

POST /categories - Insere nova categoria (requer privilégio admin)

PUT /categories/{id} - Atualiza categoria por id (requer privilégio ADMIN).

DELETE /categories/{id} - Deleta categoria por id (requer privilégio ADMIN).

GET /products - Retorna lista de produtos.

GET /products/{id} - Retorna produto por id.

POST /products - Adiciona novo produto (requer privilégio ADMIN).

PUT /products/{id} - Atualiza produto por id (requer privilégio ADMIN).

DELETE /products/{id} - Deleta produto por id (requer privilégio ADMIN).

```

# Competências

●	Criar projeto Spring Boot

●	Criar monorepo Git

●	Organizar o projeto em camadas

○	Controlador REST

○	Serviço

○	Acesso a dados (Repository)

●	Criar entidades

●	Configurar perfil de teste do projeto

●	Seeding da base de dados

●	Criar web services REST

○	Parâmetros de rota @PathVariable

○	Parâmetros de requisição @RequestParam

○	Corpo de requisição @RequestBody

○	Resposta da requisição ResponseEntity<T>

●	Padrão DTO

●	CRUD completo

●	Tratamento de exceções

●	Postman (coleções, ambientes)

●	Dados de auditoria

●	Paginação de dados

●	Associações entre entidades (N-N)
