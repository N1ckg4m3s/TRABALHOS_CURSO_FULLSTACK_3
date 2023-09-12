package cadastrobd.model;

import cadastro.model.util.ConectorBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaDAO {
    public PessoaFisica getPessoa(int Chave){
        try{
            Connection Conec=ConectorBD.getConnection();
            PreparedStatement ps = ConectorBD.getPrepared(Conec,"SELECT * FROM PessoaFisica WHERE id = ?");
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
                String cpf = Result.getString("cpf");
                return new PessoaFisica(id,nome,logradouro,cidade,estado,telefone,email,cpf);
            }
            
            ConectorBD.close(ps);
            ConectorBD.close(Conec);
            
        }catch(SQLException ex){}
        return null;
    }
    public List<PessoaFisica> getPessoas(){
        List<PessoaFisica> pessoas = new ArrayList<>();
        try{
            Connection Conec=ConectorBD.getConnection();
            PreparedStatement ps = ConectorBD.getPrepared(Conec,"SELECT * FROM PessoaFisica");
            ResultSet Result = ps.executeQuery();
            if(Result.next()){
                int id = Result.getInt("id");
                String nome = Result.getString("nome");
                String logradouro = Result.getString("logradouro");
                String cidade = Result.getString("cidade");
                String estado = Result.getString("estado");
                String telefone = Result.getString("telefone");
                String email = Result.getString("email");
                String cpf = Result.getString("cpf");
                PessoaFisica pessoa= new PessoaFisica(id,nome,logradouro,cidade,estado,telefone,email,cpf);
                pessoas.add(pessoa);
            }
            ConectorBD.close(ps);
            ConectorBD.close(Conec);
            
        }catch(SQLException ex){}
        return pessoas;
    }
    public void incluir(PessoaFisica Pessoa){
        try{
            Connection Conec=ConectorBD.getConnection();
            PreparedStatement ps = ConectorBD.getPrepared(Conec,"INSERT INTO PessoaFisica VALUES (?,?,?,?,?,?,?,?)");
            ps.setInt(1,Pessoa.GetId());
            ps.setString(2,Pessoa.Getnome());
            ps.setString(3,Pessoa.Getlogradouro());
            ps.setString(4,Pessoa.Getcidade());
            ps.setString(5,Pessoa.Getestado());
            ps.setString(6,Pessoa.Gettelefone());
            ps.setString(7,Pessoa.Getemail());
            ps.setString(8,Pessoa.Getcpf());
            
            ps.execute();
            
            ConectorBD.close(ps);
            ConectorBD.close(Conec);
            
        }catch(SQLException ex){}
    }
    public void alterar(PessoaFisica Pessoa){
        try{
            Connection Conec=ConectorBD.getConnection();
            PreparedStatement ps = ConectorBD.getPrepared(Conec,"UPDATE PessoaFisica SET \n"+
                    "nome=?, logradouro=?, cidade=?, estado=?, telefone=?, email=?, cpf=? WHERE id = ?");
            
            ps.setString(1,Pessoa.Getnome());
            ps.setString(2,Pessoa.Getlogradouro());
            ps.setString(3,Pessoa.Getcidade());
            ps.setString(4,Pessoa.Getestado());
            ps.setString(5,Pessoa.Gettelefone());
            ps.setString(6,Pessoa.Getemail());
            ps.setString(7,Pessoa.Getcpf());
            ps.setInt(8,Pessoa.GetId());
            
            ps.executeUpdate();
            
            ConectorBD.close(ps);
            ConectorBD.close(Conec);
            
        }catch(SQLException ex){}
    }
    public void excluir(int Chave){
         try{
            Connection Conec=ConectorBD.getConnection();
            PreparedStatement ps = ConectorBD.getPrepared(Conec,"DELETE FROM PessoaFisica WHERE id = ?");
            ps.setInt(1,Chave);
            
            ps.executeUpdate();
            
            ConectorBD.close(ps);
            ConectorBD.close(Conec);
            
        }catch(SQLException ex){}
    }
    public void excluir(PessoaFisica Pessoa){
        try{
            Connection Conec=ConectorBD.getConnection();
            PreparedStatement ps = ConectorBD.getPrepared(Conec,"DELETE FROM PessoaFisica WHERE id = ?");
            ps.setInt(1,Pessoa.GetId());
            
            ps.executeUpdate();
            
            ConectorBD.close(ps);
            ConectorBD.close(Conec);
            
        }catch(SQLException ex){}
    }
}
