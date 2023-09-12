package cadastrobd.model;


import java.io.IOException;
import java.util.Scanner;

public class CadastroBDTeste {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ExecuteTerminal Acoes=new ExecuteTerminal();
        int Decisao;
        do{
            Decisao=-1;
            System.out.println("==============");
            System.out.println("1 - Incluir Pessoa");
            System.out.println("2 - Alterar Pessoa");
            System.out.println("3 - Excluir Pessoa");
            System.out.println("4 - Exibir pelo Id");
            System.out.println("5 - Exibir todos");
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
                case 4 -> /*Obter*/
                    Acoes.Obter();
                case 5 -> /*ObterTodos*/
                    Acoes.ObterTodos();
                case 0 -> {
                }
                default -> System.out.println("Opcao invalida, escola uma das opcoes e acima...");
            }
        }while(Decisao!=0);
    }
}
