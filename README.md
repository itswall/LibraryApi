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
   git clone https://github.com/username/LibraryApi.git
   ```
2. Navegue até a pasta do projeto:
   ```bash
   cd LibraryApi
   ```

## Pré-requisitos
- Java SDK
- MySQL
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
- JDK:  
  ```bash  
  sudo apt install openjdk-17-jdk
  ```  
  ou https://dev.mysql.com/downloads/installer/  
- BD:  
  ```bash  
  mysql -u root -p < librarydocs/sql/setup.sql
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
    - Execute o script em librarydocs/sql/setup.sql
      ```bash
      mysql -u root -p libraryapi < librarydocs/sql/setup.sql
      ```

 - Acesse o endpoint padrão ```localhost:8080```
 - Teste as rotas com o Postman.
    


