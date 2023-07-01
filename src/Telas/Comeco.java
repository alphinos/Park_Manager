package src.Telas;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import src.Parque;
import src.Interface.Estilo;
import src.Interface.Janela;
import src.Interface.Tela;

public class Comeco extends Tela {

    private JLabel nomeParque;

    private JButton JB_comeco;
    private JButton JB_parque;
    private JButton JB_atracoes;
    private JButton JB_cliente;

    private JPanel imagemParque;

    private JLabel descricao;
    private JPanel areaDescTxt;
    private JTextArea DescTxt;

    private JLabel preco;
    private JLabel precoValor;

    private JLabel visitantes;
    private JLabel qtdVisitante;

    private Parque parque;

    public Comeco( int width, int height ){
        super( width, height);
        this.start();
    }

    public Comeco( int width, int height, Janela jan ){
        super( width, height, jan );
        this.start();
    }

    public Comeco( int width, int height, Janela jan, Parque parque ){
        super( width, height, jan );
        this.parque = parque;
        this.start();
    }

    public Parque getParque(){
        return this.parque;
    }

    public void setParque( Parque parque ){
        this.parque = parque;
    }

    private void start(){
        String nomeParque = parque.getNome();
        String descParque = parque.getDescricao();
        String precoFicha = "R$" + parque.getPrecoFicha();
        int qtdVisitantes = parque.getQtdVisitantes();

        this.nomeParque = new JLabel( nomeParque );
        this.DescTxt = new JTextArea( descParque );
        
    }

    private void initBotoes(){
        this.JB_comeco = new JButton( "Começo" );
        this.JB_parque = new JButton( "Parque" );
        this.JB_atracoes = new JButton( "Atrações" );
        this.JB_cliente = new JButton( "Cliente" );

        this.JB_comeco.setBackground( Estilo.quaseBranco );
        this.JB_comeco.setForeground( Estilo.vermelhinho );
        this.JB_comeco.setFont( Estilo.robotoButton );

        this.JB_parque.setBackground( Estilo.vermelhinho );
        this.JB_parque.setForeground( Estilo.quaseBranco );
        this.JB_parque.setFont( Estilo.robotoButton );

        this.JB_parque.setBackground( Estilo.vermelhinho );
        this.JB_parque.setForeground( Estilo.quaseBranco );
        this.JB_parque.setFont( Estilo.robotoButton );

        this.JB_comeco.setBackground( Estilo.verdao );
        this.JB_comeco.setForeground( Estilo.branco );
        this.JB_comeco.setFont( Estilo.robotoButton );

        Dimension dimension = new Dimension( 128, 63 );

        this.JB_comeco.setPreferredSize(dimension);
        this.JB_parque.setPreferredSize(dimension);
        this.JB_atracoes.setPreferredSize(dimension);
        this.JB_cliente.setPreferredSize(dimension);
    }

    private void posHeader(){

    }
}
