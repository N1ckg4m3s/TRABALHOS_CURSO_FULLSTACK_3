-- CRIAR TABELA USUARIOS
CREATE TABLE Usuario (
	idUsuario INTEGER NOT NULL,
	login VARCHAR(255) NULL,
	senha VARCHAR(255) NULL,
	PRIMARY KEY(idUsuario)
);
-- CRIAR TABELA PRODUTO
CREATE TABLE Produto (
	idProduto INTEGER NOT NULL,
	Nome VARCHAR(255),
	Quantidade INTEGER,
	PrecoVenda NUMERIC,
	PRIMARY KEY(idProduto)
);
-- CRIAR TABELA PESSOA_CPF/CNPJ
CREATE TABLE Pessoa (
	idPessoa INTEGER NOT NULL,
	Nome VARCHAR(255) NULL,
	LograDouro VARCHAR(255) NULL,
	Cidade VARCHAR(255) NULL,
	Estado CHAR(2) NULL,
	Telefone VARCHAR(11) NULL,
	Email VARCHAR(255) NULL,
	Tipo_Pessoa CHAR(2) NOT NULL,
	Cpf VARCHAR(11) NULL,
	Cnpj VARCHAR(14) NULL,
	PRIMARY KEY(idPessoa)
);
--  CRIAR TABELA MOVIMENTAÇÃO
CREATE TABLE Movimentacao (
	idMovimentacao INTEGER NOT NULL,
	Usuario_idUsuario INTEGER NOT NULL,
	Pessoa_idPessoa INTEGER NOT NULL,
	Produto_idProduto INTEGER NOT NULL,
	Quantidade INTEGER NULL,
	ValorUnitario NUMERIC(10) NULL,
	Tipo CHAR(2) NULL,
	PRIMARY KEY(idMovimentacao),
	INDEX Movimentacao_FKIndex1(Produto_idProduto),
	INDEX Movimentacao_FKIndex2(Pessoa_idPessoa),
	INDEX Movimentacao_FKIndex3(Usuario_idUsuario)
);
