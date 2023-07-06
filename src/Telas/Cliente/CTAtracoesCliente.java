package src.Telas.Cliente;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import src.Atracao;
import src.Brinquedo;
import src.Parque;
import src.Restaurante;
import src.Visitante;
import src.Interface.Estilo;
import src.Interface.JCliente;
import src.Interface.JGerente;
import src.Interface.Janela;
import src.Interface.Tela;

public class CTAtracoesCliente extends Tela implements ActionListener {

    private Parque parque;
    private Atracao atual;
    private Visitante cliente;

    // Header
    private JLabel nomeCliente;

    // Botões do header - basicamente, um menu
    private JButton JB_comeco;
    private JButton JB_bilheteria;
    private JButton JB_atracoes;

    // Main
    private JLabel JL_nome_atracao;     // Depende da atração
    private JPanel JP_detalhe_atracao;  // Depende da atração
    private SpringLayout atracLayout;

    // Atração
    private JLabel JL_id;
    private JLabel JL_preco;

    private JTextArea JTA_desc ;

    private JLabel JL_capacidade;
    private JLabel JL_ocupacao;

    private JLabel JL_abertura;
    private JLabel JL_fechamento;

    // Brinquedo
    private JLabel JL_idade_min;
    private JLabel JL_altura_min;
    private JLabel JL_altura_max;
    private JLabel JL_entropia;

    // Selecionar atração
    private JPanel JP_atracoes;
    private JScrollPane JSP_atracoes;
    private ArrayList< Atracao > AL_atracoes;
    private ArrayList< JButton > ALJB_atracoes;

    // Restaurante
    private JScrollPane JSP_cardapio;
    private JPanel JP_cardapio;
    private JLabel JL_titulo;
    private ArrayList< JButton > JB_pratos;
    private ArrayList< JLabel > ALJL_precos;

    // Main
    private JButton JB_visitarParque;      // Nova janela para criação de atração

    // Footer
    private JLabel fichas;
    private JLabel qtd_fichas;
    
    public CTAtracoesCliente( int width, int height ){
        super( width, height);
        this.atual = null;
        this.AL_atracoes = new ArrayList< Atracao >();
        this.ALJB_atracoes = new ArrayList< JButton >();
        ( (JGerente) this.jan ).getCliente().setParque( this.parque );
    }

    public CTAtracoesCliente( int width, int height, Janela jan ){
        super( width, height, jan );
        this.atual = null;
        this.AL_atracoes = new ArrayList< Atracao >();
        this.ALJB_atracoes = new ArrayList< JButton >();
        ( (JGerente) this.jan ).getCliente().setParque( this.parque );
    }

    public CTAtracoesCliente( int width, int height, Janela jan, Parque parque, Visitante cliente ){
        super( width, height, jan );
        this.parque = parque;
        this.cliente = cliente;
        this.atual = null;
        this.AL_atracoes = new ArrayList< Atracao >();
        this.ALJB_atracoes = new ArrayList< JButton >();
        this.start();
        ( (JGerente) this.jan ).getCliente().setParque( this.parque );
    }

    public CTAtracoesCliente( int width, int height, Janela jan, Parque parque, Atracao atual, Visitante cliente ){
        super( width, height, jan );
        this.parque = parque;
        this.atual = atual;
        this.cliente = cliente;
        this.AL_atracoes = new ArrayList< Atracao >();
        this.ALJB_atracoes = new ArrayList< JButton >();
        this.start();
    }

    public void start(){
        this.initLabelsTextos();
        this.initBotoes();
        this.initHeader();
        this.initMain();
        this.initFooter();
    }

