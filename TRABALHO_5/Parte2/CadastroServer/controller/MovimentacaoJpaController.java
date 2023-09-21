/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import cadastro.model.util.ConectorBD;
import controller.exceptions.NonexistentEntityException;
import controller.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Movimentacao;

/**
 *
 * @author nicoa
 */
public class MovimentacaoJpaController implements Serializable {
    
    public MovimentacaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Movimentacao movimentacao) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(movimentacao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMovimentacao(movimentacao.getIdMovimentacao()) != null) {
                throw new PreexistingEntityException("Movimentacao " + movimentacao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Movimentacao movimentacao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            movimentacao = em.merge(movimentacao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = movimentacao.getIdMovimentacao();
                if (findMovimentacao(id) == null) {
                    throw new NonexistentEntityException("The movimentacao with id " + id + " no longer exists.");
                }
            }
            throw ex;
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
            Movimentacao movimentacao;
            try {
                movimentacao = em.getReference(Movimentacao.class, id);
                movimentacao.getIdMovimentacao();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The movimentacao with id " + id + " no longer exists.", enfe);
            }
            em.remove(movimentacao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Movimentacao> findMovimentacaoEntities() {
        return findMovimentacaoEntities(true, -1, -1);
    }

    public List<Movimentacao> findMovimentacaoEntities(int maxResults, int firstResult) {
        return findMovimentacaoEntities(false, maxResults, firstResult);
    }

    private List<Movimentacao> findMovimentacaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Movimentacao.class));
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

    public Movimentacao findMovimentacao(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Movimentacao.class, id);
        } finally {
            em.close();
        }
    }

    public int getMovimentacaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Movimentacao> rt = cq.from(Movimentacao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    
    public void Persistir(Movimentacao Mov) {
        try{
            Connection Conec=ConectorBD.getConnection();
            PreparedStatement ps = ConectorBD.getPrepared(Conec,"INSERT INTO Movimentacao VALUES (?,?,?,?,?,?)");
            // Usuario_idUsuario, Pessoa_idPessoa, Produto_idProduto, Quantidade, Tipo, ValorUnitario
            
            ps.setInt(1, Mov.getUsuarioidUsuario());
            ps.setInt(2, Mov.getPessoaidPessoa());
            ps.setInt(3, Mov.getProdutoidProduto());
            ps.setInt(4, Mov.getQuantidade());
            ps.setString(5, Mov.getTipo());
            ps.setFloat(6, Mov.getValorUnitario());
            
            ConectorBD.close(ps);
            ConectorBD.close(Conec);
        }catch(Exception e){
        }
    }

    public List<Movimentacao> GetMovimentacoes() {
        try{
            Connection Conec=ConectorBD.getConnection();
            PreparedStatement ps = ConectorBD.getPrepared(Conec,"SELECT * FROM Movimentacao");
            ResultSet Result = ps.executeQuery();
            List<Movimentacao> ListaMovimentacoes=new ArrayList<>();
            while(Result.next()){
                
                Integer 
                        idMovimentacao=Result.getInt("idMovimentacao"),
                        quantidade=Result.getInt("Quantidade");
                
                int 
                        usuarioidUsuario=Result.getInt("Usuario_idUsuario"),
                        pessoaidPessoa=Result.getInt("Pessoa_idPessoa"),
                        produtoidProduto=Result.getInt("Produto_idProduto");
                
                float valorUnitario=Result.getFloat("ValorUnitario");
                
                String tipo=Result.getString("Tipo");
                
                ListaMovimentacoes.add(
                        new Movimentacao(
                            idMovimentacao,
                            usuarioidUsuario,
                            pessoaidPessoa,
                            produtoidProduto,
                            quantidade,
                            valorUnitario,
                            tipo
                        )
                );
            }
            ConectorBD.close(ps);
            ConectorBD.close(Conec);
            return ListaMovimentacoes;
        }catch(Exception e){
        }
        return null;
    }
    
}
