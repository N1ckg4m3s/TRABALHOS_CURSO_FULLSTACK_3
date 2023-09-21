/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroclientv2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import model.Produto;

/**
 *
 * @author nicoa
 */
public class ThreadClient extends Thread {
    private ObjectInputStream in;
    private JTextArea textArea;

    public ThreadClient(ObjectInputStream entrada, JTextArea textArea) {
        this.in = entrada;
        this.textArea = textArea;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Object obj = in.readObject();
                SwingUtilities.invokeLater(() -> {
                    if (obj instanceof String) {
                        textArea.append((String) obj + "\n");
                    } else {
                        List lista = (List) obj;
                        for(Object item: lista){
                            if (item instanceof model.Produto) {
                                String Nome =((Produto) item).getNome();
                                int Quant =((Produto) item).getQuantidade();
                                textArea.append(Nome+"::"+Quant+"\n");
                            }
                        }
                    }
                });
            }
        } catch (IOException e) {
            System.out.println("Exception ThreadClient "+ e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ThreadClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
