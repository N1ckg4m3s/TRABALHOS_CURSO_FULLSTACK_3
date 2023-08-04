-- NOMES TABELAS: Usuario, Produto, Pessoa, Movimentacao
-- CONSULTAS
-- 1.Dados completos de pessoas físicas.
SELECT * FROM Pessoa WHERE Tipo_Pessoa='F';

-- 2.Dados completos de pessoas jurídicas.
SELECT * FROM Pessoa WHERE Tipo_Pessoa='J';

-- 3.Movimentações de entrada, Produto, Fornecedor, Quantidade, Preço unitário, Valor total.
SELECT idMovimentacao, P.Nome As Produto,
	F.Nome AS Fornecedor, M.Quantidade, M.ValorUnitario, 
	(M.Quantidade * M.ValorUnitario) AS Total
	FROM Movimentacao M
	JOIN Produto P ON M.Produto_idProduto = P.idProduto
	JOIN Pessoa F ON M.Pessoa_idPessoa = F.idPessoa
WHERE M.Tipo = 'E'

-- 4.Movimentações de saída, com produto, comprador, quantidade, preço unitário e valor total
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

-- 6.Valor total das saídas agrupadas por produto.
SELECT P.Nome AS Produto,SUM(M.Quantidade * M.ValorUnitario) AS Total
FROM Movimentacao M
JOIN Produto P ON M.Produto_idProduto = P.idProduto
WHERE M.Tipo = 'S' GROUP BY P.Nome

-- 7.Operadores que não efetuaram movimentações de entrada (compra).
SELECT U.login AS NÃO_COMPROU
FROM Usuario U
	LEFT JOIN Movimentacao M ON U.idUsuario = M.Usuario_idUsuario AND M.Tipo = 'E'
WHERE M.idMovimentacao IS NULL;

-- 8.Valor total de entrada, agrupado por operador.
SELECT U.login AS Operador ,SUM(M.Quantidade * M.ValorUnitario) AS Total
FROM Usuario U
JOIN Movimentacao M ON U.idUsuario = M.Usuario_idUsuario
WHERE M.Tipo = 'E'
GROUP BY U.login 

-- 9.Valor total de saída, agrupado por operador.
SELECT U.login AS Operador ,SUM(M.Quantidade * M.ValorUnitario) AS Total
FROM Usuario U
JOIN Movimentacao M ON U.idUsuario = M.Usuario_idUsuario
WHERE M.Tipo = 'S'
GROUP BY U.login 

-- 10.Valor médio de venda por produto, utilizando média ponderada.
SELECT P.Nome AS PRODUTO, SUM(M.Quantidade*M.ValorUnitario)/SUM(M.Quantidade) AS Media
FROM Movimentacao M
JOIN Produto P ON M.Produto_idProduto = P.idProduto
WHERE M.Tipo= 'S'
GROUP BY P.Nome