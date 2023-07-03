package src.Interface;

import src.Atracao;
import src.Parque;
import src.Telas.TAbrirParque;
import src.Telas.TAtracoes;
import src.Telas.TComeco;
import src.Telas.TInicio;
import src.Telas.TNovoParque;
import src.Telas.TParque;

public class JGerente extends Janela {

    private TInicio Inicio;
    private TNovoParque NovoParque;
    private TAbrirParque AbrirParque;
    private TComeco Tela_Comeco;
    private TParque Aba_parque;
    private TAtracoes Tela_atracoes;

    private Parque parque;
    private JCliente cliente;

    private Atracao atual;

    public JGerente( int width, int height){
        super( width, height );

        this.janela.setTitle( "Gerente" );
        
        this.initTelas();
        this.tela = this.Inicio;
        this.setTela( this.tela );
        this.janela.setVisible( true );
        if ( !this.parque.getAtracoes().isEmpty() ){
            this.atual = this.parque.getAtracoes().get( 0 );
    }   else{
            this.atual = null;
        }
    }

    public JGerente( int width, int height, Tela tela ){
        super( width, height, tela );
        
        this.janela.setTitle( "Gerente" );
        
        this.initTelas();
        this.janela.setVisible( true );
        if ( !this.parque.getAtracoes().isEmpty() ){
            this.atual = this.parque.getAtracoes().get( 0 );
    }   else{
            this.atual = null;
        }
    }

    public JGerente( int width, int height, Tela tela, String nome ){
        super( width, height, tela, nome );

        this.janela.setTitle( "Gerente" );

        this.initTelas();
        this.janela.setVisible( true );
        if ( !this.parque.getAtracoes().isEmpty() ){
            this.atual = this.parque.getAtracoes().get( 0 );
    }   else{
            this.atual = null;
        }
    }

    public Parque getParque(){
        return this.parque;
    }

    public void setParque( Parque parque ){
        this.parque = parque;
    }

    public JCliente getCliente(){
        return this.cliente;
    }

    public void setCliente( JCliente cliente ){
        this.cliente = cliente;
    }

    public Atracao getAtual(){
        return this.atual;
    }

    public void setAtual( Atracao atual ){
        this.atual = atual;
    }

    public void initTelas(){
        this.Inicio = new TInicio( this.width, this.height, this );
        this.NovoParque = new TNovoParque( this.width, this.height, this );
        this.AbrirParque = new TAbrirParque( this.width, this.height, this );
    }

    // Este método só é chamado quando acontece algum evento em uma determinada tela
    public void trocarTela( String tela ){

        // this.setGlassVisible(false);
        this.janela.remove( this.tela.body );

        switch ( tela ){
            case "inicio":
                this.Inicio = new TInicio( this.width, this.height, this );
                this.tela = this.Inicio;
                break;
            case "novo_parque":
                this.NovoParque = new TNovoParque( this.width, this.height, this );
                this.tela = this.NovoParque;
                break;
            case "abrir_parque":
                this.AbrirParque = new TAbrirParque( this.width, this.height, this );
                this.tela = this.AbrirParque;
                break;
            case "Começo":
                this.Tela_Comeco = new TComeco( this.width, this.height, this, this.parque );
                this.tela = this.Tela_Comeco;
                break;
            case "Aba_parque":
                this.Aba_parque = new TParque( this.width, this.height, this, this.parque );
                this.tela = this.Aba_parque;
                break;
            case "Aba_atrações":
                this.Tela_atracoes = new TAtracoes( this.width, this.height, this, this.parque, this.atual );
                this.tela = this.Tela_atracoes;
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
