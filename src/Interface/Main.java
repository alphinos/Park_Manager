package src.Interface;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

public class Main extends JPanel {
    private Dimension size;

    private JPanel north;
    private JPanel center;
    private JPanel south;
    private JPanel east;
    private JPanel west;
    
    public Main(){
        super();
        this.initRegioes();
    }

    public Main( Dimension size ){
        super();
        this.setSize( size );
        this.setLayout( new BorderLayout() );
        this.initRegioes();
    }

    public Main( int width, int height ){
        super();
        this.setSize( width, height );
        this.setLayout( new BorderLayout() );
        this.initRegioes();
    }

    public Main( int width, int height, int hgap, int vgap ){
        super();
        this.setSize( width, height );
        this.setLayout( new BorderLayout( hgap, vgap) );
        this.initRegioes();
    }

    public Dimension getSize(){
        return this.size;
    }

    public void setSize( Dimension size ){
        this.size = size;
        this.setPreferredSize(this.size);
    }

    public void setSize( int width, int height ){
        if ( width < 0 || height < 0 ){
            System.out.println( "Tamanhos inválidos!" );
            return;
        }
        this.setSize( new Dimension( width, height ) );
    }

    private void initRegioes(){
        this.north = new JPanel();
        this.center = new JPanel();
        this.south = new JPanel();
        this.east = new JPanel();
        this.west = new JPanel();

        int majorWidth = (int) this.getPreferredSize().getWidth();
        int majorHeight = (int) this.getPreferredSize().getHeight();

        size = new Dimension(majorWidth , majorHeight/100 * 25);

        north.setPreferredSize( size );

        size = new Dimension(majorWidth/100 * 50 , majorHeight/100 * 50);

        center.setPreferredSize( size );

        size = new Dimension(majorWidth , majorHeight/100 * 25);

        south.setPreferredSize( size );

        size = new Dimension(majorWidth/100 * 25 , majorHeight/100 * 50);

        east.setPreferredSize( size );
        west.setPreferredSize( size );

        this.estiloRegioes();

        this.add(north, BorderLayout.NORTH);
        this.add(center, BorderLayout.CENTER);
        this.add(south, BorderLayout.SOUTH);
        this.add(east, BorderLayout.EAST);
        this.add(west, BorderLayout.WEST);
    }

    private void estiloRegioes(){
        north.setBackground( Estilo.vermelhao );
        center.setBackground( Estilo.vermelhao );
        south.setBackground( Estilo.vermelhao );
        east.setBackground( Estilo.vermelhao );
        west.setBackground( Estilo.vermelhao );
    }
}
