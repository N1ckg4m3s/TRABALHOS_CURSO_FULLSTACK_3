-- INSERIR DADOS TESTE USUARIOS
INSERT INTO Usuario (idUsuario,login,senha)
VALUES
	(1,'op1','op1'),
	(2,'op2','op2');

-- INSERIR DADOS TESTE PRODUTO
INSERT INTO Produto (idProduto,Nome,Quantidade,PrecoVenda)
VALUES
	(1,'Banana',100,5.00),
	(3,'Laranja',500,2.00),
	(4,'Manga',800,4.00);

-- INSERIR DADOS TESTE PESSOA
-- CPF
INSERT INTO Pessoa (idPessoa, Nome, LograDouro, Cidade, Estado, Telefone, Email, Tipo_Pessoa, Cpf)
VALUES (7,'João','Rua 12 casa3. Quitanda','Riacho do Sul','PA','1111-1111','joao@riacho.com','F','11111111111');

--CNPJ
INSERT INTO Pessoa (idPessoa, Nome, LograDouro, Cidade, Estado, Telefone, Email, Tipo_Pessoa, Cnpj)
VALUEs (15,'JJC','Rua 11 Centro','Riacho do Norte','PA','1212-1212','jjc@riacho.com','J','22222222222222');

-- INSERIR DADOS TESTE MOVIMENTAÇÃO
INSERT INTO Movimentacao (idMovimentacao, Usuario_idUsuario, Pessoa_idPessoa, Produto_idProduto, Quantidade, Tipo, ValorUnitario)
VALUES
	(1,1,7,1,20,'S',4.00),
	(4,1,7,3,15,'S',2.00),
	(5,2,7,3,10,'S',3.00),
	(7,1,15,3,15,'E',5.00),
	(8,1,15,4,20,'E',4.00);
