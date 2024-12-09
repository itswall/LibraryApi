# Sistema de Gerenciamento de Biblioteca (LibraryApi)

Uma API RESTful para gerenciar livros em uma biblioteca, permitindo controle de usuários (leitores), livros e empréstimos.

## Índice
1. [Descrição do Projeto](#descrição-do-projeto)
2. [Como Baixar o Repositório](#como-baixar-o-repositório)
3. [Pré-requisitos](#pré-requisitos)
4. [Fluxo de Trabalho](#fluxo-de-trabalho)
5. [Ferramentas e Bibliotecas](#ferramentas-e-bibliotecas)
6. [Comandos de Instação](#comandos-de-instalação)

---

## Descrição do Projeto

O sistema permite:
- CRUD para livros: título, autor, gênero e ano de publicação.
- CRUD para usuários: nome, endereço, e-mail e telefone.
- Registro de empréstimos e devoluções de livros.
- Relatórios básicos: livros mais emprestados e usuários com empréstimos pendentes.

## Como Baixar o Repositório

1. Clone o repositório:
   ```bash
   git clone https://github.com/itswall/LibraryApi.git
   ```
2. Navegue até a pasta do projeto:
   ```bash
   cd LibraryApi
   ```

## Pré-requisitos
- Java SDK
- MySQL
- Maven
- VSCode ou outra IDE capaz de executar o projeto.  


## Fluxo de trabalho
1. Criação da branch:  
  ```bash
git checkout -b feature/nome
```

3. Commit e push:
```bash
   git add .
   git commit -m "descrição"
   git push
```

4. Merge:
```bash
    git checkout main
   git merge feature/nome
```

## Ferramentas e bibliotecas
- Frameworks: Spring Boot
- BDs: MySQL
- Libs: 
- IDEs: VSCode

## Comandos de Instalação
- MAVEN:

    https://maven.apache.org/download.cgi

- JDK:  
  ```bash  
  sudo apt install openjdk-17-jdk
  ```  
  ou https://dev.mysql.com/downloads/installer/
  
    - Inicie o servidor MySQL:  
      ```bash
      net start mysql
      ```   
    - Verifique a instação:  
      ```bash
      mysql -u root -p
      ```  
    - No MySQL, crie o Banco de Dados:  
      ```bash
      CREATE DATABASE libraryapi;
      ```

 - Acesse o endpoint padrão ```localhost:8080```
 - Teste as rotas com o Postman ou outro software de sua escolha.

## Como rodar o projeto
- Certifique-se de está no diretorio do projeto  **"*/library"** 

- Configure o username e password do banco de dados para ser o seu em **"*/library/src/main/java/resources/application.properties"**, coloque o mesmo username e password correspondente ao que você usa no seu ambiente MySQL. 

- Certifique-se que a sua versão do java seja a 17 ou maior. 


- No terminal, rode o comando "mvn spring-boot:run" ou rode o projeto com ajuda de alguma extensão da sua IDE. 

- A api irá rodar na porta 8080 para você fazer as requisições desejadas!
  
## Contributing
[Sabia como contribuir](https://github.com/itswall/LibraryApi/blob/main/CONTRIBUTING.md)

## Autores
<table align="center">
  <tr>
    <td align="center"><a href="https://github.com/aline-exe"><img src="https://github.com/user-attachments/assets/c733220b-f587-4124-84e8-15ad9fed238c" width="150px" alt="Aline"/><br /><sub><b>Aline</b></sub></a></td>
    <td align="center"><a href="https://github.com/itswall"><img src="https://github.com/user-attachments/assets/c9e3af2f-2b58-4a02-99d3-39b27d7ea0b0" width="150px" alt="Wallace"/><br /><sub><b>Wallace</b></sub></a></td>
    <td align="center"><a href="https://github.com/mariakarolina"><img src="https://github.com/user-attachments/assets/4f56f97c-63e9-462c-a47e-c512a9d4bba5" width="150px" alt="Maria"/><br /><sub><b>Maria</b></sub></a></td>
  </tr>
</table>


