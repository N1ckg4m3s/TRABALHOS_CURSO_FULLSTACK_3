/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastroclientv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author nicoa
 */
public class CadastroClientV2 {
    
    static SaidaFrame MsgFrame= new SaidaFrame();
    
    public static void main(String[] args) throws ClassNotFoundException {
        try{
            Socket s1=new Socket("localhost", 4321);
            String Login="op1",Senha="op1";
            BufferedReader BufferedReader;
            
            ObjectOutputStream out=new ObjectOutputStream (s1.getOutputStream());
            ObjectInputStream in=new ObjectInputStream(s1.getInputStream());
            
            Thread ThreadClient= new Thread(new ThreadClient(in,MsgFrame.getTextArea()));
            ThreadClient.start();
            
            out.writeUTF(Login);
            out.writeUTF(Senha);
            out.flush();
            
            BufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.println("Menu: L - Listar, X - Finalizar, E - Entrada, S - Saida");
                String comando = BufferedReader.readLine();

                if (comando.equalsIgnoreCase("L")) {
                    
                    MsgFrame.setVisible(true);
                    out.writeUTF(comando);
                    out.flush();
                    
                } else if (comando.equalsIgnoreCase("X")) {
                    
                    out.writeObject(comando);
                    out.flush();
                    s1.close();
                    System.exit(0);
                    
                } else if (comando.equalsIgnoreCase("E") || comando.equalsIgnoreCase("S")) {
                    
                    out.writeUTF(comando);
                    
                    boolean Keep;
                    int idPessoa=0,idProduto=0;
                    int quantidade=0;
                    float valorUnitario=0;
                    
                    // Obter Id da pessoa
                    do{
                        Keep=false;
                        try{
                            System.out.print("Id da pessoa: ");
                            idPessoa = Integer.parseInt(BufferedReader.readLine());
                        }catch(Exception e){
                            Keep=true;
                            System.out.println("Valor Invalido!");
                        }
                    }while(Keep);
                    out.writeInt(idPessoa);
                    
                    // Obter Id do produto
                    do{
                        Keep=false;
                        try{
                            System.out.print("Id do produto: ");
                            idProduto = Integer.parseInt(BufferedReader.readLine());
                        }catch(Exception e){
                            Keep=true;
                            System.out.println("Valor Invalido!");
                        }
                    }while(Keep);
                    out.writeInt(idProduto);
                    
                    // Obter Quantidade
                    do{
                        Keep=false;
                        try{
                            System.out.print("Quantidade: ");
                            quantidade = Integer.parseInt(BufferedReader.readLine());
                        }catch(Exception e){
                            Keep=true;
                            System.out.println("Valor Invalido!");
                        }
                    }while(Keep);
                    out.writeInt(quantidade);
                    
                    // Obter Valor Unitario
                    do{
                        Keep=false;
                        try{
                            System.out.print("Valor unitario: ");
                            valorUnitario = Float.parseFloat(BufferedReader.readLine());
                        }catch(Exception e){
                            Keep=true;
                            System.out.println("Valor Invalido!");
                        }
                    }while(Keep);
                    out.writeFloat(valorUnitario);
                    
                    out.flush();
                    
                } else {
                    System.out.println("Comando inválido");
                }
            }
        }catch(IOException e){
            System.out.println("Exception CadastroClienteV2: main "+e);
        }
    }
    
}
