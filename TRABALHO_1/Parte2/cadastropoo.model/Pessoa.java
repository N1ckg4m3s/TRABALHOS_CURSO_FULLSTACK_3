package cadastropoo.model;
import java.io.Serializable;

public class Pessoa implements Serializable {
    int Id;
    String Nome;
    public Pessoa(int id, String nome){
        this.Id=id;
        this.Nome=nome;
    }
    public void SetId(int id){
        this.Id=id;
    }
    public int GetId(){
        return this.Id;
    }
    public void SetNome(String nome){
        this.Nome=nome;
    }
    public String GetNome(){
        return this.Nome;
    }
    public void Exibir(){
        System.out.println("ID:"+this.Id);
        System.out.println("NOME:"+this.Nome);
    }
};

