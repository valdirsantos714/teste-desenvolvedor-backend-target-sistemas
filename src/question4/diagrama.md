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
