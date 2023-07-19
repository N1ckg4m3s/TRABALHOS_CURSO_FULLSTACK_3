package cadastropoo.model;
import java.io.Serializable;

public class PessoaJuridica extends Pessoa implements Serializable{
    String Cnpj;
    public PessoaJuridica(int id,String Nome,String cnpj){
        super(id,Nome);
        this.Cnpj=cnpj;
    }
    public void SetCnpj(String cnpj){
        this.Cnpj=cnpj;
    }
    public String GetCnpj(){
        return this.Cnpj;
    }
    @Override
    public void Exibir(){
        super.Exibir();
        System.out.println("CNPJ:"+this.Cnpj);
    }
}
