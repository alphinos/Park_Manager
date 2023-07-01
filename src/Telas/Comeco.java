package src.Telas;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

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
    private JLabel qtdVisitantes;

    private Parque parque;

    public Comeco( int width, int height ){
        super( width, height);
    }

    public Comeco( int width, int height, Janela jan ){
        super( width, height, jan );
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

    public void start(){
        this.initLabelsTextos();
        this.initBotoes();

        this.headerLayout = new SpringLayout();
        this.header.setLayout( headerLayout );

        this.header.add( this.nomeParque );
        this.header.add( this.JB_comeco );
        this.header.add( this.JB_parque );
        this.header.add( this.JB_atracoes );
        this.header.add( this.JB_cliente );

        this.headerLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, this.nomeParque, this.header.getWidth()/4, SpringLayout.HORIZONTAL_CENTER, body);
        this.headerLayout.putConstraint( SpringLayout.VERTICAL_CENTER, this.nomeParque, 0, SpringLayout.VERTICAL_CENTER, body);
    }

    private void initLabelsTextos(){
        String nomeParque = parque.getNome();
        String descParque = parque.getDescricao();
        String precoFicha = parque.getPrecoFichaFormat();
        String qtdVisitantes = Integer.toString( parque.getQtdVisitantes() );

        this.nomeParque = new JLabel( nomeParque );    
        this.descricao = new JLabel( "DESCRIÇÃO" );
        this.DescTxt = new JTextArea();
        this.DescTxt.setText( descParque );

        this.preco = new JLabel( "Preço por ficha:" );
        this.precoValor = new JLabel( precoFicha );

        this.visitantes = new JLabel( "Visitantes no parque" );
        this.qtdVisitantes = new JLabel( qtdVisitantes );

        this.nomeParque.setForeground( Estilo.branco );
        this.nomeParque.setFont( Estilo.robotoTitle );

        this.descricao.setForeground( Estilo.branco );
        this.descricao.setFont( Estilo.robotoTitle );

        this.DescTxt.setBackground( Estilo.vermelhinho );
        this.DescTxt.setFont( Estilo.robotoText );
        this.DescTxt.setForeground( Estilo.branco );

        this.preco.setBackground( Estilo.vermelhinho );
        this.preco.setFont( Estilo.robotoLabel );
        this.preco.setForeground( Estilo.branco );

        this.precoValor.setBackground( Estilo.quaseBranco );
        this.precoValor.setFont( Estilo.robotoLabel );
        this.precoValor.setForeground( Estilo.vermelhinho );

        this.visitantes.setBackground( Estilo.vermelhinho );
        this.visitantes.setFont( Estilo.robotoLabel );
        this.visitantes.setForeground( Estilo.branco );

        this.qtdVisitantes.setBackground( Estilo.quaseBranco );
        this.qtdVisitantes.setFont( Estilo.robotoLabel );
        this.qtdVisitantes.setForeground( Estilo.vermelhinho );

        Dimension dim = new Dimension( 560, 270 );
        this.DescTxt.setPreferredSize(dim);

        dim = new Dimension( 352, 45 );
        this.preco.setPreferredSize(dim);
        this.precoValor.setPreferredSize(dim);
        this.visitantes.setPreferredSize(dim);
        this.qtdVisitantes.setPreferredSize(dim);
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
