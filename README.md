CRUD de Cadastro de Usuário

Este é um projeto simples de CRUD (Create, Read, Update, Delete) de cadastro de usuário desenvolvido em Java com Spring Boot, utilizando MySQL como banco de dados. A aplicação segue a arquitetura padrão do Spring Boot e é gerenciada via Docker Compose.

🚀 Tecnologias Utilizadas

    Java 21: Linguagem de programação.

    Spring Boot: Framework principal para construção da API.

    Spring Data JPA: Para abstração e persistência de dados.

    MySQL: Banco de dados relacional.

    Docker e Docker Compose: Para orquestrar a aplicação e o banco de dados.

🏗️ Arquitetura do Projeto

O projeto segue a estrutura padrão de camadas, garantindo uma boa organização e separação de responsabilidades:

    Controller: Responsável por lidar com as requisições HTTP e rotear as chamadas para a camada de serviço.

    Service: Contém a lógica de negócio da aplicação.

    Repository: Interage diretamente com o banco de dados, utilizando o Spring Data JPA.

    Entity: Representa a tabela User no banco de dados.

    DTO (Data Transfer Object): Usado para transferir dados entre as camadas, evitando expor a entidade diretamente.

⚙️ Como Rodar a Aplicação

Siga os passos abaixo para configurar e executar o projeto.

Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas na sua máquina:

    Java 21

    Maven

    DockerHub

1. Clonar o Repositório

Bash

git clone https://github.com/vcfernandes/Cadastro-de-Usuario
cd Cadastro-de-Usuario

2. Configurar o Banco de Dados com Docker

Este projeto utiliza o Docker Compose para subir o banco de dados MySQL. Basta executar o comando no diretório raiz do projeto:
Bash

docker-compose up 

Este comando irá criar e iniciar um contêiner MySQL em segundo plano, com as credenciais e configurações definidas no arquivo docker-compose.yml.

3. Rodar a Aplicação

Você pode iniciar a aplicação Spring Boot via IDE (IntelliJ, VS Code, etc.)

Abra o projeto na sua IDE e execute a classe CadastrousuarioApplication.java.

🧪 Endpoints da API

A API expõe os seguintes endpoints para a entidade de usuário:

    POST /v1/users: Cria um novo usuário.

    GET /v1/users/{id}: Busca um usuário pelo ID.

    PUT /v1/users/{id}: Atualiza os dados de um usuário.

    DELETE /v1/users/{id}: Remove um usuário.
