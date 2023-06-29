package src.Interface;

import javax.swing.JPanel;

import java.awt.Dimension;

import java.awt.BorderLayout;

// Todas as telas devem estender esta classe!
// A partir desta, deve-se adicionar o que for necessário para cada uma.

public class Tela {

    protected JPanel body;
    protected JPanel header;
    protected JPanel main;
    protected JPanel footer;

    // Estas regiões são referentes ao painel main!
    protected JPanel north;
    protected JPanel center;
    protected JPanel south;
    protected JPanel east;
    protected JPanel west;

    public Tela(){
        this.initBody();
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

        this.main.setLayout( new BorderLayout( 0, 0) );

        Dimension size = new Dimension(1280, 480);

        this.main.setPreferredSize(size);

        this.main.setBackground( Estilo.vermelhao );        

        this.north = new JPanel();
        this.center = new JPanel();
        this.south = new JPanel();
        this.east = new JPanel();
        this.west = new JPanel();

        int majorWidth = (int) this.main.getPreferredSize().getWidth();
        int majorHeight = (int) this.main.getPreferredSize().getHeight();

        size = new Dimension(majorWidth , majorHeight/100 * 15);

        this.north.setPreferredSize( size );

        size = new Dimension(majorWidth/100 * 80 , majorHeight/100 * 70);

        this.center.setPreferredSize( size );

        size = new Dimension(majorWidth , majorHeight/100 * 15);

        this.south.setPreferredSize( size );

        size = new Dimension(majorWidth/100 * 10 , majorHeight/100 * 70);

        this.east.setPreferredSize( size );
        this.west.setPreferredSize( size );

        this.north.setBackground( Estilo.vermelhao );
        this.center.setBackground( Estilo.vermelhao );
        this.south.setBackground( Estilo.vermelhao );
        this.east.setBackground( Estilo.vermelhao );
        this.west.setBackground( Estilo.vermelhao );

        this.main.add(this.north, BorderLayout.NORTH);
        this.main.add(this.center, BorderLayout.CENTER);
        this.main.add(this.south, BorderLayout.SOUTH);
        this.main.add(this.east, BorderLayout.EAST);
        this.main.add(this.west, BorderLayout.WEST);

    }

    private void initFooter(){
        this.footer = new JPanel();

        Dimension size = new Dimension(1280, 80);

        this.footer.setPreferredSize(size);

        this.footer.setBackground( Estilo.vermelhao );
    }
}