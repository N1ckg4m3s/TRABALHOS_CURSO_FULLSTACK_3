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
@Table(name = "PessoaFisica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PessoaFisica.findAll", query = "SELECT p FROM PessoaFisica p"),
    @NamedQuery(name = "PessoaFisica.findById", query = "SELECT p FROM PessoaFisica p WHERE p.id = :id"),
    @NamedQuery(name = "PessoaFisica.findByNome", query = "SELECT p FROM PessoaFisica p WHERE p.nome = :nome"),
    @NamedQuery(name = "PessoaFisica.findByLogradouro", query = "SELECT p FROM PessoaFisica p WHERE p.logradouro = :logradouro"),
    @NamedQuery(name = "PessoaFisica.findByCidade", query = "SELECT p FROM PessoaFisica p WHERE p.cidade = :cidade"),
    @NamedQuery(name = "PessoaFisica.findByEstado", query = "SELECT p FROM PessoaFisica p WHERE p.estado = :estado"),
    @NamedQuery(name = "PessoaFisica.findByTelefone", query = "SELECT p FROM PessoaFisica p WHERE p.telefone = :telefone"),
    @NamedQuery(name = "PessoaFisica.findByEmail", query = "SELECT p FROM PessoaFisica p WHERE p.email = :email"),
    @NamedQuery(name = "PessoaFisica.findByCpf", query = "SELECT p FROM PessoaFisica p WHERE p.cpf = :cpf")})

public class PessoaFisica extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "logradouro")
    private String logradouro;
    @Basic(optional = false)
    @Column(name = "cidade")
    private String cidade;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "telefone")
    private String telefone;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "cpf")
    private String cpf;

    public PessoaFisica() {
    }

    public PessoaFisica(Integer id) {
        this.id = id;
    }

    public PessoaFisica(Integer id, String nome, String logradouro, String cidade, String estado, String telefone, String email, String cpf) {
        this.id = id;
        this.nome = nome;
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getNome() {
        return nome;
    }
    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public String getLogradouro() {
        return logradouro;
    }
    @Override
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    @Override
    public String getCidade() {
        return cidade;
    }
    @Override
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    @Override
    public String getEstado() {
        return estado;
    }
    @Override
    public void setEstado(String estado) {
        this.estado = estado;
    }
    @Override
    public String getTelefone() {
        return telefone;
    }
    @Override
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    @Override
    public String getEmail() {
        return email;
    }
    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PessoaFisica)) {
            return false;
        }
        PessoaFisica other = (PessoaFisica) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "cadastroee.model.PessoaFisica[ id=" + id + " ]";
    }
    
}
