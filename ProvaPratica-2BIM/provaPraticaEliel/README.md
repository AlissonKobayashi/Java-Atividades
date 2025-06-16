## 🧰 Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database (ou outro)
- JWT (`jjwt`)

---

## 📁 Estrutura do Projeto

src/

└── main/

    └── java/
    
        └── com/example/provaPraticaEliel/
        
            ├── usuario/
            
            │ ├── AuthController.java
            
            │ ├── AuthDTO.java
            
            │ ├── ModelUsuario.java
            
            │ ├── RepositoryUsuario.java
            
            │ └── JwtUtil.java
            
            ├── ControllerTarefa.java
            
            ├── EnumTarefa.java
            
            ├── ModelTarefa.java
            
            ├── RepositoryTarefa.java
            
            └── ServiceTarefa.java

            

### ✅ Endpoints de autenticação

Base: `http://localhost:8080/tarefa`

| Método | Rota                    | Descrição                  |
|--------|-------------------------|----------------------------|
| GET    | `/tarefa`               | Lista todas as tarefas     |
| GET    | `/tarefa/{id}`          | Busca uma tarefa por ID    |
| POST   | `/tarefa`               | Cria uma nova tarefa       |
| PUT    | `/tarefa/{id}`          | Atualiza uma tarefa        |
| DELETE | `/tarefa/{id}`          | Remove uma tarefa          |

### 🔸 Exemplo de corpo para POST/PUT:

{

  "titulo": "Estudar Spring",
  
  "descricao": "Revisar anotações de JWT",
  
  "status": "PENDENTE"
  
}


#### 📌 Registro

POST /auth/register

{

  "login": "admin",
  
  "senha": "admin123"
  
}

📌 Login

POST /auth/login

{

  "login": "admin",
  
  "senha": "admin123"
  
}


Resposta: Bearer eyJhbGciOiJIUzI1NiIsInR...

Copie a Resposta e em Headers cole o código em key


### ALUNO: ALISSON SEGURA KOBAYASHI 22210867-2
