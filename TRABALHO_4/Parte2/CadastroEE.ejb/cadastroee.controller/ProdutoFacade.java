/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package cadastroee.controller;

import cadastro.model.util.ConectorBD;
import cadastroee.model.Produto;
import jakarta.ejb.Stateless;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nicoa
 */
@Stateless
public class ProdutoFacade implements ProdutoFacadeLocal {

    @Override
    public List<Produto> ListaProdutos() {
        List<Produto> Produtos = new ArrayList<>();
        try {
            Connection Conec = ConectorBD.getConnection();
            PreparedStatement ps = ConectorBD.getPrepared(Conec,"SELECT * FROM Produto");
            
            ResultSet Result = ps.executeQuery();
            while(Result.next()){
                Integer Id=Result.getInt("idProduto");
                String Nome=Result.getString("Nome");
                int Quant=Result.getInt("Quantidade");
                float Preco=Result.getFloat("PrecoVenda");
                Produtos.add(new Produto(Id, Nome, Quant, Preco));
            }
            ConectorBD.close(ps);
            ConectorBD.close(Conec);
            return Produtos;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Produto GetProduto(int id) {
        try {
            Connection Conec = ConectorBD.getConnection();
            PreparedStatement ps = ConectorBD.getPrepared(Conec,"SELECT * FROM Produto WHERE idProduto = ?");
            ps.setInt(1, id);
            ResultSet Result = ps.executeQuery();
            Produto P = null;
            if(Result.next()){
                Integer Id=Result.getInt("idProduto");
                String Nome=Result.getString("Nome");
                int Quant=Result.getInt("Quantidade");
                float Preco=Result.getFloat("PrecoVenda");
                P=new Produto(Id, Nome, Quant, Preco);
            }
            ConectorBD.close(ps);
            ConectorBD.close(Conec);
            return P;
        }catch(Exception e){}
        return null;
    }

    @Override
    public void Excluir(int id) {
        try{
            System.out.println("2");
            Connection Conec = ConectorBD.getConnection();
            PreparedStatement ps = ConectorBD.getPrepared(Conec,"DELETE FROM Produto WHERE idProduto = ?");
            ps.setInt(1, id);
            ps.executeQuery();
            ConectorBD.close(ps);
            ConectorBD.close(Conec);
        }catch(Exception e){
            System.out.println("exeção");
        }
    }

    @Override
    public void Alterar(int id, String nome, String Quant, Float Preco) {
        try{
            System.out.println("2");
            Connection Conec = ConectorBD.getConnection();
            PreparedStatement ps = ConectorBD.getPrepared(Conec,"UPDATE Produto SET \n"+
                    "Nome=?, Quantidade=?, PrecoVenda=? WHERE idProduto = ?");
            ps.setString(1, nome);
            ps.setString(2, Quant);
            ps.setFloat(3, Preco);
            ps.setInt(4, id);
            ps.executeQuery();
            
            ConectorBD.close(ps);
            ConectorBD.close(Conec);
        }catch(Exception e){
            System.out.println("exeção");
        }
    }
    
    
    @Override
    public void Incluir(String nome, String Quant, Float Preco) {
        System.out.println("1");
        try{
            System.out.println("2");
            Connection Conec = ConectorBD.getConnection();
            PreparedStatement ps = ConectorBD.getPrepared(Conec,"INSERT INTO Produto VALUES (?,?,?)");
            ps.setString(1, nome);
            ps.setString(2, Quant);
            ps.setFloat(3, Preco);
            ps.execute(); 
            System.out.println("4");
            ConectorBD.close(ps);
            ConectorBD.close(Conec);
        }catch(Exception e){
            System.out.println("exeção");
        }
    }
    
}