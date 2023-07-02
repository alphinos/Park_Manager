package src.Interface;

import src.Parque;
import src.Telas.AbrirParque;
import src.Telas.Comeco;
import src.Telas.Inicio;
import src.Telas.NovoParque;

public class Gerente extends Janela {

    private Inicio Inicio;
    private NovoParque NovoParque;
    private AbrirParque AbrirParque;
    private Comeco Tela_Comeco;
    // private Tela Cliente;

    private Parque parque;
    private Cliente cliente;

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
        this.janela.setVisible( true );
    }

    public Gerente( int width, int height, Tela tela, String nome ){
        super( width, height, tela, nome );

        this.janela.setTitle( "Gerente" );

        this.initTelas();
        this.janela.setVisible( true );
    }

    public Parque getParque(){
        return this.parque;
    }

    public void setParque( Parque parque ){
        this.parque = parque;
    }

    public Cliente getCliente(){
        return this.cliente;
    }

    public void setCliente( Cliente cliente ){
        this.cliente = cliente;
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
            case "Começo":
                this.Tela_Comeco = new Comeco( this.width, this.height, this, this.parque);
                this.tela = this.Tela_Comeco;
                break;
            case "Novo_Cliente":
                this.cliente.getJanela().setVisible( true );
                break;
        }

        this.janela.add( this.tela.body );
        this.janela.setVisible(true);

        if ( tela == "abrir_parque" ){
            this.AbrirParque.showChooser();
        }
    }
}
