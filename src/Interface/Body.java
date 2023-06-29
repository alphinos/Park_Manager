package src.Interface;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

// Body é um painel padrão que tenta simular o body do html, só que muito mais simples
// A ideia é que todos os componentes sejam colocados aqui
// Em especial, aqui devem ser adicionados apenas novos painéis para manter a organização
// Todas as telas devem ter um painel body, um painel header, um painel main e um painel footer

public class Body extends JPanel {
    private Dimension size;
    
    public Body(){
        super();
    }

    public Body( Dimension size ){
        super();
        this.setLayout( new BorderLayout() );
        this.setSize( size );
    }

    public Body( int width, int height ){
        super();
        this.setLayout( new BorderLayout() );
        this.setSize( width, height );
    }

    public Body( int width, int height, int hgap, int vgap ){
        super();
        this.setLayout( new BorderLayout( hgap, vgap ) );
        this.setSize( width, height );
    }

    public Dimension getSize(){
        return this.size;
    }

    public void setSize( Dimension size ){
        this.size = size;
        this.setPreferredSize(this.size);

        int majorWidth = (int) this.getPreferredSize().getWidth();
        int majorHeight = (int) this.getPreferredSize().getHeight();

        System.out.println( majorWidth + "\n" + majorHeight);
    }

    public void setSize( int width, int height ){
        if ( width < 0 || height < 0 ){
            System.out.println( "Tamanhos inválidos!" );
            return;
        }
        this.setSize( new Dimension( width, height ) );
    }
}
