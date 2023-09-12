package cadastrobd.model;

public class PessoaJuridica extends Pessoa {
    private String cnpj;
    public PessoaJuridica(){super();};
    
    public PessoaJuridica(int id, String nome, String logradouro, String cidade, String estado, String telefone, String email, String cnpj){
        super(id,nome, logradouro, cidade, estado, telefone,email);
        this.cnpj=cnpj;
    };
    @Override
    public void Exibir(){
        super.Exibir();
        System.out.println("Cnpj: " + this.cnpj);
    }
    // GET's
    public int GetId(){return super.GetId();}
    public String Getnome(){return super.Getnome();}
    public String Getlogradouro(){return super.Getlogradouro();}
    public String Getcidade(){return super.Getcidade();}
    public String Getestado(){return super.Getestado();}
    public String Gettelefone(){return super.Gettelefone();}
    public String Getemail(){return super.Getemail();}
    public String Getcnpj(){return this.cnpj;}
    
    // SET's
    public void Setnome(String nome){super.Setnome(nome);}
    public void Setlogradouro(String logradouro){super.Setlogradouro(logradouro);}
    public void Setcidade(String cidade){super.Setcidade(cidade);}
    public void Setestado(String estado){super.Setestado(estado);}
    public void Settelefone(String telefone){super.Settelefone(telefone);}
    public void Setemail(String email){super.Setemail(email);}
    public void Setcnpj(String cnpj){this.cnpj=cnpj;}
    
}
