<%-- 
    Document   : ProdutoLista
    Created on : 19 de set. de 2023, 01:56:53
    Author     : nicoa
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Produtos</title>
    </head>
    <body>
        <h1>Lista Produtos</h1>
        <a href="ServletProdutoFC?acao=formIncluir">Novo Produto</a>
        <table>
            <tr>
                <th>#</th>
                <th>Nome</th>
                <th>Quantidade</th>
                <th>Preço</th>
                <th>Ações</th>
            </tr>
            <c:forEach var="P" items="${ListaProdutos}">
                <tr>
                    <th>${P.getIdProduto()}</th>
                    <th>${P.getNome()}</th>
                    <th>${P.getQuantidade()}</th>
                    <th>${P.getPrecoVenda()}</th>
                    <td>
                        <!-- Link para abrir o formulário de alteração -->
                        <a href="ServletProdutoFC?acao=formAlterar&id=${P.getIdProduto()}">Alterar</a>

                        <!-- Link para excluir o produto -->
                        <a href="ServletProdutoFC?acao=excluir&id=${P.getIdProduto()}">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
