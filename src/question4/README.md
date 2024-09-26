# Estrutura de Banco de Dados para Aplicativo de Cadastro de Clientes

Este projeto consiste em um modelo de banco de dados que armazena informações de clientes, seus telefones e o estado brasileiro onde cada cliente está localizado. O sistema permite que múltiplos telefones sejam associados a um cliente, que novos tipos de telefone sejam cadastrados, assim como novos estados brasileiros.

## Requisitos

- **Clientes** podem ter múltiplos **telefones**.
- Cada telefone tem um **tipo** (por exemplo: celular, comercial, residencial).
- Um **cliente** reside em um **estado** brasileiro, e novos estados podem ser cadastrados.

## Modelo Lógico de Banco de Dados

O banco de dados contém as seguintes tabelas:

### 1. **Tabela Cliente**
- `id_cliente` (PK): Chave primária, identificador único do cliente.
- `razao_social`: Nome ou razão social do cliente.
- `id_estado` (FK): Chave estrangeira que faz referência ao estado onde o cliente está localizado.

### 2. **Tabela Telefone**
- `id_telefone` (PK): Chave primária, identificador único do telefone.
- `numero`: Número de telefone do cliente.
- `id_cliente` (FK): Chave estrangeira que faz referência ao cliente.
- `id_tipo_telefone` (FK): Chave estrangeira que faz referência ao tipo de telefone.

### 3. **Tabela Tipo_Telefone**
- `id_tipo_telefone` (PK): Chave primária, identificador único do tipo de telefone.
- `descricao`: Descrição do tipo de telefone (ex: celular, comercial, residencial).

### 4. **Tabela Estado**
- `id_estado` (PK): Chave primária, identificador único do estado.
- `sigla`: Sigla do estado (ex: SP, RJ, MG, etc.).
- `nome`: Nome completo do estado (ex: São Paulo, Rio de Janeiro, Minas Gerais).

## Diagrama Relacional

Aqui está o diagrama das tabelas com as respectivas chaves primárias (PK) e chaves estrangeiras (FK):

```
Cliente
--------
id_cliente (PK)
razao_social
id_estado (FK) ----> Estado(id_estado)

Telefone
--------
id_telefone (PK)
numero
id_cliente (FK) ----> Cliente(id_cliente)
id_tipo_telefone (FK) ----> Tipo_Telefone(id_tipo_telefone)

Tipo_Telefone
-------------
id_tipo_telefone (PK)
descricao

Estado
------
id_estado (PK)
sigla
nome
```

## Relacionamentos
- Um **cliente** pode ter vários **telefones**. Portanto, existe uma relação de **1 para N** entre `Cliente` e `Telefone`.
- Cada **telefone** tem um **tipo**, estabelecendo uma relação de **1 para N** entre `Tipo_Telefone` e `Telefone`.
- Um **cliente** está associado a um **estado** brasileiro, com uma relação de **1 para N** entre `Estado` e `Cliente`.

## Exemplo de Busca SQL

Para buscar o código do cliente, razão social e os telefones de todos os clientes do estado de São Paulo (sigla “SP”), o comando SQL a ser utilizado é o seguinte:

```sql
SELECT 
    c.id_cliente, 
    c.razao_social, 
    t.numero 
FROM 
    Cliente c
JOIN 
    Estado e ON c.id_estado = e.id_estado
JOIN 
    Telefone t ON c.id_cliente = t.id_cliente
WHERE 
    e.sigla = 'SP';
```

## Observações

1. O banco de dados permite a adição de novos tipos de telefone e estados, possibilitando a expansão conforme necessário.
2. A estrutura é otimizada para permitir a associação de múltiplos telefones a um único cliente, garantindo a flexibilidade no armazenamento dos dados.
