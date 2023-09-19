/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cadastroee.servlets;

import cadastroee.controller.ProdutoFacadeLocal;
import cadastroee.model.Produto;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author nicoa
 */
public class ServletProdutoFC extends HttpServlet {
    
    @EJB
    ProdutoFacadeLocal facade;
    int id;
    String nome,Quant;
    Float Preco;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Acao=request.getParameter("acao");
        String Destino=""; 
         
        switch(Acao){
            case "listar":
                List<Produto> lista=facade.ListaProdutos();
                request.setAttribute("ListaProdutos",lista);
                Destino="ProdutoLista.jsp";
                break;
            case "incluir": 
                nome=request.getParameter("nome");
                Quant=request.getParameter("Quant");
                Preco=Float.valueOf(request.getParameter("Preco"));
                
                facade.Incluir(nome,Quant,Preco);
                
                Destino="ProdutoLista.jsp";
                break;
            case "alterar":
                id=Integer.parseInt(request.getParameter("id"));
                nome=request.getParameter("nome");
                Quant=request.getParameter("Quant");
                Preco=Float.valueOf(request.getParameter("Preco"));
                
                facade.Alterar(id,nome,Quant,Preco);
                request.setAttribute("ListaProdutos", facade.ListaProdutos());
                
                Destino="ProdutoLista.jsp";
                break;
            case "excluir":
                id=Integer.parseInt(request.getParameter("id"));
                
                facade.Excluir(id);
                request.setAttribute("ListaProdutos", facade.ListaProdutos());
                
                Destino="ProdutoLista.jsp";
                break;
            case "formIncluir":
                
                Destino="ProdutoDados.jsp";
                break;
            case "formAlterar":
                id=Integer.parseInt(request.getParameter("id"));
                Produto P=facade.GetProduto(id);
                
                request.setAttribute("Produto",P);
                
                Destino="ProdutoDados.jsp";
                break;
            default:
                break;
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(Destino);
        dispatcher.forward(request, response);
        
    } 
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
