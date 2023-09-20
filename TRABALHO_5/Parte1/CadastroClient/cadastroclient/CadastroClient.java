/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastroclient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import model.Produto;

/**
 *
 * @author nicoa
 */
public class CadastroClient {
//    private ObjectInputStream in;
    public static void main(String[] args) throws ClassNotFoundException {
        try{
            Socket s1=new Socket("localhost", 4321);
            String Login="op1",Senha="op1";
            
            ObjectOutputStream out=new ObjectOutputStream(s1.getOutputStream());
            ObjectInputStream in=new ObjectInputStream(s1.getInputStream());
            
            out.writeUTF(Login);
            out.writeUTF(Senha);
            out.flush();
            
            out.writeUTF("L");
            out.flush();
            
            List<Produto> Produtos = (List<Produto>) in.readObject();
            for(Produto P : Produtos){
                System.out.println(P.getNome());
            }
            s1.close();
        }catch(IOException e){
        }
    }
    
}
