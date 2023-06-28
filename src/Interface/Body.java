package src.Interface;

import java.awt.Dimension;

import javax.swing.JPanel;

public class Body extends JPanel {
    private Dimension size;
    
    public Body(){

    }

    public Dimension getSize(){
        return this.size;
    }

    public void setSize( Dimension size ){
        this.size = size;
    }

    public void setSize( int width, int height ){
        this.size = new Dimension( width, height );
    }
}
