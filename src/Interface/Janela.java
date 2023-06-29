package src.Interface;

import javax.swing.JFrame;

public class Janela extends JFrame {

    private JFrame janela;
    private Tela tela;

    public Janela(){
        this.janela = new JFrame("Gerenciador");
        this.janela.setSize(1280, 720);
        this.janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.tela = new Tela();

        this.janela.add( this.tela.body );

        this.janela.setVisible(true);
    }
}
