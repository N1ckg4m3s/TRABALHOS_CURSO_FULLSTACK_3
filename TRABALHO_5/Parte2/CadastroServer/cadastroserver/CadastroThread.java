/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroserver;

import controller.MovimentacaoJpaController;
import controller.ProdutoJpaController;
import controller.UsuarioJpaController;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import model.Movimentacao;
import model.Produto;
import model.Usuario;

/**
 *
 * @author nicoa
 */
public class CadastroThread_02 extends Thread {
    ProdutoJpaController ctrlProd;
    UsuarioJpaController ctrlUsu;
    MovimentacaoJpaController ctrlMov;
    Socket s1;
    ObjectOutputStream out;
    ObjectInputStream in;

    public CadastroThread_02(EntityManagerFactory emf, Socket socket) {
        this.s1 = socket;
        this.ctrlProd = new ProdutoJpaController(emf);
        this.ctrlUsu = new UsuarioJpaController(emf);
        this.ctrlMov = new MovimentacaoJpaController(emf);
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
                    if ("L".equals(comando)){ // LISTA
                        
                        System.out.println("Comando L");
                        out.writeObject(ctrlProd.GetProdutos());
                        
                    } else if ("E".equals(comando)){ // ENTRADA
                        System.out.println("Comando E");
                        
                        int IdPessoa= in.readInt();
                        System.out.println("Id pessoa: "+ IdPessoa);
                        
                        int IdProduto= in.readInt();
                        System.out.println("Id Produto: "+ IdProduto);
                        
                        int Quant= in.readInt();
                        System.out.println("Quant: "+ Quant);
                        
                        
                        float ValorUnit= in.readFloat();
                        System.out.println("ValorUnit: "+ ValorUnit);
                        
                        Movimentacao Mov=new Movimentacao(User.getIdUsuario(),IdPessoa,IdProduto,Quant,ValorUnit,"E");
                        Produto P=ctrlProd.findProduto(IdProduto);
                        
                        ctrlMov.Persistir(Mov);
                                                
                        System.out.println("P == "+ P );
                        if (P!=null){
                            P.setQuantidade(P.getQuantidade()+Quant);
                            ctrlProd.edit(P);
                        }
                        
                    } else if ("S".equals(comando)){ // SAIDA
                        System.out.println("Comando S");
                        
                        int IdPessoa= in.readInt();
                        System.out.println("Id pessoa: "+ IdPessoa);
                        
                        int IdProduto= in.readInt();
                        System.out.println("Id Produto: "+ IdProduto);
                        
                        int Quant= in.readInt();
                        System.out.println("Quant: "+ Quant);
                        
                        
                        float ValorUnit= in.readFloat();
                        System.out.println("ValorUnit: "+ ValorUnit);
                        
                        Movimentacao Mov=new Movimentacao(User.getIdUsuario(),IdPessoa,IdProduto,Quant,ValorUnit,"E");
                        
                        ctrlMov.Persistir(Mov);
                        Produto P=ctrlProd.findProduto(IdProduto);
                        System.out.println("P == "+ P );
                        if (P!=null){
                            P.setQuantidade(P.getQuantidade()+Quant);
                            ctrlProd.edit(P);
                        }
                    }else{
                        System.out.println("ELSE, Comando"+comando);
                        s1.close();
                        return;
                    }
                }
            }
            
        } catch (IOException e) {
            System.out.println("Exception CadastroThread " + e);
        } catch (Exception ex) {
            Logger.getLogger(CadastroThread_02.class.getName()).log(Level.SEVERE, null, ex);
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