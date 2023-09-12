CREATE TABLE PessoaFisica(
	id INTEGER PRIMARY KEY NOT NULL,
	nome VARCHAR(255) NOT NULL,
	logradouro VARCHAR(255) NOT NULL,
	cidade VARCHAR(255) NOT NULL,
	estado VARCHAR(255) NOT NULL,
	telefone VARCHAR(11) NOT NULL,
	email VARCHAR(255) NOT NULL,
	cpf VARCHAR(255) NOT NULL,
)

CREATE TABLE PessoaJuridica(
	id INTEGER PRIMARY KEY NOT NULL,
	nome VARCHAR(255) NOT NULL,
	logradouro VARCHAR(255) NOT NULL,
	cidade VARCHAR(255) NOT NULL,
	estado VARCHAR(255) NOT NULL,
	telefone VARCHAR(11) NOT NULL,
	email VARCHAR(255) NOT NULL,
	cnpj VARCHAR(255) NOT NULL,
)
