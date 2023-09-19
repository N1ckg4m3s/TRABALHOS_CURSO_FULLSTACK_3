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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
    <body class="container">
        <h1>Lista Produtos</h1>
        <a class="btn btn-primary m-2" href="ServletProdutoFC?acao=formIncluir">Novo Produto</a>
        <table class="table table-striped">
            <thead class="table-dark">
                <tr>
                    <th>#</th>
                    <th>Nome</th>
                    <th>Quantidade</th>
                    <th>Preço</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <c:forEach var="P" items="${ListaProdutos}">
                <tr>
                    <th>${P.getIdProduto()}</th>
                    <th>${P.getNome()}</th>
                    <th>${P.getQuantidade()}</th>
                    <th>${P.getPrecoVenda()}</th>
                    <td>
                        <!-- Link para abrir o formulário de alteração -->
                        <a class="btn btn-primary btn-sm" href="ServletProdutoFC?acao=formAlterar&id=${P.getIdProduto()}">Alterar</a>

                        <!-- Link para excluir o produto -->
                        <a class="btn btn-danger btn-sm" href="ServletProdutoFC?acao=excluir&id=${P.getIdProduto()}">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
