/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroclientv2;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

/**
 *
 * @author nicoa
 */
public class SaidaFrame extends JDialog {
    public JTextArea Texto;
    public SaidaFrame() {
        this.setBounds(100, 100, 400, 300);
        this.setModal(false);

        Texto = new JTextArea();
        DefaultCaret caret = (DefaultCaret) Texto.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        JScrollPane scrollPane = new JScrollPane(Texto);
        this.add(scrollPane);
    }
    public void AdicionarMensagem(String Txt){
        Texto.append(Txt);
    }
    public JTextArea getTextArea() {
        return Texto;
    }
}
