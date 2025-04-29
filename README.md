# Movies API

Este projeto é uma API REST para gerenciamento de filmes e seus gêneros, construída com Spring Boot, Kotlin e Java 21.

## Tecnologias Utilizadas

- Java 21
- Kotlin (kts)
- Spring Boot 3.5.0-SNAPSHOT
- Spring Data JPA
- Flyway (migração de banco de dados)
- MySQL
- Lombok

## Configuração do Projeto

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/vinnom/Movie_Catalog.git venturusflix
   cd venturusflix
   ```
2. ## Criação do Banco de Dados

Antes de rodar a aplicação, é necessário criar o banco de dados MySQL chamado `movies_database`. Siga as instruções
conforme seu sistema operacional:

- **Linux:** [Ubuntu](https://documentation.ubuntu.com/server/how-to/databases/install-mysql/index.html)
- **MacOS:** [Here](https://dev.mysql.com/doc/refman/8.4/en/macos-installation.html)
- **Windows:** [Here](https://dev.mysql.com/doc/refman/8.4/en/windows-installation.html)

Após instalar o MySQL, execute o comando abaixo para criar o banco:

```sql
CREATE DATABASE movies_database;
```
