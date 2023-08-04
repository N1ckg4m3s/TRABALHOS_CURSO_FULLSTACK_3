-- NOMES TABELAS: Usuario, Produto, Pessoa, Movimentacao
-- CONSULTAS
-- 1.Dados completos de pessoas f�sicas.
SELECT * FROM Pessoa WHERE Tipo_Pessoa='F';

-- 2.Dados completos de pessoas jur�dicas.
SELECT * FROM Pessoa WHERE Tipo_Pessoa='J';

-- 3.Movimenta��es de entrada, Produto, Fornecedor, Quantidade, Pre�o unit�rio, Valor total.
SELECT idMovimentacao, P.Nome As Produto,
	F.Nome AS Fornecedor, M.Quantidade, M.ValorUnitario, 
	(M.Quantidade * M.ValorUnitario) AS Total
	FROM Movimentacao M
	JOIN Produto P ON M.Produto_idProduto = P.idProduto
	JOIN Pessoa F ON M.Pessoa_idPessoa = F.idPessoa
WHERE M.Tipo = 'E'

-- 4.Movimenta��es de sa�da, com produto, comprador, quantidade, pre�o unit�rio e valor total
SELECT idMovimentacao, P.Nome As Produto,
	F.Nome AS Fornecedor, M.Quantidade, M.ValorUnitario, 
	(M.Quantidade * M.ValorUnitario) AS Total
	FROM Movimentacao M
	JOIN Produto P ON M.Produto_idProduto = P.idProduto
	JOIN Pessoa F ON M.Pessoa_idPessoa = F.idPessoa
WHERE M.Tipo = 'S'

-- 5.Valor total das entradas agrupadas por produto.
SELECT P.Nome AS Produto,SUM(M.Quantidade * M.ValorUnitario) AS Total
FROM Movimentacao M
JOIN Produto P ON M.Produto_idProduto = P.idProduto
WHERE M.Tipo = 'E' GROUP BY P.Nome

-- 6.Valor total das sa�das agrupadas por produto.
SELECT P.Nome AS Produto,SUM(M.Quantidade * M.ValorUnitario) AS Total
FROM Movimentacao M
JOIN Produto P ON M.Produto_idProduto = P.idProduto
WHERE M.Tipo = 'S' GROUP BY P.Nome

-- 7.Operadores que n�o efetuaram movimenta��es de entrada (compra).
SELECT U.login AS N�O_COMPROU
FROM Usuario U
	LEFT JOIN Movimentacao M ON U.idUsuario = M.Usuario_idUsuario AND M.Tipo = 'E'
WHERE M.idMovimentacao IS NULL;

-- 8.Valor total de entrada, agrupado por operador.
SELECT U.login AS Operador ,SUM(M.Quantidade * M.ValorUnitario) AS Total
FROM Usuario U
JOIN Movimentacao M ON U.idUsuario = M.Usuario_idUsuario
WHERE M.Tipo = 'E'
GROUP BY U.login 

-- 9.Valor total de sa�da, agrupado por operador.
SELECT U.login AS Operador ,SUM(M.Quantidade * M.ValorUnitario) AS Total
FROM Usuario U
JOIN Movimentacao M ON U.idUsuario = M.Usuario_idUsuario
WHERE M.Tipo = 'S'
GROUP BY U.login 

-- 10.Valor m�dio de venda por produto, utilizando m�dia ponderada.
SELECT P.Nome AS PRODUTO, SUM(M.Quantidade*M.ValorUnitario)/SUM(M.Quantidade) AS Media
FROM Movimentacao M
JOIN Produto P ON M.Produto_idProduto = P.idProduto
WHERE M.Tipo= 'S'
GROUP BY P.Nome