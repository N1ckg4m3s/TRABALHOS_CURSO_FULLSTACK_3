/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroserver;

import controller.ProdutoJpaController;
import controller.UsuarioJpaController;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.persistence.EntityManagerFactory;
import model.Usuario;

/**
 *
 * @author nicoa
 */
public class CadastroThread extends Thread {
    ProdutoJpaController ctrl;
    UsuarioJpaController ctrlUsu;
    Socket s1;
    ObjectOutputStream out;
    ObjectInputStream in;

    public CadastroThread(EntityManagerFactory emf, Socket socket) {
        this.s1 = socket;
        this.ctrl = new ProdutoJpaController(emf);
        this.ctrlUsu = new UsuarioJpaController(emf);
    }
    
    @Override
    public void run() {
        try {
            out = new ObjectOutputStream(s1.getOutputStream());
            in = new ObjectInputStream(s1.getInputStream());
            
            String login = in.readUTF();
            String senha = in.readUTF();
            
            Usuario User = ctrlUsu.findUsuario(login,senha);
            
            if(User==null){
                System.out.println("User == nul");
                s1.close();
            }else{
                while(true){
                    String comando = in.readUTF();
                    System.out.println(comando);
                    if ("L".equals(comando)) {
                        out.writeObject(ctrl.GetProdutos());
                    } else {
                        s1.close();
                        return;
                    }
                }
            }
            
        } catch (IOException e) {
            System.out.println("Exception CadastroThread " + e);
        } finally {
            System.out.println("Finaly");
            try {
                // Fechar os canais de entrada e saída e encerrar a conexão
                if (out != null) out.close();
                if (in != null) in.close();
                if (s1 != null && !s1.isClosed()) s1.close();
            } catch (IOException e) {
                
            }
        }
    }
}