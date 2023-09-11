package cadastrobd.model;

import cadastro.model.util.ConectorBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaDAO {
    public PessoaJuridica getPessoa(int Chave){
        try{
            Connection Conec=ConectorBD.getConnection();
            PreparedStatement ps = ConectorBD.getPrepared(Conec,"SELECT * FROM PessoaJuridica WHERE id = ?");
            ps.setInt(1,Chave);
            ResultSet Result = ps.executeQuery();
            if(Result.next()){
                int id = Result.getInt("id");
                String nome = Result.getString("nome");
                String logradouro = Result.getString("logradouro");
                String cidade = Result.getString("cidade");
                String estado = Result.getString("estado");
                String telefone = Result.getString("telefone");
                String email = Result.getString("email");
                String cnpj = Result.getString("cnpj");
                return new PessoaJuridica(id,nome,logradouro,cidade,estado,telefone,email,cnpj);
            }
            
            ConectorBD.close(ps);
            ConectorBD.close(Conec);
            
        }catch(SQLException ex){}
        return null;
    }
    public List<PessoaJuridica> getPessoas(){
        List<PessoaJuridica> pessoas = new ArrayList<>();
        try{
            Connection Conec=ConectorBD.getConnection();
            PreparedStatement ps = ConectorBD.getPrepared(Conec,"SELECT * FROM PessoaJuridica");
            ResultSet Result = ps.executeQuery();
            if(Result.next()){
                int id = Result.getInt("id");
                String nome = Result.getString("nome");
                String logradouro = Result.getString("logradouro");
                String cidade = Result.getString("cidade");
                String estado = Result.getString("estado");
                String telefone = Result.getString("telefone");
                String email = Result.getString("email");
                String cnpj = Result.getString("cnpj");
                PessoaJuridica pessoa= new PessoaJuridica(id,nome,logradouro,cidade,estado,telefone,email,cnpj);
                pessoas.add(pessoa);
            }
            ConectorBD.close(ps);
            ConectorBD.close(Conec);
            
        }catch(SQLException ex){}
        return pessoas;
    }
    public void incluir(PessoaJuridica Pessoa){
        try{
            Connection Conec=ConectorBD.getConnection();
            PreparedStatement ps = ConectorBD.getPrepared(Conec,"INSERT INTO PessoaJuridica VALUES (?,?,?,?,?,?,?,?)");
            ps.setInt(1,Pessoa.GetId());
            ps.setString(2,Pessoa.Getnome());
            ps.setString(3,Pessoa.Getlogradouro());
            ps.setString(4,Pessoa.Getcidade());
            ps.setString(5,Pessoa.Getestado());
            ps.setString(6,Pessoa.Gettelefone());
            ps.setString(7,Pessoa.Getemail());
            ps.setString(8,Pessoa.Getcnpj());
            
            ps.execute();
            
            ConectorBD.close(ps);
            ConectorBD.close(Conec);
            
        }catch(SQLException ex){}
    }
    public void alterar(PessoaJuridica Pessoa){
        try{
            Connection Conec=ConectorBD.getConnection();
            PreparedStatement ps = ConectorBD.getPrepared(Conec,"UPDATE PessoaJuridica SET \n"+
                    "nome=?, logradouro=?, cidade=?, estado=?, telefone=?, email=?, cnpj=? WHERE id = ?");
            
            ps.setString(1,Pessoa.Getnome());
            ps.setString(2,Pessoa.Getlogradouro());
            ps.setString(3,Pessoa.Getcidade());
            ps.setString(4,Pessoa.Getestado());
            ps.setString(5,Pessoa.Gettelefone());
            ps.setString(6,Pessoa.Getemail());
            ps.setString(7,Pessoa.Getcnpj());
            ps.setInt(8,Pessoa.GetId());
            
            ps.executeUpdate();
            
            ConectorBD.close(ps);
            ConectorBD.close(Conec);
            
        }catch(SQLException ex){}
    }
    public void excluir(int Chave){
         try{
            Connection Conec=ConectorBD.getConnection();
            PreparedStatement ps = ConectorBD.getPrepared(Conec,"DELETE FROM PessoaJuridica WHERE id = ?");
            ps.setInt(1,Chave);
            
            ps.executeUpdate();
            
            ConectorBD.close(ps);
            ConectorBD.close(Conec);
            
        }catch(SQLException ex){}
    }
    public void excluir(PessoaJuridica Pessoa){
        try{
            Connection Conec=ConectorBD.getConnection();
            PreparedStatement ps = ConectorBD.getPrepared(Conec,"DELETE FROM PessoaJuridica WHERE id = ?");
            ps.setInt(1,Pessoa.GetId());
            
            ps.executeUpdate();
            
            ConectorBD.close(ps);
            ConectorBD.close(Conec);
            
        }catch(SQLException ex){}
    }
}