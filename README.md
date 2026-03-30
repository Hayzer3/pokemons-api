# API Pokémon

Projeto desenvolvido para gerenciar treinadores, pokémons e times.

## Descrição

A API permite:

- Cadastrar treinadores
- Cadastrar pokémons
- Criar times com até 6 pokémons
- Relacionar pokémons a treinadores
- Listar dados organizados usando DTO

---


## Estrutura do projeto

- `model` → entidades (banco)
- `dto` → objetos de transferência (resposta da API)
- `repository` → acesso ao banco
- `service` → regras de negócio
- `controller` → endpoints da API

---

##  Endpoints principais

### Treinadores
- `GET /treinadores`
- `GET /treinadores/{id}`
- `POST /treinadores`
- `PUT /treinadores/{id}`
- `DELETE /treinadores/{id}`

### Pokémons
- `GET /pokemons`
- `GET /pokemons/{id}`
- `POST /pokemons`
- `PUT /pokemons/{id}`
- `DELETE /pokemons/{id}`

###  Times
- `GET /times`
- `GET /times/{id}`
- `POST /times`
- `PUT /times/{id}`
- `DELETE /times/{id}`

---

## Regras de negócio

- Um time pode ter no máximo 6 pokémons
- Pokémons devem estar associados a um treinador
- Uso de DTO para evitar loop infinito e melhorar o retorno da API

---

##  Testes

Os testes foram realizados utilizando o Postman, enviando requisições HTTP para todos os endpoints.

---

## Integrantes 

- Lucas Nunes Soares 
- Camily Vitoria Pereira Maciel
- Eduarda Weiss
2tdspx
