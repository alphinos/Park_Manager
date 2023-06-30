package src.Interface;

import javax.swing.JFrame;

import src.Telas.AbrirParque;
import src.Telas.Inicio;
import src.Telas.NovoParque;

public class Gerente extends Janela {

    private Inicio Inicio;
    private NovoParque NovoParque;
    private AbrirParque AbrirParque;
    // private Tela Gerenciar;
    // private Tela Cliente;

    public Gerente( int width, int height){
        super( width, height );

        this.janela.setTitle( "Gerente" );
        
        this.initTelas();
        this.tela = this.Inicio;
        this.setTela( this.tela );
        this.janela.setVisible( true );
    }

    public Gerente( int width, int height, Tela tela ){
        super( width, height, tela );
        
        this.janela.setTitle( "Gerente" );
        
        this.initTelas();
    }

    public Gerente( int width, int height, Tela tela, String nome ){
        super( width, height, tela, nome );

        this.janela.setTitle( "Gerente" );

        this.initTelas();
    }

    public void initTelas(){
        this.Inicio = new Inicio( this.width, this.height, this );
        this.NovoParque = new NovoParque( this.width, this.height, this );
        this.AbrirParque = new AbrirParque( this.width, this.height, this );
    }

    // Este método só é chamado quando acontece algum evento em uma determinada tela
    public void trocarTela( String tela ){

        // this.setGlassVisible(false);
        this.janela.remove( this.tela.body );

        switch ( tela ){
            case "inicio":
                this.Inicio = new Inicio( this.width, this.height, this );
                this.tela = this.Inicio;
                break;
            case "novo_parque":
                this.NovoParque = new NovoParque( this.width, this.height, this );
                this.tela = this.NovoParque;
                break;
            case "abrir_parque":
                this.AbrirParque = new AbrirParque( this.width, this.height, this );
                this.tela = this.AbrirParque;
                break;
        }

        this.janela.add( this.tela.body );
        this.janela.setVisible(true);

        if ( tela == "abrir_parque" ){
            this.AbrirParque.showChooser();
        }
    }
}
