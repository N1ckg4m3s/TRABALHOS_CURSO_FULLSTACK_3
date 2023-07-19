package cadastropoo.model;
import java.io.Serializable;

public class PessoaFisica extends Pessoa implements Serializable {
    String Cpf;
    int Idade;
    public PessoaFisica(int id,String nome, String cpf, int idade ){
        super(id,nome);
        this.Cpf=cpf;
        this.Idade=idade;
    }
    public void SetCpf(String cpf){
        this.Cpf=cpf;
    }
    public String GetCpf(){
        return this.Cpf;
    }
    public void SetIdade(int idade){
        this.Idade=idade;
    }
    public int GetIdade(){
        return this.Idade;
    }
    @Override
    public void Exibir(){
        super.Exibir();
        System.out.println("CPF:"+this.Cpf);
        System.out.println("IDADE:"+this.Idade);
    }
}