    private void initLabelsTextos(){
        String nomeCliente = this.cliente.getNome();
        String qtd_fichas = Integer.toString( this.cliente.getFichas() );

        this.nomeCliente = new JLabel( nomeCliente, SwingConstants.CENTER ); 

        this.fichas = new JLabel( "Fichas", SwingConstants.CENTER );
        this.qtd_fichas = new JLabel( qtd_fichas, SwingConstants.CENTER );

        this.nomeCliente.setBackground( Estilo.verdinho );
        this.nomeCliente.setForeground( Estilo.branco );
        this.nomeCliente.setFont( Estilo.robotoTitle );

        this.fichas.setBackground( Estilo.verdinho );
        this.fichas.setFont( Estilo.robotoLabel );
        this.fichas.setForeground( Estilo.preto );

        this.qtd_fichas.setBackground( Estilo.preto );
        this.qtd_fichas.setFont( Estilo.robotoLabel );
        this.qtd_fichas.setForeground( Estilo.verdinho );

        // 
        Dimension dim = new Dimension();

        // Tamanho dos labels de fichas
        dim = new Dimension( 352, 45 );
        this.fichas.setPreferredSize(dim);
        this.qtd_fichas.setPreferredSize(dim);

        // Tornando o fundo visível
        this.fichas.setOpaque( true );
        this.qtd_fichas.setOpaque( true );
    }

    private void initBotoes(){
        this.JB_comeco = new JButton( "Começo" );
        this.JB_bilheteria = new JButton( "Bilheteria" );
        this.JB_atracoes = new JButton( "Atrações" );

        // Configurando o fundo, fonte e cor dos textos
        this.JB_comeco.setBackground( Estilo.verdaozao );
        this.JB_comeco.setForeground( Estilo.quaseBranco );
        this.JB_comeco.setFont( Estilo.robotoButton );

        this.JB_bilheteria.setBackground( Estilo.verdaozao );
        this.JB_bilheteria.setForeground( Estilo.quaseBranco );
        this.JB_bilheteria.setFont( Estilo.robotoButton );

        this.JB_atracoes.setBackground( Estilo.quaseBranco );
        this.JB_atracoes.setForeground( Estilo.verdaozao );
        this.JB_atracoes.setFont( Estilo.robotoButton );

        // Configurando tamanhos
        Dimension dimension = new Dimension( 160, 63 );

        this.JB_comeco.setPreferredSize(dimension);
        this.JB_bilheteria.setPreferredSize(dimension);
        this.JB_atracoes.setPreferredSize(dimension);

        // Removendo as linhas de borda
        this.JB_comeco.setBorderPainted(false);
        this.JB_bilheteria.setBorderPainted(false);
        this.JB_atracoes.setBorderPainted(false);

        this.JB_comeco.addActionListener( this );
        this.JB_bilheteria.addActionListener( this );
        this.JB_atracoes.addActionListener( this );
    }

    private void initHeader(){
        this.header.setBackground( Estilo.verdao );

        this.headerLayout = new SpringLayout();
        this.header.setLayout( headerLayout );

        // Adicionando os componentes ao header
        this.header.add( this.nomeCliente );
        this.header.add( this.JB_comeco );
        this.header.add( this.JB_bilheteria );
        this.header.add( this.JB_atracoes );

        // Posicionando os elementos no painel "header"
        this.headerLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, this.nomeCliente, -320, SpringLayout.HORIZONTAL_CENTER, this.header);
        this.headerLayout.putConstraint( SpringLayout.VERTICAL_CENTER, this.nomeCliente, 0, SpringLayout.VERTICAL_CENTER, this.header);

        this.headerLayout.putConstraint( SpringLayout.WEST, this.JB_comeco, 32, SpringLayout.HORIZONTAL_CENTER, this.header );
        this.headerLayout.putConstraint( SpringLayout.VERTICAL_CENTER, this.JB_comeco, 0, SpringLayout.VERTICAL_CENTER, this.header);

        this.headerLayout.putConstraint( SpringLayout.WEST, this.JB_bilheteria, 16, SpringLayout.EAST, this.JB_comeco );
        this.headerLayout.putConstraint( SpringLayout.VERTICAL_CENTER, this.JB_bilheteria, 0, SpringLayout.VERTICAL_CENTER, this.JB_comeco);

