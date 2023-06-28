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

        this.initBody();
        this.janela.add( body );

        this.janela.setVisible(true);
    }

    private void initBody(){
        this.body = new JPanel();
        this.body.setLayout( new BorderLayout(0, 40) );

        Dimension size = new Dimension(1280, 720);

        this.body.setPreferredSize(size);

        this.body.setBackground( Estilo.branco );

        this.initHeader();
        this.initMain();
        this.initFooter();

        this.body.add(this.header, BorderLayout.NORTH);
        this.body.add(this.main, BorderLayout.CENTER);
        this.body.add(this.footer, BorderLayout.SOUTH);
    }

    private void initHeader(){
        this.header = new JPanel();

        Dimension size = new Dimension(1280, 80);

        this.header.setPreferredSize(size);

        this.header.setBackground( Estilo.vermelhao );

    }

    private void initMain(){
        this.main = new JPanel();

        // this.main.setLayout( new BorderLayout( 20, 20) );
        this.main.setLayout( new BorderLayout( 0, 0) );

        Dimension size = new Dimension(1280, 480);

        this.main.setPreferredSize(size);

        this.main.setBackground( Estilo.vermelhao );

        JLabel txt = new JLabel("JURASSIC PARK");

        txt.setFont(Estilo.roboto);
        txt.setForeground( Estilo.branco );
        

        JPanel north = new JPanel();
        JPanel center = new JPanel();
        JPanel south = new JPanel();
        JPanel east = new JPanel();
        JPanel west = new JPanel();

        int majorWidth = (int) this.main.getPreferredSize().getWidth();
        int majorHeight = (int) this.main.getPreferredSize().getHeight();

        size = new Dimension(majorWidth , majorHeight/100 * 25);

        north.setPreferredSize( size );

        size = new Dimension(majorWidth/100 * 50 , majorHeight/100 * 50);

        center.setPreferredSize( size );

        size = new Dimension(majorWidth , majorHeight/100 * 25);

        south.setPreferredSize( size );

        size = new Dimension(majorWidth/100 * 25 , majorHeight/100 * 50);

        east.setPreferredSize( size );
        west.setPreferredSize( size );

        // north.setBackground( Paleta.vermelhinho );
        // center.setBackground( Paleta.vermelhinho );
        // south.setBackground( Paleta.vermelhinho );
        // east.setBackground( Paleta.vermelhinho );
        // west.setBackground( Paleta.vermelhinho );

        north.setBackground( Estilo.vermelhao );
        center.setBackground( Estilo.vermelhao );
        south.setBackground( Estilo.vermelhao );
        east.setBackground( Estilo.vermelhao );
        west.setBackground( Estilo.vermelhao );

        north.add(txt);
        
        center.setLayout( new SpringLayout() );

        this.main.add(north, BorderLayout.NORTH);
        this.main.add(center, BorderLayout.CENTER);
        this.main.add(south, BorderLayout.SOUTH);
        this.main.add(east, BorderLayout.EAST);
        this.main.add(west, BorderLayout.WEST);

    }

    private void initFooter(){
        this.footer = new JPanel();

        Dimension size = new Dimension(1280, 80);

        this.footer.setPreferredSize(size);

        this.footer.setBackground( Estilo.vermelhao );
    }
}
