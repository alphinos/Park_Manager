package src.Interface;

import javax.swing.JPanel;

import java.awt.Dimension;


public class Header extends JPanel {
    private Dimension size;

    public Header(){
        super();
    }

    public Header( Dimension size ){
        super();
        this.setSize( size );
    }

    public Header( int width, int height ){
        super();
        this.setSize( width, height );
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
}
