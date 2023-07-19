package cadastropoo;

import cadastropoo.model.ExecuteTerminal;
import java.io.IOException;
import java.util.Scanner;

public class CadastroPOO {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ExecuteTerminal Acoes=new ExecuteTerminal();
        int Decisao;
        do{
            Decisao=-1;
            System.out.println("==============");
            System.out.println("1 - Incluir Pessoa");
            System.out.println("2 - Alterar Pessoa");
            System.out.println("3 - Excluir Pessoa");
            System.out.println("4 - Buscar pelo Id");
            System.out.println("5 - Exibir todos");
            System.out.println("6 - Persistir dados");
            System.out.println("7 - Recuperar dados");
            System.out.println("0 - Finalizar programa");
            System.out.println("==============");
            Scanner sc = new Scanner(System.in);
            try{
                Decisao=sc.nextInt();
            }catch(Exception e){
            }
            switch(Decisao){
                case 1 -> /*ACICIONAR*/
                    Acoes.Incluir();
                case 2 -> /*ALTERAR*/
                    Acoes.Alterar();
                case 3 -> /*EXCLUIR*/
                    Acoes.Excluir();
                case 4 -> /*BUSCAR*/
                    Acoes.Buscar();
                case 5 -> /*EXIBIR*/
                    Acoes.ExibirTodos();
                case 6 -> /*PERSISTIR*/
                    Acoes.Persistir();
                case 7 -> /*RECUPERAR*/
                    Acoes.Recuperar();
                case 0 -> {
                }
                default -> System.out.println("Opcao invalida, escola uma das opcoes e acima...");
            }
        }while(Decisao!=0);
    }
}