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
CREATE DATABASE movies_database CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER 'movieapi'@'localhost' IDENTIFIED BY 'movieapi';
GRANT ALL PRIVILEGES ON movies_database.* TO 'movieapi'@'localhost';
FLUSH PRIVILEGES;
```

Caso queira confirmar as info sobre o usuário "movieapi":
```sql
SHOW GRANTS FOR 'movieapi'@'localhost';
```
```plaintext
mysql> SHOW GRANTS FOR 'movieapi'@'localhost';
+-----------------------------------------------------------------------+
| Grants for movieapi@localhost                                         |
+-----------------------------------------------------------------------+
| GRANT USAGE ON *.* TO `movieapi`@`localhost`                          |
| GRANT ALL PRIVILEGES ON `movies_database`.* TO `movieapi`@`localhost` |
+-----------------------------------------------------------------------+
```

```markdown
# Documentação da API - Movies API

## Endpoints

### **1. Listar todos os filmes**

**GET** `/movies`

- **Descrição:** Retorna uma lista paginada de todos os filmes.
- **Parâmetros de Query (opcional):**
   - `page` (int): Número da página.
   - `size` (int): Tamanho da página.
   - `sort` (string): Campo para ordenação.
- **Resposta:**
   - **200 OK:** Lista de filmes no formato JSON.

---

### **2. Criar um novo filme**

**POST** `/movies`

- **Descrição:** Adiciona um novo filme ao banco de dados.
- **Corpo da Requisição (JSON):**
  ```json
  {
    "id": 1,
    "title": "Título do Filme",
    "maturityRating": "Livre",
    "genres": ["Ação", "Aventura"],
    "releaseDate": "2023-01-01",
    "duration": "2h",
    "posterImageUrl": "http://exemplo.com/poster.jpg"
  }
  ```

- **Resposta:**
   - **201 Created:** Filme criado com sucesso.

---

### **3. Criar múltiplos filmes (Batch)**

**POST** `/movies/batch`

- **Descrição:** Adiciona uma lista de filmes ao banco de dados.
- **Corpo da Requisição (JSON):**
  ```json
  [
    {
      "id": 1,
      "title": "Título do Filme 1",
      "maturityRating": "Livre",
      "genres": ["Ação"],
      "releaseDate": "2023-01-01",
      "duration": "2h",
      "posterImageUrl": "http://exemplo.com/poster1.jpg"
    },
    {
      "id": 2,
      "title": "Título do Filme 2",
      "maturityRating": "12+",
      "genres": ["Drama"],
      "releaseDate": "2023-02-01",
      "duration": "1h 30min",
      "posterImageUrl": "http://exemplo.com/poster2.jpg"
    }
  ]
  ```
- **Resposta:**
   - **201 Created:** Filmes criados com sucesso.

---

### **4. Atualizar um filme**

**PUT** `/movies`

- **Descrição:** Atualiza os dados de um filme existente.
- **Corpo da Requisição (JSON):**
  ```json
  {
    "id": 1,
    "title": "Novo Título",
    "maturityRating": "16+",
    "genres": ["Ação", "Suspense"],
    "releaseDate": "2023-05-01",
    "duration": "2h 15min",
    "posterImageUrl": "http://exemplo.com/novo-poster.jpg"
  }
  ```
- **Resposta:**
   - **200 OK:** Filme atualizado com sucesso.

---

### **5. Deletar um filme**

**DELETE** `/movies/{id}`

- **Descrição:** Remove um filme do banco de dados.
- **Parâmetros de URL:**
   - `id` (Long): ID do filme a ser deletado.
- **Resposta:**
   - **204 No Content:** Filme deletado com sucesso.

---

### **6. Endpoint de teste**

**GET** `/hello`

- **Descrição:** Retorna uma mensagem de teste.
- **Resposta:**
   - **200 OK:** `"Hello, Fwk General Colleague =D"`

```