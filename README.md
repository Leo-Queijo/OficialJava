# 📦 Projeto E-commerce — Módulo Carrinho de Compras

## 📌 Descrição

Este projeto tem como objetivo implementar um módulo de carrinho de compras utilizando Java com integração ao banco de dados Oracle.

Foram aplicados conceitos de:

* JDBC
* DAO (Data Access Object)
* Singleton
* Estrutura em camadas

---


## 🗄️ Banco de Dados (Oracle)

### Tabela PRODUTO

```sql
CREATE TABLE PRODUTO(
    ID NUMBER(2),
    NOME VARCHAR2(100),
    VALOR NUMBER(10,2)
);
```

### Tabela CUPOM

```sql
CREATE TABLE CUPOM(
    CODIGO VARCHAR2(50),
    VALOR_DESCONTO NUMBER(10,2)
);
```

### Inserts de teste

```sql
INSERT INTO PRODUTO (ID, NOME, VALOR) VALUES (1, 'Notebook', 3500.00);
INSERT INTO PRODUTO (ID, NOME, VALOR) VALUES (2, 'Mouse Gamer', 150.00);
INSERT INTO PRODUTO (ID, NOME, VALOR) VALUES (3, 'Teclado', 200.00);

INSERT INTO CUPOM (CODIGO, VALOR_DESCONTO) VALUES ('DESCONTO10', 10);
```

---

## 🔌 Configuração da Conexão

A conexão com o banco é feita na classe:

```
ConnectionFactory.java
```

Exemplo:

```java
DriverManager.getConnection(
    "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
    "SEU_USUARIO",
    "SUA_SENHA"
);
```

---

## ▶️ Como Executar o Projeto

### 1. Pré-requisitos

* Java JDK 8 ou superior
* Oracle Database
* Driver JDBC (`ojdbc8.jar`) adicionado ao projeto

---

### 2. Configurar o banco

* Criar as tabelas
* Inserir os dados de teste

---

### 3. Configurar a conexão

* Ajustar usuário e senha no `ConnectionFactory`

---

### 4. Executar o projeto

* Abrir o projeto na IDE (IntelliJ ou Eclipse)
* Executar a classe:

```
Main.java
```

---

## 🧪 Exemplo de execução

Ao rodar o sistema, será feita uma busca no banco de dados pelo cupom:

```
DESCONTO10
```

### Saída esperada:

```
Cupom: DESCONTO10
Desconto: 10.0
```

Também é possível testar produtos:

```
Produto: Notebook
Valor: 3500.0
```

---

## 🧠 Padrões Utilizados

### DAO (Data Access Object)

Responsável pelo acesso ao banco de dados:

* CupomDAO
* ProdutoDAO

---

### Singleton

Aplicado na classe `ConnectionFactory`, garantindo apenas uma conexão com o banco de dados.

---

## 👨‍💻 Autores

Enzo Galhardo - RM 561001 |
Leonardo Queijo - RM559842