        this.headerLayout.putConstraint( SpringLayout.WEST, this.JB_atracoes, 16, SpringLayout.EAST, this.JB_bilheteria );
        this.headerLayout.putConstraint( SpringLayout.VERTICAL_CENTER, this.JB_atracoes, 0, SpringLayout.VERTICAL_CENTER, this.JB_comeco);
    }

    private void initMain(){

        this.center.setBackground( Estilo.verdao );

        this.main.remove( this.north );
        this.main.remove( this.south );
        this.main.remove( this.west );
        this.main.remove( this.east );

        this.centerLayout = new SpringLayout();
        this.center.setLayout( this.centerLayout );

        this.JL_nome_atracao = new JLabel(  );     // Depende da atração
        this.JP_detalhe_atracao = new JPanel(  );  // Depende da atração

        this.JB_visitarParque = new JButton( "Visitar atração" );

        Dimension dimension;
        
        // Nome da atração
        dimension = new Dimension( 688, 72 );
        this.JL_nome_atracao.setPreferredSize( dimension );
        this.JL_nome_atracao.setForeground( Estilo.verdinho );
        this.JL_nome_atracao.setBackground( Estilo.preto );
        this.JL_nome_atracao.setFont( Estilo.robotoTitle );
        this.JL_nome_atracao.setHorizontalAlignment( SwingConstants.CENTER );
        this.JL_nome_atracao.setOpaque( true );

        // Area detalhes
        dimension = new Dimension( 688, 360 );
        this.JP_detalhe_atracao.setPreferredSize( dimension );
        this.JP_detalhe_atracao.setBackground( Estilo.preto );

        // Seleção de atrações
        this.JP_atracoes = new JPanel();
        this.JP_atracoes.setBackground( Estilo.preto );

        // Botões navegação
        dimension = new Dimension( 176, 45 );
        
        this.AL_atracoes = this.parque.getAtracoes();

        for ( Atracao atrac : this.AL_atracoes ){
            JButton b_atrac = new JButton( atrac.getNome() );
            b_atrac.setBackground( Estilo.verdinho );
            b_atrac.setForeground( Estilo.preto );
            b_atrac.setFont( Estilo.robotoButton );
            b_atrac.setHorizontalAlignment( SwingConstants.CENTER );
            b_atrac.setPreferredSize( dimension );
            b_atrac.addActionListener( this );
            this.ALJB_atracoes.add( b_atrac );
        }

        // Botões de criação e salvar
        dimension = new Dimension( 208, 72 );
        this.JB_visitarParque.setPreferredSize( dimension );
        this.JB_visitarParque.setForeground( Estilo.verdinho );
        this.JB_visitarParque.setBackground( Estilo.preto );
        this.JB_visitarParque.setFont( Estilo.robotoButton );
        this.JB_visitarParque.setHorizontalAlignment( SwingConstants.CENTER );
        this.JB_visitarParque.addActionListener( this );

        // Adicionando componente no painel de atrações
        SpringLayout atracoesLayout = new SpringLayout();
        this.JP_atracoes.setLayout( atracoesLayout );

        int size = this.AL_atracoes.size();

        dimension = new Dimension( 176, 45 );

        if ( size > 0 ){
            for ( int i = 0; i < size; i++ ){
                this.JP_atracoes.add( this.ALJB_atracoes.get( i ) );
                // this.ALJB_atracoes.get( i ).setPreferredSize( dimension );
                this.ALJB_atracoes.get( i ).setAlignmentX( Component.CENTER_ALIGNMENT );
            }
        }

        if ( size > 0 ){

            atracoesLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, this.ALJB_atracoes.get( 0 ) , 0, SpringLayout.HORIZONTAL_CENTER, this.JP_atracoes);
            atracoesLayout.putConstraint( SpringLayout.NORTH, this.ALJB_atracoes.get( 0 ) , 12, SpringLayout.NORTH, this.JP_atracoes);

            if ( size > 1 ){
                for ( int i = 1; i < size; i++ ){
                    atracoesLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, this.ALJB_atracoes.get( i ) , 0, SpringLayout.HORIZONTAL_CENTER, this.ALJB_atracoes.get( i - 1 ));
                    atracoesLayout.putConstraint( SpringLayout.NORTH, this.ALJB_atracoes.get( i ) , 12, SpringLayout.SOUTH, this.ALJB_atracoes.get( i - 1 ));
                }
            }
        }

        // Scroll Pane
        dimension = new Dimension( 224, 378 );

        this.JSP_atracoes = new JScrollPane( this.JP_atracoes );
        this.JSP_atracoes.setPreferredSize( dimension );

        this.JSP_atracoes.setBackground( Estilo.preto );
        this.JSP_atracoes.setForeground( Estilo.verdinho );

        this.JSP_atracoes.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        this.JSP_atracoes.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );

        this.JP_atracoes.setPreferredSize( new Dimension( 176, 12 + size * 57 ) );

        this.center.add( this.JSP_atracoes );

        // Posicionando os botões de seleção da atração
        this.centerLayout.putConstraint( SpringLayout.WEST, this.JSP_atracoes, 32, SpringLayout.EAST, this.JP_detalhe_atracao );
        this.centerLayout.putConstraint( SpringLayout.VERTICAL_CENTER, this.JSP_atracoes, 0, SpringLayout.VERTICAL_CENTER, this.center );

        Atracao atual;
        if ( this.atual != null ){
            this.JL_nome_atracao.setText( this.atual.getNome() );
            atual = this.atual;
                if ( atual instanceof Brinquedo ){
                this.initCardBrinquedo( (Brinquedo) this.atual );
            }
            if ( atual instanceof Restaurante ){
                this.initCardRestaurante( (Restaurante) this.atual );
            }
        } else {
            this.JL_nome_atracao.setText( "Parque vazio" );
        }

        this.center.add( this.JL_nome_atracao );
        this.center.add( this.JP_detalhe_atracao );
        this.center.add( this.JB_visitarParque );

        // Poisicionando detalhes da atração
        this.centerLayout.putConstraint( SpringLayout.WEST, this.JP_detalhe_atracao, 64, SpringLayout.WEST, this.center );
        this.centerLayout.putConstraint( SpringLayout.SOUTH, this.JP_detalhe_atracao, -16, SpringLayout.SOUTH, this.center);

        // Poisicionando nome da atração
        this.centerLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, this.JL_nome_atracao, 0, SpringLayout.HORIZONTAL_CENTER, this.JP_detalhe_atracao );
        this.centerLayout.putConstraint( SpringLayout.NORTH, this.JL_nome_atracao, 16, SpringLayout.NORTH, this.center);

        // Posicionando o botão do novo brinquedo
        this.centerLayout.putConstraint( SpringLayout.EAST, this.JB_visitarParque, -48, SpringLayout.EAST, this.center);
        this.centerLayout.putConstraint( SpringLayout.VERTICAL_CENTER, this.JB_visitarParque, 0, SpringLayout.VERTICAL_CENTER, this.center);
    }

    private void initCardAtracao( Atracao atrac ){

        this.atracLayout = new SpringLayout();
        this.JP_detalhe_atracao.setLayout( this.atracLayout );

        this.JL_id = new JLabel( "ID: " + atrac.getID() );
        this.JL_preco = new JLabel( "Preço: " + atrac.getPreco() );

        this.JTA_desc = new JTextArea( atrac.getDescricao() );

        this.JL_capacidade = new JLabel( "Capacidade: " + atrac.getCapacidade_max() );
        this.JL_ocupacao = new JLabel( "Ocupação: " + atrac.getOcupacaoAtual() );

        this.JL_abertura = new JLabel( "Abertura: " + atrac.getTimeString( atrac.getAbertura() ) );
        this.JL_fechamento = new JLabel( "Fechamento: " + atrac.getTimeString( atrac.getFechamento() ) );

        Dimension dimension;

        // id e preco
        dimension = new Dimension( 144, 27 );
        
        //id
        this.JL_id.setPreferredSize( dimension );
        this.JL_id.setBackground( Estilo.verdinho );
        this.JL_id.setForeground( Estilo.preto );
        this.JL_id.setFont( Estilo.robotoLabel );
        this.JL_id.setHorizontalAlignment( SwingConstants.CENTER );
        this.JL_id.setOpaque( true );

        //preco
        this.JL_preco.setPreferredSize( dimension );
        this.JL_preco.setBackground( Estilo.verdinho );
        this.JL_preco.setForeground( Estilo.preto );
        this.JL_preco.setFont( Estilo.robotoLabel );
        this.JL_preco.setHorizontalAlignment( SwingConstants.CENTER );
        this.JL_preco.setOpaque( true );

        // Descrição
        dimension = new Dimension( 413, 153 );

        this.JTA_desc.setPreferredSize( dimension );
        this.JTA_desc.setBackground( Estilo.verdinho );
        this.JTA_desc.setForeground( Estilo.preto );
        this.JTA_desc.setFont( Estilo.robotoText );
        this.JTA_desc.setEditable( false );

        this.JTA_desc.setMargin( new Insets( 8, 12, 8, 12 ) ); // Colocando a margem do texto
        this.JTA_desc.setLineWrap( true );                   // Para a quebra de linha do texto
        this.JTA_desc.setWrapStyleWord( true );              // Para a quebra de linha do texto

        // 4 JTF baixo
        dimension = new Dimension( 202, 27 );

        //Capacidade
        this.JL_capacidade.setPreferredSize( dimension );
        this.JL_capacidade.setBackground( Estilo.verdinho );
        this.JL_capacidade.setForeground( Estilo.preto );
        this.JL_capacidade.setFont( Estilo.robotoLabelData );
        this.JL_capacidade.setHorizontalAlignment( SwingConstants.CENTER );
        this.JL_capacidade.setOpaque( true );

        //Ocupação
        this.JL_ocupacao.setPreferredSize( dimension );
        this.JL_ocupacao.setBackground( Estilo.verdinho );
        this.JL_ocupacao.setForeground( Estilo.preto );
        this.JL_ocupacao.setFont( Estilo.robotoLabelData );
        this.JL_ocupacao.setHorizontalAlignment( SwingConstants.CENTER );
        this.JL_ocupacao.setOpaque( true );

        //Abertura
        this.JL_abertura.setPreferredSize( dimension );
        this.JL_abertura.setBackground( Estilo.verdinho );
        this.JL_abertura.setForeground( Estilo.preto );
        this.JL_abertura.setFont( Estilo.robotoLabelData );
        this.JL_abertura.setHorizontalAlignment( SwingConstants.CENTER );
        this.JL_abertura.setOpaque( true );

        //Fechamento
        this.JL_fechamento.setPreferredSize( dimension );
        this.JL_fechamento.setBackground( Estilo.verdinho );
        this.JL_fechamento.setForeground( Estilo.preto );
        this.JL_fechamento.setFont( Estilo.robotoLabelData );
        this.JL_fechamento.setHorizontalAlignment( SwingConstants.CENTER );
        this.JL_fechamento.setOpaque( true );

        this.JP_detalhe_atracao.add( this.JL_id );
        this.JP_detalhe_atracao.add( this.JL_preco );

        this.JP_detalhe_atracao.add( this.JTA_desc );

        this.JSP_atracoes = new JScrollPane( this.JP_cardapio );

        this.JP_detalhe_atracao.add( this.JL_capacidade );
        this.JP_detalhe_atracao.add( this.JL_ocupacao );
        this.JP_detalhe_atracao.add( this.JL_abertura );
        this.JP_detalhe_atracao.add( this.JL_fechamento );

        // Posicionando id
        this.atracLayout.putConstraint( SpringLayout.WEST, this.JL_id, 42, SpringLayout.WEST, this.JP_detalhe_atracao );
        this.atracLayout.putConstraint( SpringLayout.NORTH, this.JL_id, 34, SpringLayout.NORTH, this.JP_detalhe_atracao );

        // Posicionando descrição
        this.atracLayout.putConstraint( SpringLayout.WEST, this.JTA_desc, 0, SpringLayout.WEST, this.JL_id );
        this.atracLayout.putConstraint( SpringLayout.NORTH, this.JTA_desc, 0, SpringLayout.SOUTH, this.JL_id );

        // Posicionando preço
        this.atracLayout.putConstraint( SpringLayout.EAST, this.JL_preco, 0, SpringLayout.EAST, this.JTA_desc );
        this.atracLayout.putConstraint( SpringLayout.SOUTH, this.JL_preco, 0, SpringLayout.NORTH, this.JTA_desc );

        // Posicionando capacidade máxima
        this.atracLayout.putConstraint( SpringLayout.WEST, this.JL_capacidade, 0, SpringLayout.WEST, this.JTA_desc );
        this.atracLayout.putConstraint( SpringLayout.NORTH, this.JL_capacidade, 40, SpringLayout.SOUTH, this.JTA_desc );

        // Posicionando capacidade máxima
        this.atracLayout.putConstraint( SpringLayout.EAST, this.JL_ocupacao, 0, SpringLayout.EAST, this.JTA_desc );
        this.atracLayout.putConstraint( SpringLayout.NORTH, this.JL_ocupacao, 40, SpringLayout.SOUTH, this.JTA_desc );

        // Posicionando abertura
        this.atracLayout.putConstraint( SpringLayout.WEST, this.JL_abertura, 0, SpringLayout.WEST, this.JL_capacidade );
        this.atracLayout.putConstraint( SpringLayout.NORTH, this.JL_abertura, 40, SpringLayout.SOUTH, this.JL_capacidade );

        // Posicionando fechamento
        this.atracLayout.putConstraint( SpringLayout.EAST, this.JL_fechamento, 0, SpringLayout.EAST, this.JL_ocupacao );
        this.atracLayout.putConstraint( SpringLayout.NORTH, this.JL_fechamento, 40, SpringLayout.SOUTH, this.JL_ocupacao );
    }

    private void initCardBrinquedo( Brinquedo brinks ){
        this.initCardAtracao( brinks );

        this.JL_idade_min = new JLabel( "Idade mínima: " + brinks.getIdade_min() );
        this.JL_altura_max = new JLabel( "Altura máxima: " + brinks.getAltura_max() );
        this.JL_altura_min = new JLabel( "Altura mínima: " + brinks.getAltura_min() );
        this.JL_entropia = new JLabel( "Entropia: " + brinks.getEntropia() );

        Dimension dimension = new Dimension( 189, 27 );
        //Idade mínima
        this.JL_idade_min.setPreferredSize( dimension );
        this.JL_idade_min.setBackground( Estilo.verdinho );
        this.JL_idade_min.setForeground( Estilo.preto );
        this.JL_idade_min.setFont( Estilo.robotoLabelData );
        this.JL_idade_min.setHorizontalAlignment( SwingConstants.CENTER );
        this.JL_idade_min.setOpaque( true );

        //Altura máxima
        this.JL_altura_max.setPreferredSize( dimension );
        this.JL_altura_max.setBackground( Estilo.verdinho );
        this.JL_altura_max.setForeground( Estilo.preto );
        this.JL_altura_max.setFont( Estilo.robotoLabelData );
        this.JL_altura_max.setHorizontalAlignment( SwingConstants.CENTER );
        this.JL_altura_max.setOpaque( true );

        //Altura mínima
        this.JL_altura_min.setPreferredSize( dimension );
        this.JL_altura_min.setBackground( Estilo.verdinho );
        this.JL_altura_min.setForeground( Estilo.preto );
        this.JL_altura_min.setFont( Estilo.robotoLabelData );
        this.JL_altura_min.setHorizontalAlignment( SwingConstants.CENTER );
        this.JL_altura_min.setOpaque( true );

        this.JL_entropia.setPreferredSize( dimension );
        this.JL_entropia.setBackground( Estilo.verdinho );
        this.JL_entropia.setForeground( Estilo.preto );
        this.JL_entropia.setFont( Estilo.robotoLabelData );
        this.JL_entropia.setHorizontalAlignment( SwingConstants.CENTER );
        this.JL_entropia.setOpaque( true );

        this.JP_detalhe_atracao.add( this.JL_idade_min );
        this.JP_detalhe_atracao.add( this.JL_altura_max );
        this.JP_detalhe_atracao.add( this.JL_altura_min );
        this.JP_detalhe_atracao.add( this.JL_entropia );

        // Poicionando a altura mínima
        this.atracLayout.putConstraint( SpringLayout.EAST, this.JL_altura_max, -23, SpringLayout.EAST, this.JP_detalhe_atracao );
        this.atracLayout.putConstraint( SpringLayout.VERTICAL_CENTER, this.JL_altura_max, 0, SpringLayout.VERTICAL_CENTER, this.JP_detalhe_atracao );

        // Poicionando a idade mínima
        this.atracLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, this.JL_idade_min, 0, SpringLayout.HORIZONTAL_CENTER, this.JL_altura_max );
        this.atracLayout.putConstraint( SpringLayout.SOUTH, this.JL_idade_min, -27, SpringLayout.NORTH, this.JL_altura_max );

        // Poicionando a idade mínima
        this.atracLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, this.JL_altura_min, 0, SpringLayout.HORIZONTAL_CENTER, this.JL_altura_max );
        this.atracLayout.putConstraint( SpringLayout.NORTH, this.JL_altura_min, 27, SpringLayout.SOUTH, this.JL_altura_max );

        // Posicionando a entropia
        this.atracLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, this.JL_entropia, 0, SpringLayout.HORIZONTAL_CENTER, this.JL_altura_min );
        this.atracLayout.putConstraint( SpringLayout.NORTH, this.JL_entropia, 27, SpringLayout.SOUTH, this.JL_altura_min );
    }

    private void initCardRestaurante( Restaurante rest ){
        this.initCardAtracao( rest );

        this.JP_cardapio = new JPanel();
        this.JL_titulo = new JLabel( "CARDÁPIO" );
        this.JB_pratos = new ArrayList<JButton>();
        this.ALJL_precos = new ArrayList<JLabel>();

        Dimension dimension;

        // JP_cardápio
        this.JP_cardapio.setBackground( Estilo.verdinho );

        // Título
        dimension = new Dimension( 189, 24 );

        this.JL_titulo.setPreferredSize( dimension );
        this.JL_titulo.setBackground( Estilo.verdinho );
        this.JL_titulo.setForeground( Estilo.preto );
        this.JL_titulo.setFont( Estilo.robotoLabelData );
        this.JL_titulo.setHorizontalAlignment( SwingConstants.CENTER );

        // Array List pratos e preços
        dimension = new Dimension( 94, 27 );

        if ( !rest.getCardapio().isEmpty() ){
            for ( String key : rest.getCardapio().keySet() ){
                JButton n_prato = new JButton( key );
                JLabel n_preco = new JLabel( rest.getCardapio().get( key ).toString() );

                n_prato.setPreferredSize( dimension );
                n_preco.setPreferredSize( dimension );
                
                n_prato.setBackground( Estilo.verdinho );
                n_prato.setForeground( Estilo.preto );
                n_prato.setFont( Estilo.robotoLabelData );

                n_preco.setBackground( Estilo.verdinho );
                n_preco.setForeground( Estilo.preto );
                n_preco.setFont( Estilo.robotoLabelData );

                n_prato.setHorizontalAlignment( SwingConstants.CENTER );
                n_preco.setHorizontalAlignment( SwingConstants.CENTER );

                this.JB_pratos.add( n_prato );
                this.ALJL_precos.add( n_preco );
            }
        }

        // Adicionando componente no cardápio
        SpringLayout cardapioLayout = new SpringLayout();
        this.JP_cardapio.setLayout( cardapioLayout );
        this.JP_cardapio.add( this.JL_titulo );

        int size = this.JB_pratos.size();

        if ( size > 0 ){
            for ( int i = 0; i < size; i++ ){
                this.JP_cardapio.add( this.JB_pratos.get( i ) );
                this.JP_cardapio.add( this.ALJL_precos.get( i ) );
            }
        }

        cardapioLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, this.JL_titulo, 0, SpringLayout.HORIZONTAL_CENTER, this.JP_cardapio);
        cardapioLayout.putConstraint( SpringLayout.NORTH, this.JL_titulo, 0, SpringLayout.NORTH, this.JP_cardapio);

        if ( size > 0 ){

            cardapioLayout.putConstraint( SpringLayout.WEST, this.JB_pratos.get( 0 ) , 0, SpringLayout.WEST, this.JP_cardapio);
            cardapioLayout.putConstraint( SpringLayout.NORTH, this.JB_pratos.get( 0 ) , 13, SpringLayout.SOUTH, this.JL_titulo);

            cardapioLayout.putConstraint( SpringLayout.EAST, this.ALJL_precos.get( 0 ), 0, SpringLayout.EAST, this.JP_cardapio);
            cardapioLayout.putConstraint( SpringLayout.NORTH, this.ALJL_precos.get( 0 ), 13, SpringLayout.SOUTH, this.JL_titulo);

            if ( size > 1 ){
                for ( int i = 1; i < size; i++ ){
                    cardapioLayout.putConstraint( SpringLayout.WEST, this.JB_pratos.get( i ) , 0, SpringLayout.WEST, this.JB_pratos.get( i - 1 ));
                    cardapioLayout.putConstraint( SpringLayout.NORTH, this.JB_pratos.get( i ) , 6, SpringLayout.SOUTH, this.JB_pratos.get( i - 1 ));

                    cardapioLayout.putConstraint( SpringLayout.EAST, this.ALJL_precos.get( i ), 0, SpringLayout.EAST, this.ALJL_precos.get( i - 1 ));
                    cardapioLayout.putConstraint( SpringLayout.NORTH, this.ALJL_precos.get( i ), 6, SpringLayout.SOUTH, this.ALJL_precos.get( i - 1 ));
                }
            }
        }

        this.JSP_cardapio = new JScrollPane( this.JP_cardapio );

        // Scroll Pane
        dimension = new Dimension( 189, 247 );

        this.JSP_cardapio.setPreferredSize( dimension );
        this.JSP_cardapio.setBackground( Estilo.verdinho );
        this.JSP_cardapio.setForeground( Estilo.preto );

        this.JSP_cardapio.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        this.JSP_cardapio.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );

        this.JP_cardapio.setPreferredSize( this.JP_cardapio.getPreferredSize() );

        // Colocando no this.centro
        this.JP_detalhe_atracao.add( this.JSP_cardapio );

        this.atracLayout.putConstraint( SpringLayout.WEST, this.JSP_cardapio, 24, SpringLayout.EAST, this.JL_preco);
        this.atracLayout.putConstraint( SpringLayout.NORTH, this.JSP_cardapio, 0, SpringLayout.NORTH, this.JL_preco);
    }

    private void initFooter(){

        this.footer.setBackground( Estilo.verdao );

        this.footerLayout = new SpringLayout();
        this.footer.setLayout( this.footerLayout );

        // Adicionando componentes no painel
        this.footer.add( this.fichas );
        this.footer.add( this.qtd_fichas );

        // Posicionando componentes no footer
        this.footerLayout.putConstraint( SpringLayout.EAST, this.fichas, 0, SpringLayout.HORIZONTAL_CENTER, this.footer );
        this.footerLayout.putConstraint( SpringLayout.VERTICAL_CENTER, this.fichas, 0, SpringLayout.VERTICAL_CENTER, this.footer );

        this.footerLayout.putConstraint( SpringLayout.WEST, this.qtd_fichas, 0, SpringLayout.EAST, this.fichas );
        this.footerLayout.putConstraint( SpringLayout.VERTICAL_CENTER, this.qtd_fichas, 0, SpringLayout.VERTICAL_CENTER, this.footer );
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if ( e.getSource() == this.JB_comeco ){
            System.out.println( "Começo" );
            this.jan.trocarTela( "Começo" );
        }

        if ( e.getSource() == this.JB_bilheteria ){
            System.out.println( "Parque!" );
            this.jan.trocarTela( "Bilheteria" );
        }

        if ( e.getSource() == this.JB_atracoes ){
            System.out.println( "Atrações!" );
            this.jan.trocarTela( "Atrações" );
        }

        for ( JButton jb : this.ALJB_atracoes ){
            if ( e.getSource() == jb ){
                for ( Atracao a : this.AL_atracoes ){
                    System.out.println( a.getNome() );
                    if ( jb.getText() == a.getNome() ){
                        ( (JCliente)this.jan ).setIDAtrac( a.getID() );
                        break;
                    }
                }
                this.jan.trocarTela( "Atrações" );
            }
        }

        if ( this.JB_pratos != null ){
            for ( JButton jb : this.JB_pratos ){
                if ( e.getSource() == jb ){
                    System.out.println( jb.getText() );
                    ( (Restaurante) this.atual ).venderPrato( this.cliente , jb.getText() );
                    ( (JCliente) this.jan ).setVisitante( this.cliente );
                    this.jan.trocarTela( "Atrações" );
                }
            }
        }

        if ( e.getSource() == this.JB_visitarParque ){
            System.out.println( this.atual.receberVisitante( this.cliente ) );
            this.jan.trocarTela( "Atrações" );
        }
        
    }
}
