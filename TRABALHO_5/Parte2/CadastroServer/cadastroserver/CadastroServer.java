/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastroserver;

import controller.ProdutoJpaController;
import controller.UsuarioJpaController;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author nicoa
 */
public class CadastroServer {
    static EntityManagerFactory Emf=Persistence.createEntityManagerFactory("CadastroServerPU");
    ProdutoJpaController ctrl=new ProdutoJpaController(Emf);
    UsuarioJpaController ctrlUsu= new UsuarioJpaController(Emf);
    
    public static void main(String[] args) {
        try{
            ServerSocket s1=new ServerSocket(4321);
            while(true){
                Socket SocketClient=s1.accept();
                Thread ThreadClient;
                ThreadClient = new Thread(new CadastroThread_02(Emf,SocketClient));
                System.out.println("Loop CadastroServer.java");
                ThreadClient.start();
            }
        }catch(IOException e){
            System.out.println("Exception CadastroServer.java" + e);
        }
    }
    
}
