package src.Interface;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;

import java.awt.BorderLayout;
import javax.swing.SpringLayout;

// Todas as telas devem estender esta classe!
// A partir desta, deve-se adicionar o que for necessário para cada uma.

public class Tela {

    private JFrame janela;

    private JPanel body;
    private JPanel header;
    private JPanel main;
    private JPanel footer;

    public Tela(){
        this.janela = new JFrame("Gerenciador");
        this.janela.setSize(1280, 720);
        this.janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.body = new Body(1280, 720, 0, 40);
        
        this.initBody();
        this.janela.add( this.body );

        this.janela.setVisible(true);
    }

    private void initBody(){
        this.body.setBackground( Estilo.branco );
        // this.body.setLayout( new BorderLayout(0, 40) );

        this.initHeader();
        this.initMain();
        this.initFooter();

        this.body.add(this.header, BorderLayout.NORTH);
        this.body.add(this.main, BorderLayout.CENTER);
        this.body.add(this.footer, BorderLayout.SOUTH);
    }

    private void initHeader(){
        this.header = new Header(  );
        this.header.setPreferredSize( new Dimension(1280, 80) );
        this.header.setBackground( Estilo.verdao );
    }

    private void initMain(){
        this.main = new Main(  );
        this.main.setPreferredSize( new Dimension(1280, 480) );
    }

    private void initFooter(){
        this.footer = new Footer(  );
        this.footer.setPreferredSize( new Dimension(1280, 80) );
        this.footer.setBackground( Estilo.verdao );
    }
}
