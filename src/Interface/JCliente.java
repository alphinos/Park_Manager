package src.Interface;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;

import src.Atracao;
import src.Parque;
import src.Visitante;
import src.Telas.Cliente.CTAtracoesCliente;
import src.Telas.Cliente.CTBilheteriaCliente;
import src.Telas.Cliente.CTCarregarCliente;
import src.Telas.Cliente.CTComecoCliente;
import src.Telas.Cliente.CTInicioCliente;
import src.Telas.Cliente.CTNovoCliente;

public class JCliente extends Janela {

    private CTInicioCliente inicio;
    private CTNovoCliente novoCliente;
    private CTCarregarCliente carregarCliente;
    private CTComecoCliente comecoCliente;
    private CTBilheteriaCliente bilheteriaCliente;
    private CTAtracoesCliente atracoesCliente;

    private Visitante cliente;
    private Parque parque;
    private int ID_atrac;
    private HashMap<Integer, Atracao> atracoes;
    
    public JCliente( int width, int height){
        super( width, height );
        this.janela.setDefaultCloseOperation( JFrame.HIDE_ON_CLOSE );

        this.janela.setTitle("Simulador Cliente");
        this.atracoes = new HashMap<Integer, Atracao>();

        this.initTelas();
        this.setTela( this.inicio );
    }

    public JCliente( int width, int height, Tela tela ){
        super( width, height, tela );
        this.janela.setDefaultCloseOperation( JFrame.HIDE_ON_CLOSE );

        this.janela.setTitle("Simulador Cliente");
        this.atracoes = new HashMap<Integer, Atracao>();
    }

    public JCliente( int width, int height, Tela tela, String nome ){
        super( width, height, tela, nome );
        this.janela.setDefaultCloseOperation( JFrame.HIDE_ON_CLOSE );

        this.janela.setTitle("Simulador Cliente");
        this.atracoes = new HashMap<Integer, Atracao>();
    }

    public void initTelas(){
        this.inicio = new CTInicioCliente( this.width, this.height, this );
        this.novoCliente = new CTNovoCliente( this.width, this.height, this );
        this.carregarCliente = new CTCarregarCliente( this.width, this.height, this );
    }

    public Parque getParque(){
        return this.parque;
    }

    public void setParque( Parque parque ){
        this.parque = parque;
    }

    public Visitante getVisitante(){
        return this.cliente;
    }

    public void setVisitante( Visitante cliente ){
        this.cliente = cliente;
    }

    public void setIDAtrac( int ID ){
        this.ID_atrac = ID;
    }

    public void setAtracoes( HashMap< Integer, Atracao >atracoes ){
        this.atracoes = atracoes;
    }

    public void setAtracoes( ArrayList<Atracao> atracoes ){
        for ( Atracao a : atracoes ){
            this.atracoes.put( a.getID(), a );
        }
    }

    public void trocarTela( String tela ){
        this.janela.remove( this.tela.body );

        switch ( tela ){
            case "inicio":
                this.inicio = new CTInicioCliente( this.width, this.height, this );
                this.tela = this.inicio;
                break;
            case "novo_Cliente":
                this.novoCliente = new CTNovoCliente( this.width, this.height, this );
                this.tela = this.novoCliente;
                break;
            case "carregar_Cliente":
                this.carregarCliente = new CTCarregarCliente( this.width, this.height, this );
                this.tela = this.carregarCliente;
                break;
            case "Começo":
                this.comecoCliente = new CTComecoCliente( this.width, this.height, this, this.cliente);
                this.tela = this.comecoCliente;
                break;
            case "Bilheteria":
                this.bilheteriaCliente = new CTBilheteriaCliente( this.width, this.height, this, this.cliente, this.parque );
                this.tela = this.bilheteriaCliente;
                break;
            case "Atrações":
                this.atracoesCliente = new CTAtracoesCliente( this.width, this.height, this, this.parque, this.atracoes.get( this.ID_atrac ), this.cliente);
                this.tela = this.atracoesCliente;
                break;
        }

        this.janela.add( this.tela.body );
        this.janela.setVisible(true);

        if ( tela == "carregar_Cliente" ){
            this.carregarCliente.showChooser();
        }
    }
}
