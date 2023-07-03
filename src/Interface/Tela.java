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

    // Tamanho da tela
    protected int width;
    protected int height;

    public Tela( int width, int height ){
        this.initBody( width, height );
    }

    public Tela( int width, int height, Janela jan ){
        setJanela(jan);
        this.initBody(width, height);
    }

    public int getWidth(){
        return this.width;
    }

    public void setWidth( int width ){
        this.width = width;
    }

    public int getHeight(){
        return this.height;
    }

    public void setHeight( int height ){
        this.height = height;
    }

    public Janela getJanela(){
        return this.jan;
    }

    public void setJanela( Janela jan ){
        this.jan = jan;
    }

    private void initBody( int width, int height){
        this.body = new JPanel();

        this.bodyLayout = new SpringLayout();
        this.body.setLayout( this.bodyLayout );

        Dimension size = new Dimension( width, height );

        this.body.setPreferredSize(size);

        this.body.setBackground( Estilo.branco );

        this.initHeader( width, (int) height/100 * 11 );
        this.initMain( width, (int) height/100 * 67 );
        this.initFooter( width, (int) height/100 * 11 );

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

    private void initHeader( int width, int height){
        this.header = new JPanel();

        Dimension size = new Dimension( width , height);

        this.header.setPreferredSize(size);

        this.header.setBackground( Estilo.vermelhao );

    }

    private void initMain( int width, int height){

        // Definindo a área main
        this.main = new JPanel();

        this.main.setLayout( new BorderLayout( 0, 0) );

        Dimension size = new Dimension( width , height);

        this.main.setPreferredSize(size);

        this.main.setBackground( Estilo.vermelhao );        

        // Definindo regiões na faixa central da tela
        this.north = new JPanel();
        this.center = new JPanel();
        this.south = new JPanel();
        this.east = new JPanel();
        this.west = new JPanel();

        int majorWidth = (int) this.main.getPreferredSize().getWidth();
        int majorHeight = (int) this.main.getPreferredSize().getHeight();

        // Definindo os tamnanhos de cada região na área main
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

        // Definindo as cores
        this.north.setBackground( Estilo.vermelhao );
        this.center.setBackground( Estilo.vermelhao );
        this.south.setBackground( Estilo.vermelhao );
        this.east.setBackground( Estilo.vermelhao );
        this.west.setBackground( Estilo.vermelhao );

        // Adicionando as regiões na main
        this.main.add(this.north, BorderLayout.NORTH);
        this.main.add(this.center, BorderLayout.CENTER);
        this.main.add(this.south, BorderLayout.SOUTH);
        this.main.add(this.east, BorderLayout.EAST);
        this.main.add(this.west, BorderLayout.WEST);

    }

    private void initFooter( int width, int height){
        this.footer = new JPanel();

        Dimension size = new Dimension( width , height);

        this.footer.setPreferredSize(size);

        this.footer.setBackground( Estilo.vermelhao );
    }

    // Utilitária de reset
    private void resetHeader(){
        this.body.remove( this.header );
        this.initHeader( width, (int) height/100 * 11 );
        this.body.add(this.header);
    }

    // Utilitária de reset
    public void resetMain(){
        this.body.remove( this.main );
        this.initMain( width, (int) height/100 * 78 );
        this.body.add(this.main);
        // Posicionando o main no centro da tela
        this.bodyLayout.putConstraint( SpringLayout.VERTICAL_CENTER, this.main, 0, SpringLayout.VERTICAL_CENTER, this.body);
        this.bodyLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, this.main, 0, SpringLayout.HORIZONTAL_CENTER, this.body);
    }

    // Utilitária de reset
    private void resetFooter(){
        this.body.remove( this.footer );
        this.initFooter( width, (int) height/100 * 11 );
        this.body.add(this.footer);
    }

    // Utilitária de reset
    private void resetAll(){
        this.resetHeader();
        this.resetMain();
        this.resetFooter();
    }
}