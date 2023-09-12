package cadastrobd.model;
import java.util.List;
import java.util.Scanner;
public class ExecuteTerminal {
    PessoaFisicaDAO PesFDao=new PessoaFisicaDAO();
    PessoaJuridicaDAO PesJDao=new PessoaJuridicaDAO();
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
        int id;
        String nome, logradouro, cidade, estado, telefone,email;
        String cpf,cnpj;
        boolean Keep=true;
        if(Tip==1){ // FISICA
            do{
                Scanner sc = new Scanner(System.in);
                try{
                    System.out.println("Qual o Id?");
                    id=sc.nextInt();
                    System.out.println("Qual o Nome?");
                    nome=sc.next();
                    System.out.println("Qual o Logradouro?");
                    logradouro=sc.next();
                    System.out.println("Qual a Cidade?");
                    cidade=sc.next();
                    System.out.println("Qual o Estado?");
                    estado=sc.next();
                    System.out.println("Qual o Telefone?");
                    telefone=sc.next();
                    System.out.println("Qual o Email?");
                    email=sc.next();
                    System.out.println("Qual o Cpf?");
                    cpf=sc.next();
                    PesFDao.incluir(new PessoaFisica(id, nome, logradouro, cidade, estado, telefone, email, cpf));
                    Keep=false;
                }catch(Exception e){
                    System.out.println("Um erro aconteceu.., poderia colocar os dados novamente");
                }
            }while(Keep);
        }else if(Tip==2){ // Juridica
            do{
                Scanner sc = new Scanner(System.in);
                try{
                    System.out.println("Qual o Id?");
                    id=sc.nextInt();
                    System.out.println("Qual o Nome?");
                    nome=sc.next();
                    System.out.println("Qual o Logradouro?");
                    logradouro=sc.next();
                    System.out.println("Qual a Cidade?");
                    cidade=sc.next();
                    System.out.println("Qual o Estado?");
                    estado=sc.next();
                    System.out.println("Qual o Telefone?");
                    telefone=sc.next();
                    System.out.println("Qual o Email?");
                    email=sc.next();
                    System.out.println("Qual o Cnpj?");
                    cnpj=sc.next();
                    PesJDao.incluir(new PessoaJuridica(id, nome, logradouro, cidade, estado, telefone, email, cnpj));
                    Keep=false;
                }catch(Exception e){
                    System.out.println("Um erro aconteceu.., poderia colocar os dados novamente");
                }
            }while(Keep);
        }
    }
    public void Alterar(){
        int Tip=TipPessoaeID();
        int id=-1;
        
        int Decisao1;
        boolean Keep1=true;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual o Id para alterar?");
        // OBTER QUAL O ID DA PESSOA
        do{
            try{
                id=sc.nextInt();
            }catch(Exception e){
                System.out.println("Invalido");
            }
        }while(id<0);
        // OBTER QUAL VAI SER A ALTERAÇÃO
        do{
            System.out.println("==============");
            System.out.println("1 - Nome");
            System.out.println("2 - Logradouro");
            System.out.println("3 - Cidade");
            System.out.println("4 - Estado");
            System.out.println("5 - Telefone");
            System.out.println("6 - Email");
            System.out.println("7 - Cpf / Cnpj");
            System.out.println("==============");
            Decisao1=sc.nextInt();
            switch(Decisao1){
                case 1://Nome
                    System.out.println("Qual o nome");
                    if (Tip==1){
                        PesFDao.getPessoa(id).Setnome(sc.next());
                    }else{
                        PesJDao.getPessoa(id).Setnome(sc.next());
                    }
                case 2://Logradouro
                    System.out.println("Qual o Logradouro");
                    if (Tip==1){
                        PesFDao.getPessoa(id).Setlogradouro(sc.next());
                    }else{
                        PesJDao.getPessoa(id).Setlogradouro(sc.next());
                    }
                case 3://Cidade
                    System.out.println("Qual a Cidade");
                    if (Tip==1){
                        PesFDao.getPessoa(id).Setcidade(sc.next());
                    }else{
                        PesJDao.getPessoa(id).Setcidade(sc.next());
                    }
                case 4://Estado
                    System.out.println("Qual o Estado");
                    if (Tip==1){
                        PesFDao.getPessoa(id).Setestado(sc.next());
                    }else{
                        PesJDao.getPessoa(id).Setestado(sc.next());
                    }
                case 5://Telefone
                    System.out.println("Qual o Telefone");
                    if (Tip==1){
                        PesFDao.getPessoa(id).Settelefone(sc.next());
                    }else{
                        PesJDao.getPessoa(id).Settelefone(sc.next());
                    }
                case 6://Email
                    System.out.println("Qual o Email");
                    if (Tip==1){
                        PesFDao.getPessoa(id).Setemail(sc.next());
                    }else{
                        PesJDao.getPessoa(id).Setemail(sc.next());
                    }
                case 7://CPF/CNPJ
                    System.out.println("Qual o Cpf / Cnpj");
                    if (Tip==1){
                        PesFDao.getPessoa(id).Setcpf(sc.next());
                    }else{
                        PesJDao.getPessoa(id).Setcnpj(sc.next());
                    }
                default:
                    System.out.println("Informe um valor valido");
            }
            System.out.println("Gostaria de Alterar Algo mais?");
            System.out.println("1 - Sim, 2 - Não");
            if(Decisao1==2){Keep1=false;}
        }while(Keep1);
        if (Tip==1){
            PesFDao.alterar(PesFDao.getPessoa(id));
        }else{
            PesJDao.alterar(PesJDao.getPessoa(id));
        }
    }
    public void Excluir(){
        int Tip=TipPessoaeID();
        int id=-1;
        do{
            Scanner sc = new Scanner(System.in);
            try{
                System.out.println("Qual o Id?");
                id=sc.nextInt();
                if(Tip==1){
                    PesFDao.excluir(PesFDao.getPessoa(id));
                }else{
                    PesJDao.excluir(PesJDao.getPessoa(id));
                }
            }catch(Exception e){
                System.out.println("Um erro aconteceu.., poderia colocar os dados novamente");
            }
        }while(id<0);

    }
    public void Obter(){
        int Tip=TipPessoaeID();
        int id=-1;
        do{
            Scanner sc = new Scanner(System.in);
            try{
                System.out.println("Qual o Id?");
                id=sc.nextInt();
                if(Tip==1){
                    PesFDao.getPessoa(id).Exibir();
                }else{
                    PesJDao.getPessoa(id).Exibir();
                }
            }catch(Exception e){
                System.out.println("Um erro aconteceu.., poderia colocar os dados novamente");
            }
        }while(id<0);
    }
    public void ObterTodos(){
        int Tip=TipPessoaeID();
        if(Tip==1){
            List<PessoaFisica> TodasPesF = PesFDao.getPessoas();
            for (PessoaFisica pf : TodasPesF) {
                pf.Exibir();
            }
        }else{
            List<PessoaJuridica> TodasPesJ = PesJDao.getPessoas();
            for (PessoaJuridica pf : TodasPesJ) {
                pf.Exibir();
            }
        }
    }
}