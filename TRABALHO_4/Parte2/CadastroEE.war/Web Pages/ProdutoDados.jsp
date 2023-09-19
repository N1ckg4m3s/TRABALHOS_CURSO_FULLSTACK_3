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
    </head>
    <body>
        <h1>Novo Produto</h1>
        
        <form action="ServletProdutoFC" method="post">
            <input type="hidden" name="acao" value="${not empty Produto ? 'alterar' : 'incluir'}">
            <input type="hidden" name="id" value="${not empty Produto ? Produto.getIdProduto() : '0'}">
            
            <label for="nome">Nome: </label>
            <input type="text" name="nome" value="${not empty Produto ? Produto.getNome() : '' }">
            
            <label for="Quant">Quantidade: </label>
            <input type="number" name="Quant" value="${not empty Produto ? Produto.getQuantidade() : '' }">
            
            <label for="Preco">Preço: </label>
            <input type="float" step="0.1" name="Preco" value="${not empty Produto ? Produto.getPrecoVenda() : '' }">
            
            <input type="submit" value="${not empty Produto ? 'alterar' : 'incluir'}">
        </form>
    </body>
</html>
