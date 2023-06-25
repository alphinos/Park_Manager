
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Color;

public class Gerenciador {

    private JFrame janela;

    private JPanel body;
    private JPanel header;
    private JPanel main;
    private JPanel footer;

    public Gerenciador(){
        this.janela = new JFrame("Gerenciador");
        this.janela.setSize(1280, 720);
        this.janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.initBody();
        this.janela.add( body );

        this.janela.setVisible(true);
    }

    private void initBody(){
        this.body = new JPanel();

        Dimension size = new Dimension(1280, 720);

        this.body.setPreferredSize(size);

        Color rosa = new Color( 250, 52, 79, 98 );

        this.body.setBackground(rosa);

        this.initHeader();
        this.initMain();
        this.initFooter();

        this.body.add(this.header);
        this.body.add(this.main);
        this.body.add(this.footer);
    }

    private void initHeader(){
        this.header = new JPanel();

        Dimension size = new Dimension(1280, 80);

        this.header.setPreferredSize(size);

        Color quaseVermelho = new Color( 227, 57, 36, 89 );

        this.header.setBackground( quaseVermelho );
    }

    private void initMain(){
        this.main = new JPanel();

        Dimension size = new Dimension(1280, 480);

        this.main.setPreferredSize(size);

        Color tipoLaranja = new Color( 253, 94, 40, 99 );

        this.main.setBackground( tipoLaranja );
    }

    private void initFooter(){
        this.footer = new JPanel();

        Dimension size = new Dimension(1280, 80);

        this.footer.setPreferredSize(size);

        Color quaseVermelho = new Color( 227, 57, 36, 89 );

        this.footer.setBackground( quaseVermelho );
    }
}
