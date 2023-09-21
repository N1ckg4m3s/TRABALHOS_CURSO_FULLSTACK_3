/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import cadastro.model.util.ConectorBD;
import controller.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Produto;

/**
 *
 * @author nicoa
 */
public class ProdutoJpaController implements Serializable {

    public ProdutoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public ProdutoJpaController() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Produto produto) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(produto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produto produto;
            try {
                produto = em.getReference(Produto.class, id);
                produto.getIdProduto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The produto with id " + id + " no longer exists.", enfe);
            }
            em.remove(produto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Produto> findProdutoEntities() {
        return findProdutoEntities(true, -1, -1);
    }

    public List<Produto> findProdutoEntities(int maxResults, int firstResult) {
        return findProdutoEntities(false, maxResults, firstResult);
    }

    private List<Produto> findProdutoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Produto.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public int getProdutoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Produto> rt = cq.from(Produto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    
    
    public void edit(Produto produto){
        try{
            Connection Conec=ConectorBD.getConnection();
            PreparedStatement ps = ConectorBD.getPrepared(Conec,"UPDATE Produto SET \n"+
                    "Quantidade=?, PrecoVenda=? WHERE idProduto=?");
            ps.setInt(1, produto.getQuantidade());
            ps.setFloat(2, produto.getPrecoVenda());
            ps.setInt(3, produto.getIdProduto());
            
            ps.executeUpdate();
            
            ConectorBD.close(ps);
            ConectorBD.close(Conec);
        }catch(Exception e){
            System.out.println("Exception  ProdutoJpaController.java, edit: " + e);
            
            //UPDATE
        }
    }
    
    public Produto findProduto(Integer id) {
        try {
            Connection Conec=ConectorBD.getConnection();
            PreparedStatement ps = ConectorBD.getPrepared(Conec,"SELECT * FROM Produto WHERE idProduto=?");
            ps.setInt(1, id);
            
            System.out.println("ID para encontrar o produto é "+id);
            
            ResultSet Result = ps.executeQuery();
            if(Result.next()){
                String Nome=Result.getString("Nome");
                int Quant=Result.getInt("Quantidade");
                float ValotUnit=Result.getFloat("PrecoVenda");
                return new Produto(id, Nome, Quant, ValotUnit);
            }
            ConectorBD.close(ps);
            ConectorBD.close(Conec);
        } catch(SQLException e) {
            System.out.println("Exception  ProdutoJpaController.java, findProduto: " + e);
        }
        return null;
    }
    
    public Object GetProdutos() {
        try{
            Connection Conec=ConectorBD.getConnection();
            PreparedStatement ps = ConectorBD.getPrepared(Conec,"SELECT * FROM Produto");
            ResultSet Result = ps.executeQuery();
            List<Produto> ListaProdutos=new ArrayList<>();
            while(Result.next()){
                Integer Id=Result.getInt("idProduto");
                String Nome=Result.getString("Nome");
                int Quant=Result.getInt("Quantidade");
                float Preco=Result.getFloat("PrecoVenda");
                ListaProdutos.add(new Produto(Id, Nome, Quant, Preco));
            }
            
            ConectorBD.close(ps);
            ConectorBD.close(Conec);
            
            return ListaProdutos;
        }catch(SQLException e){
            System.out.println("Exception  ProdutoJpaController.javam GetProdutos: " + e);
        }
        return null;

    }
    
}
