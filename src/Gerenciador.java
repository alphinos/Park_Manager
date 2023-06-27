package src;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;

import java.awt.BorderLayout;
import javax.swing.SpringLayout;

public class Gerenciador {

    private JFrame janela;

    private JPanel body;
    private JPanel header;
    private JPanel main;
    private JPanel footer;

    private white_back;
    private base_gray;

    public Gerenciador(){

	this.white_back = new Color( 217, 217, 217 );
	this.base_gray = new color ( 255, 255, 255 );

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

        Color rosa = new Color( 250, 52, 79, 98 );

        this.body.setBackground( this.white_back );

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

        Color quaseVermelho = new Color( 227, 57, 36, 89 );

        this.header.setBackground( this.base_gray );

    }

    private void initMain(){
        this.main = new JPanel();

        this.main.setLayout( new BorderLayout( 20, 20) );

        Dimension size = new Dimension(1280, 480);

        this.main.setPreferredSize(size);

        Color tipoLaranja = new Color( 253, 94, 40, 99 );

        this.main.setBackground( this.base_gray );

        JLabel txt = new JLabel("JURASSIC PARK");

        Font nfont = new Font("helvetica", Font.BOLD, 36);
        txt.setFont(nfont);

        // size = new Dimension(160, 90);
        // txt.setPreferredSize(size);

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

        north.setBackground(tipoLaranja);
        center.setBackground(tipoLaranja);
        south.setBackground(tipoLaranja);
        east.setBackground(tipoLaranja);
        west.setBackground(tipoLaranja);

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

        Color quaseVermelho = new Color( 227, 57, 36, 89 );

        this.footer.setBackground( this.base_gray );
    }
}
