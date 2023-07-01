package src.Interface;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

public abstract class Janela {

    protected JFrame janela;
    protected Tela tela;

    protected int width;
    protected int height;

    public Janela( int width, int height){
        this.janela = new JFrame();
        this.janela.setSize( width, height );
        this.janela.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        this.width = width;
        this.height = height;

        this.janela.setVisible(false);
    }

    public Janela( int width, int height, Tela tela ){
        this.janela = new JFrame();
        this.janela.setSize( width, height );
        this.janela.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        this.width = width;
        this.height = height;

        this.setTela( tela );

        this.janela.setVisible(false);
    }

    public Janela( int width, int height, Tela tela, String nome ){
        this.janela = new JFrame( nome );
        this.janela.setSize( width, height );
        this.janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.width = width;
        this.height = height;

        this.setTela( tela );

        this.janela.setVisible(false);
    }

    public JFrame getJanela(){
        return this.janela;
    }

    public void setTela( Tela tela ){
        this.tela = tela;
        this.tela.setJanela( this );
        this.janela.add( this.tela.body );
    }

    public abstract void initTelas();

    // Este método só é chamado quando acontece algum evento em uma determinada tela
    public abstract void trocarTela( String tela );

    // Basicamente, estes 2 métodos servem para adicionar uma camada escura sobre a janela
    // Atualmente, não são utilizados
    // Basicamente, um teste
    public void setupGlass(){
        this.janela.getRootPane().setGlassPane( new JComponent() {
            public void paintComponent( Graphics g){
                g.setColor( Estilo.preto_transparente );
                g.fillRect( 0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        } );
    }

    public void setGlassVisible( boolean b ){
        this.janela.getRootPane().getGlassPane().setVisible( b );
    }

    // Adiciona um compomente na janela de forma externa
    public void addComp( JComponent comp ){
        this.janela.add(comp);
    }

    // remove um compomente na janela de forma externa
    public void rmComp( JComponent comp ){
        this.janela.remove(comp);
    }
}
