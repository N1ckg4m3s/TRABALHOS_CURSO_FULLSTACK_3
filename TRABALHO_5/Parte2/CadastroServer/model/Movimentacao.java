/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroee.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nicoa
 */
@Entity
@Table(name = "Movimentacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimentacao.findAll", query = "SELECT m FROM Movimentacao m"),
    @NamedQuery(name = "Movimentacao.findByIdMovimentacao", query = "SELECT m FROM Movimentacao m WHERE m.idMovimentacao = :idMovimentacao"),
    @NamedQuery(name = "Movimentacao.findByUsuarioidUsuario", query = "SELECT m FROM Movimentacao m WHERE m.usuarioidUsuario = :usuarioidUsuario"),
    @NamedQuery(name = "Movimentacao.findByPessoaidPessoa", query = "SELECT m FROM Movimentacao m WHERE m.pessoaidPessoa = :pessoaidPessoa"),
    @NamedQuery(name = "Movimentacao.findByProdutoidProduto", query = "SELECT m FROM Movimentacao m WHERE m.produtoidProduto = :produtoidProduto"),
    @NamedQuery(name = "Movimentacao.findByQuantidade", query = "SELECT m FROM Movimentacao m WHERE m.quantidade = :quantidade"),
    @NamedQuery(name = "Movimentacao.findByValorUnitario", query = "SELECT m FROM Movimentacao m WHERE m.valorUnitario = :valorUnitario"),
    @NamedQuery(name = "Movimentacao.findByTipo", query = "SELECT m FROM Movimentacao m WHERE m.tipo = :tipo")})

public class Movimentacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idMovimentacao")
    private Integer idMovimentacao;
    @Basic(optional = false)
    @Column(name = "Usuario_idUsuario")
    private int usuarioidUsuario;
    @Basic(optional = false)
    @Column(name = "Pessoa_idPessoa")
    private int pessoaidPessoa;
    @Basic(optional = false)
    @Column(name = "Produto_idProduto")
    private int produtoidProduto;
    @Column(name = "Quantidade")
    private Integer quantidade;
    @Column(name = "ValorUnitario")
    private float valorUnitario;
    @Column(name = "Tipo")
    private String tipo;

    public Movimentacao() {
    }

    public Movimentacao(Integer idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    public Movimentacao(Integer idMovimentacao, int usuarioidUsuario, int pessoaidPessoa, int produtoidProduto) {
        this.idMovimentacao = idMovimentacao;
        this.usuarioidUsuario = usuarioidUsuario;
        this.pessoaidPessoa = pessoaidPessoa;
        this.produtoidProduto = produtoidProduto;
    }

    public Integer getIdMovimentacao() {
        return idMovimentacao;
    }

    public void setIdMovimentacao(Integer idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    public int getUsuarioidUsuario() {
        return usuarioidUsuario;
    }

    public void setUsuarioidUsuario(int usuarioidUsuario) {
        this.usuarioidUsuario = usuarioidUsuario;
    }

    public int getPessoaidPessoa() {
        return pessoaidPessoa;
    }

    public void setPessoaidPessoa(int pessoaidPessoa) {
        this.pessoaidPessoa = pessoaidPessoa;
    }

    public int getProdutoidProduto() {
        return produtoidProduto;
    }

    public void setProdutoidProduto(int produtoidProduto) {
        this.produtoidProduto = produtoidProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Long getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Long valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMovimentacao != null ? idMovimentacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimentacao)) {
            return false;
        }
        Movimentacao other = (Movimentacao) object;
        return !((this.idMovimentacao == null && other.idMovimentacao != null) || (this.idMovimentacao != null && !this.idMovimentacao.equals(other.idMovimentacao)));
    }

    @Override
    public String toString() {
        return "cadastroee.model.Movimentacao[ idMovimentacao=" + idMovimentacao + " ]";
    }
    
}
