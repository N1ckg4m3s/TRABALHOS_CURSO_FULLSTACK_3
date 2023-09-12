package cadastrobd.model;
public class Pessoa {
    private int id;
    private String nome, logradouro, cidade, estado, telefone,email;
    public Pessoa(){}
    public Pessoa(int id, String nome, String logradouro, String cidade, String estado, String telefone, String email){
        this.id = id;
        this.nome = nome;
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
        this.email = email;
    };
    
    public void Exibir(){
        System.out.println("ID: " + this.id);
        System.out.println("Nome: " + this.nome);
        System.out.println("Logradouro: " + this.logradouro);
        System.out.println("Cidade: " + this.cidade);
        System.out.println("Estado: " + this.estado);
        System.out.println("Telefone: " + this.telefone);
        System.out.println("Email: " + this.email);
    }
    
    //  GET's
    public int GetId(){return this.id;}
    public String Getnome(){return this.nome;}
    public String Getlogradouro(){return this.logradouro;}
    public String Getcidade(){return this.cidade;}
    public String Getestado(){return this.estado;}
    public String Gettelefone(){return this.telefone;}
    public String Getemail(){return this.email;}
    
    // SET's
    public void Setnome(String nome){this.nome=nome;}
    public void Setlogradouro(String logradouro){this.logradouro=logradouro;}
    public void Setcidade(String cidade){this.cidade=cidade;}
    public void Setestado(String estado){this.estado=estado;}
    public void Settelefone(String telefone){this.telefone=telefone;}
    public void Setemail(String email){this.email=email;}
}
