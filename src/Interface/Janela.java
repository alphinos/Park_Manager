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

    private Inicio Inicio;
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

        // this.setupGlass();

        this.tela = this.Inicio;

        this.janela.add( this.tela.body );

        this.janela.setVisible(true);
    }

    public Janela( Tela tela ){
        this.janela = new JFrame("Gerenciador");
        this.janela.setSize(1280, 720);
        this.janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.initTelas();

        // this.setupGlass();

        this.tela = tela;
        this.tela.setJanela( this );

        this.janela.add( this.tela.body );

        this.janela.setVisible(true);
    }

    public void initTelas(){
        this.Inicio = new Inicio( this );
        this.NovoParque = new NovoParque( this );
        this.AbrirParque = new AbrirParque( this );
    }

    // Este método só é chamado quando acontece algum evento em uma determinada tela
    public void trocarTela( String tela ){

        // this.setGlassVisible(false);
        this.janela.remove( this.tela.body );

        switch ( tela ){
            case "inicio":
                this.Inicio = new Inicio( this );
                this.tela = this.Inicio;
                break;
            case "novo_parque":
                this.NovoParque = new NovoParque( this );
                this.tela = this.NovoParque;
                break;
            case "abrir_parque":
                this.AbrirParque = new AbrirParque( this );
                this.tela = this.AbrirParque;
                break;
        }

        this.janela.add( this.tela.body );
        this.janela.setVisible(true);

        if ( tela == "abrir_parque" ){
            this.AbrirParque.showChooser();
        }
    }

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
