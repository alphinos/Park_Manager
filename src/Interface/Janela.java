package src.Interface;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

import src.Telas.AbrirParque;
import src.Telas.Inicio;
import src.Telas.NovoParque;

public class Janela {

    private JFrame janela;
    private Tela tela;

    private Inicio inicio;
    private NovoParque NovoParque;
    private AbrirParque AbrirParque;
    // private Tela Gerenciar;
    // private Tela Cliente;

    public JFrame getJanela(){
        return this.janela;
    }

    public Janela(){
        this.janela = new JFrame("Gerenciador");
        this.janela.setSize(1280, 720);
        this.janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.initTelas();


        this.tela = new Tela();
        this.tela.setJanela( this );

        this.janela.add( this.tela.body );

        this.janela.setVisible(true);
    }

    public Janela( Tela tela ){
        this.janela = new JFrame("Gerenciador");
        this.janela.setSize(1280, 720);
        this.janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.initTelas();
        this.setupGlass();

        this.tela = tela;
        this.tela.setJanela( this );

        this.janela.add( this.tela.body );

        this.janela.setVisible(true);
    }

    public void initTelas(){
        this.inicio = new Inicio( this );
        this.NovoParque = new NovoParque( this);
        this.AbrirParque = new AbrirParque( this);
    }

    public void trocarTela( String tela ){

        this.setGlassVisible(false);

        switch ( tela ){
            case "inicio":
                this.janela.remove( this.tela.body );
                this.tela = this.inicio;
                this.janela.add(this.tela.body);
                this.janela.setVisible(true);
                break;
            case "novo_parque":
                this.janela.remove( this.tela.body );
                this.tela = this.NovoParque;
                this.janela.add(this.tela.body);
                this.janela.setVisible(true);
                break;
            case "abrir_parque":
                this.janela.remove( this.tela.body );
                this.tela = this.AbrirParque;
                this.janela.add(this.tela.body);
                this.janela.setVisible(true);
                break;
        }
    }

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

    public void addComp( JComponent comp ){
        this.janela.add(comp);
    }
}
