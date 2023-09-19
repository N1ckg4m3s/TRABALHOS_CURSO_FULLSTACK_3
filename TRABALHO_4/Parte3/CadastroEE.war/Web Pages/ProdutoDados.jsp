<%-- 
    Document   : ProdutoDados
    Created on : 19 de set. de 2023, 02:11:18
    Author     : nicoa
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Produto</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
    <body class="container">
        <h1>Novo Produto</h1>
        
        <form class="form" action="ServletProdutoFC" method="post">
            <input type="hidden" name="acao" value="${not empty Produto ? 'alterar' : 'incluir'}">
            <input type="hidden" name="id" value="${not empty Produto ? Produto.getIdProduto() : '0'}">
            
            <div class="mb-3">
                <label class="form-label" for="nome">Nome: </label>
                <input class="form-control" type="text" name="nome" value="${not empty Produto ? Produto.getNome() : '' }">
            </div>
            
            <div class="mb-3">
                <label class="form-label" for="Quant">Quantidade: </label>
                <input class="form-control" type="number" name="Quant" value="${not empty Produto ? Produto.getQuantidade() : '' }">
            </div>
            
            <div class="mb-3">
                <label class="form-label" for="Preco">Preço: </label>
                <input class="form-control" type="float" step="0.1" name="Preco" value="${not empty Produto ? Produto.getPrecoVenda() : '' }">
            </div>
            <input class="btn btn-primary" type="submit" value="${not empty Produto ? 'alterar' : 'incluir'}">
        </form>
    </body>
</html>
