package src.Interface;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import java.awt.Dimension;
import java.awt.BorderLayout;

// Todas as telas devem estender esta classe!
// A partir desta, deve-se adicionar o que for necessário para cada uma.

public class Tela {

    protected JPanel body;

    protected SpringLayout bodyLayout;

    protected JPanel header;
    protected JPanel main;
    protected JPanel footer;

    protected SpringLayout headerLayout;
    protected SpringLayout centerLayout;
    protected SpringLayout footerLayout;

    // Estas regiões são referentes ao painel main!
    protected JPanel north;
    protected JPanel center;
    protected JPanel south;
    protected JPanel east;
    protected JPanel west;

    // Janela
    // A principal função é permitir o contato com a janela principal
    // Em especial, vai servir para a execução das ações a partir dos eventos
    protected Janela jan;

    public Tela(){
        this.initBody();
    }

    public Tela( Janela jan ){
        this.initBody();
        setJanela(jan);
    }

    public Janela getJanela(){
        return this.jan;
    }

    public void setJanela( Janela jan ){
        this.jan = jan;
    }

    private void initBody(){
        this.body = new JPanel();

        this.bodyLayout = new SpringLayout();
        this.body.setLayout( this.bodyLayout );

        Dimension size = new Dimension(1280, 720);

        this.body.setPreferredSize(size);

        this.body.setBackground( Estilo.branco );

        this.initHeader();
        this.initMain();
        this.initFooter();

        this.body.add(this.header);
        this.body.add(this.main);
        this.body.add(this.footer);

        // Posicionando o header no topo da tela
        this.bodyLayout.putConstraint( SpringLayout.NORTH, this.header, 0, SpringLayout.NORTH, this.body);
        this.bodyLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, this.header, 0, SpringLayout.HORIZONTAL_CENTER, this.body);

        // Posicionando o main no centro da tela
        this.bodyLayout.putConstraint( SpringLayout.VERTICAL_CENTER, this.main, 0, SpringLayout.VERTICAL_CENTER, this.body);
        this.bodyLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, this.main, 0, SpringLayout.HORIZONTAL_CENTER, this.body);

        // Posicionando o foot no fundo da tela
        this.bodyLayout.putConstraint( SpringLayout.SOUTH, this.footer, 0, SpringLayout.SOUTH, this.body);
        this.bodyLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, this.footer, 0, SpringLayout.HORIZONTAL_CENTER, this.body);
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

        this.centerLayout = new SpringLayout();

        this.center.setLayout( centerLayout );

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

    private void resetHeader(){
        this.initHeader();
        this.body.add(this.header, BorderLayout.NORTH);
    }

    private void resetMain(){
        this.initMain();
        this.body.add(this.main, BorderLayout.CENTER);
    }

    private void resetFooter(){
        this.initFooter();
        this.body.add(this.footer, BorderLayout.SOUTH);
    }

    private void resetAll(){
        this.resetHeader();
        this.resetMain();
        this.resetFooter();
    }
}