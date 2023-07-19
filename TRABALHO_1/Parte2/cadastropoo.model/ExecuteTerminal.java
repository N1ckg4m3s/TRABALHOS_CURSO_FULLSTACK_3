package cadastropoo.model;
import java.io.IOException;
import java.util.Scanner;

public class ExecuteTerminal {
    PessoaFisicaRepo repo1=new PessoaFisicaRepo();
    PessoaJuridicaRepo repo2=new PessoaJuridicaRepo();
    public int TipPessoaeID(){
        int Tip;
        do{
            Scanner sc = new Scanner(System.in);
            System.out.println("Qual tipo de pessoa?");
            System.out.println("1 - Pessoa Fisica | 2 - Pessoa Juridica?");
            try{
                Tip=sc.nextInt();
            }catch(Exception e){
                Tip=0;
            }
        }while(Tip!=1 && Tip!=2);
        return Tip;
    }
    public void Incluir(){
        int Tip=TipPessoaeID();
        int id,idade;
        String Nome,Cpf,Cnpj;
        boolean Keep=true;
        if(Tip==1){
            do{
                Scanner sc = new Scanner(System.in);
                try{
                    System.out.println("Qual o Id?");
                    id=sc.nextInt();
                    System.out.println("Qual o Nome?");
                    Nome=sc.next();
                    System.out.println("Qual a Idade?");
                    idade=sc.nextInt();
                    System.out.println("Qual o CPF?");
                    Cpf=sc.next();
                    repo1.inserir(new PessoaFisica(id,Nome,Cpf,idade));
                    Keep=false;
                }catch(Exception e){
                    System.out.println("Um erro aconteceu.., poderia colocar os dados novamente");
                }
            }while(Keep);
        }else{
            do{
                Scanner sc = new Scanner(System.in);
                try{
                    System.out.println("Qual o Id?");
                    id=sc.nextInt();
                    System.out.println("Qual o Nome?");
                    Nome=sc.next();
                    System.out.println("Qual o CNPJ?");
                    Cnpj=sc.next();
                    repo2.inserir(new PessoaJuridica(id,Nome,Cnpj));
                    Keep=false;
                }catch(Exception e){
                    System.out.println("Um erro aconteceu.., poderia colocar os dados novamente");
                }
            }while(Keep);
        }
    }
    public void Alterar(){
        int Tip=TipPessoaeID();
        int id1,id,idade;
        String Nome,Cpf,Cnpj;
        boolean Keep=true;
        if(Tip==1){
            do{
                try{
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Qual o Id para alterar?");
                    id1=sc.nextInt();
                    System.out.println("Qual o Id?");
                    id=sc.nextInt();
                    System.out.println("Qual o Nome?");
                    Nome=sc.next();
                    System.out.println("Qual a Idade?");
                    idade=sc.nextInt();
                    System.out.println("Qual o CPF?");
                    Cpf=sc.next();
                    repo1.alterar(repo1.obter(id1),new PessoaFisica(id,Nome,Cpf,idade));
                    Keep=false;
                }catch(Exception e){
                    System.out.println("Um erro aconteceu.., poderia colocar os dados novamente");
                }
            }while(Keep);
        }else{
            do{
                Scanner sc = new Scanner(System.in);
                try{
                    System.out.println("Qual o Id para alterar?");
                    id1=sc.nextInt();
                    System.out.println("Qual o Id?");
                    id=sc.nextInt();
                    System.out.println("Qual o Nome?");
                    Nome=sc.next();
                    System.out.println("Qual o CNPJ?");
                    Cnpj=sc.next();
                    repo2.alterar(repo2.obter(id1),new PessoaJuridica(id,Nome,Cnpj));
                    Keep=false;
                }catch(Exception e){
                    System.out.println("Um erro aconteceu.., poderia colocar os dados novamente");
                }
            }while(Keep);
        }
    }
    public void Excluir(){
        int id;
        int Tip=TipPessoaeID();
        boolean Keep=true;
        do{
            Scanner sc = new Scanner(System.in);
            try{
                System.out.println("Qual o Id?");
                id=sc.nextInt();
                if(Tip==1){
                    repo1.excluir(repo1.obter(id));
                }else{
                    repo2.excluir(repo2.obter(id));
                }
                Keep=false;
            }catch(Exception e){
                System.out.println("Um erro aconteceu.., poderia colocar os dados novamente");
            }
        }while(Keep);
    }
    public void Buscar(){
        int Tip=TipPessoaeID();
        boolean Keep=true;
        do{
            Scanner sc = new Scanner(System.in);
            try{
                System.out.println("Qual o Id?");
                int id=sc.nextInt();
                if(Tip==1){
                    repo1.obter(id).Exibir();
                }else{
                    repo2.obter(id).Exibir();
                }
                Keep=false;
            }catch(Exception e){
                System.out.println("Um erro aconteceu.., poderia colocar os dados novamente");
            }
        }while(Keep);
    }
    public void ExibirTodos(){
        int Tip=TipPessoaeID();
        if(Tip==1){
            for(PessoaFisica pes:repo1.obterTodos()){
                pes.Exibir();
            }
        }else{
            for(PessoaJuridica pes:repo2.obterTodos()){
                pes.Exibir();
            }
        }
    }
    public void Persistir(){
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Digite o prefixo dos arquivos: ");
            String prefixo = sc.nextLine();
            repo1.persistir(prefixo + ".fisica.bin");
            repo2.persistir(prefixo + ".juridica.bin");
            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }
    public void Recuperar(){
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Digite o prefixo dos arquivos: ");
            String prefixo = sc.nextLine();
            repo1.recuperar(prefixo + ".fisica.bin");
            repo2.recuperar(prefixo + ".juridica.bin");
            System.out.println("Dados recuperados com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar os dados: " + e.getMessage());
        }
    }
}
