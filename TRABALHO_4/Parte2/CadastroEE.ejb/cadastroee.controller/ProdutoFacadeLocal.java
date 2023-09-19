/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package cadastroee.controller;

import cadastroee.model.Produto;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author nicoa
 */
@Local
public interface ProdutoFacadeLocal {

    public List<Produto> ListaProdutos();

    public Produto GetProduto(int id);

    public void Excluir(int id);

    public void Alterar(int id, String nome, String Quant, Float Preco);

    public void Incluir(String nome, String Quant, Float Preco);
    
}
