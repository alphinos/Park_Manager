package src.Telas;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import src.Atracao;
import src.Brinquedo;
import src.Parque;
import src.Restaurante;
import src.Files.FBrinquedo;
import src.Files.FPark;
import src.Files.FRestaurante;
import src.Interface.Estilo;
import src.Interface.JGerente;
import src.Interface.Janela;
import src.Interface.Tela;

public class TAtracoes extends Tela implements ActionListener {

    private Parque parque;
    private Atracao atual;

    // Header
    private JLabel nomeParque;
    private JButton JB_comeco;
    private JButton JB_parque;
    private JButton JB_atracoes;
    private JButton JB_cliente;

    // Main
    private JTextField JTF_nome_atracao;     // Depende da atração
    private JPanel JP_detalhe_atracao;  // Depende da atração
    private SpringLayout atracLayout;

    // Atração
    private JTextField JTF_id;
    private JTextField JTF_preco;

    private JTextArea JTA_desc ;

    private JTextField JTF_capacidade;
    private JLabel JL_ocupacao;

    private JTextField JTF_abertura;
    private JTextField JTF_fechamento;

    // Brinquedo
    private JTextField JTF_idade_min;
    private JTextField JTF_altura_min;
    private JTextField JTF_altura_max;
    private JTextField JTF_entropia;

    // Selecionar atração
    private JPanel JP_atracoes;
    private JScrollPane JSP_atracoes;
    private ArrayList< Atracao > AL_atracoes;
    private ArrayList< JButton > ALJB_atracoes;

    // Restaurante
    private JScrollPane JSP_cardapio;
    private JPanel JP_cardapio;
    private JLabel JL_titulo;
    private ArrayList< JTextField > ALJTF_pratos;
    private ArrayList< JTextField > ALJTF_precos;
    private JTextField JTF_add_prato;
    private JTextField JTF_add_preco;
    private JButton JB_adicionar;

    // Main
    private JButton JB_novo_brinquedo;      // Nova janela para criação de atração
    private JButton JB_novo_restaurante;    // Nova janela para criação de restaurante
    private JButton JB_salvar;              // Salvar criações
    private JButton JB_remover;             // Remover atrações

    // Footer
    private JLabel visitantes;
    private JLabel qtdVisitantes;
    
    public TAtracoes( int width, int height ){
        super( width, height);
        this.atual = null;
        this.AL_atracoes = new ArrayList< Atracao >();
        this.ALJB_atracoes = new ArrayList< JButton >();
        ( (JGerente) this.jan ).getCliente().setParque( this.parque );
    }

    public TAtracoes( int width, int height, Janela jan ){
        super( width, height, jan );
        this.atual = null;
        this.AL_atracoes = new ArrayList< Atracao >();
        this.ALJB_atracoes = new ArrayList< JButton >();
        ( (JGerente) this.jan ).getCliente().setParque( this.parque );
    }

    public TAtracoes( int width, int height, Janela jan, Parque parque ){
        super( width, height, jan );
        this.parque = parque;
        this.atual = null;
        this.AL_atracoes = new ArrayList< Atracao >();
        this.ALJB_atracoes = new ArrayList< JButton >();
        this.start();
        ( (JGerente) this.jan ).getCliente().setParque( this.parque );
    }

    public TAtracoes( int width, int height, Janela jan, Parque parque, Atracao atual ){
        super( width, height, jan );
        this.parque = parque;
        this.atual = atual;
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

        System.out.println( this.parque.getNome() );
        System.out.println( this.parque.getDescricao() );
        System.out.println( this.parque.getPrecoFicha() );
        System.out.println( this.parque.getCapacidade() );
        System.out.println( this.parque.getQtdVisitantes() );
    }

    private void initLabelsTextos(){
        String nomeParque = parque.getNome();
        String qtdVisitantes = Integer.toString( parque.getQtdVisitantes() );

        this.nomeParque = new JLabel( nomeParque, SwingConstants.CENTER ); 

        this.visitantes = new JLabel( "Visitantes no parque", SwingConstants.CENTER );
        this.qtdVisitantes = new JLabel( qtdVisitantes, SwingConstants.CENTER );

        this.nomeParque.setBackground( Estilo.vermelhinho );
        this.nomeParque.setForeground( Estilo.branco );
        this.nomeParque.setFont( Estilo.robotoTitle );

        this.visitantes.setBackground( Estilo.vermelhinho );
        this.visitantes.setFont( Estilo.robotoLabel );
        this.visitantes.setForeground( Estilo.branco );

        this.qtdVisitantes.setBackground( Estilo.quaseBranco );
        this.qtdVisitantes.setFont( Estilo.robotoLabel );
        this.qtdVisitantes.setForeground( Estilo.vermelhinho );

        // 
        Dimension dim = new Dimension();

        // Tamanho dos labels de visitantes
        dim = new Dimension( 352, 45 );
        this.visitantes.setPreferredSize(dim);
        this.qtdVisitantes.setPreferredSize(dim);

        // Tornando o fundo visível
        this.visitantes.setOpaque( true );
        this.qtdVisitantes.setOpaque( true );
    }

    private void initBotoes(){
        this.JB_comeco = new JButton( "Começo" );
        this.JB_parque = new JButton( "Parque" );
        this.JB_atracoes = new JButton( "Atrações" );
        this.JB_cliente = new JButton( "Cliente" );

        // Configurando o fundo, fonte e cor dos textos
        this.JB_comeco.setBackground( Estilo.vermelhinho );
        this.JB_comeco.setForeground( Estilo.quaseBranco );
        this.JB_comeco.setFont( Estilo.robotoButton );

        this.JB_parque.setBackground( Estilo.vermelhinho );
        this.JB_parque.setForeground( Estilo.quaseBranco );
        this.JB_parque.setFont( Estilo.robotoButton );

        this.JB_atracoes.setBackground( Estilo.quaseBranco );
        this.JB_atracoes.setForeground( Estilo.vermelhinho );
        this.JB_atracoes.setFont( Estilo.robotoButton );

        this.JB_cliente.setBackground( Estilo.verdao );
        this.JB_cliente.setForeground( Estilo.branco );
        this.JB_cliente.setFont( Estilo.robotoButton );

        // Configurando tamanhos
        Dimension dimension = new Dimension( 160, 63 );

        this.JB_comeco.setPreferredSize( dimension );
        this.JB_parque.setPreferredSize( dimension );
        this.JB_atracoes.setPreferredSize( dimension );
        this.JB_cliente.setPreferredSize( dimension );

        // Removendo as linhas de borda
        this.JB_comeco.setBorderPainted( false );
        this.JB_parque.setBorderPainted( false );
        this.JB_atracoes.setBorderPainted( false );
        this.JB_cliente.setBorderPainted( false );

        this.JB_comeco.addActionListener( this );
        this.JB_parque.addActionListener( this );
        this.JB_atracoes.addActionListener( this );
        this.JB_cliente.addActionListener( this );
    }

    private void initHeader(){
        this.headerLayout = new SpringLayout();
        this.header.setLayout( headerLayout );

        // Adicionando os componentes ao header
        this.header.add( this.nomeParque );
        this.header.add( this.JB_comeco );
        this.header.add( this.JB_parque );
        this.header.add( this.JB_atracoes );
        this.header.add( this.JB_cliente );

        // Posicionando os elementos no painel "header"
        this.headerLayout.putConstraint( SpringLayout.WEST, this.nomeParque, 32, SpringLayout.WEST, this.header);
        this.headerLayout.putConstraint( SpringLayout.VERTICAL_CENTER, this.nomeParque, 0, SpringLayout.VERTICAL_CENTER, this.header);

        this.headerLayout.putConstraint( SpringLayout.WEST, this.JB_comeco, 32, SpringLayout.EAST, this.nomeParque );
        this.headerLayout.putConstraint( SpringLayout.VERTICAL_CENTER, this.JB_comeco, 0, SpringLayout.VERTICAL_CENTER, this.header);

        this.headerLayout.putConstraint( SpringLayout.WEST, this.JB_parque, 15, SpringLayout.EAST, this.JB_comeco );
        this.headerLayout.putConstraint( SpringLayout.VERTICAL_CENTER, this.JB_parque, 0, SpringLayout.VERTICAL_CENTER, this.JB_comeco);

        this.headerLayout.putConstraint( SpringLayout.WEST, this.JB_atracoes, 15, SpringLayout.EAST, this.JB_parque );
        this.headerLayout.putConstraint( SpringLayout.VERTICAL_CENTER, this.JB_atracoes, 0, SpringLayout.VERTICAL_CENTER, this.JB_comeco);

        this.headerLayout.putConstraint( SpringLayout.WEST, this.JB_cliente, 15, SpringLayout.EAST, this.JB_atracoes );
        this.headerLayout.putConstraint( SpringLayout.VERTICAL_CENTER, this.JB_cliente, 0, SpringLayout.VERTICAL_CENTER, this.JB_comeco);
    }

    private void initMain(){

        this.main.remove( this.north );
        this.main.remove( this.south );
        this.main.remove( this.west );
        this.main.remove( this.east );

        this.centerLayout = new SpringLayout();
        this.center.setLayout( this.centerLayout );

        this.JTF_nome_atracao = new JTextField(  );     // Depende da atração
        this.JP_detalhe_atracao = new JPanel(  );  // Depende da atração

        this.JB_novo_brinquedo = new JButton( "Brinquedo" );      // Nova janela para criação de atração
        this.JB_novo_restaurante = new JButton( "Restaurante" );    // Nova janela para criação de restaurante
        this.JB_salvar = new JButton( "Salvar" );              // Salvar criações
        this.JB_remover = new JButton( "Remover" );

        Dimension dimension;
        
        // Nome da atração
        dimension = new Dimension( 688, 72 );
        this.JTF_nome_atracao.setPreferredSize( dimension );
        this.JTF_nome_atracao.setForeground( Estilo.vermelhinho );
        this.JTF_nome_atracao.setBackground( Estilo.quaseBranco );
        this.JTF_nome_atracao.setFont( Estilo.robotoTitle );
        this.JTF_nome_atracao.setHorizontalAlignment( SwingConstants.CENTER );
        this.JTF_nome_atracao.setOpaque( true );

        // Area detalhes
        dimension = new Dimension( 688, 360 );
        this.JP_detalhe_atracao.setPreferredSize( dimension );
        this.JP_detalhe_atracao.setBackground( Estilo.quaseBranco );

        // Seleção de atrações
        this.JP_atracoes = new JPanel();
        this.JP_atracoes.setBackground( Estilo.quaseBranco );

        // Botões navegação
        dimension = new Dimension( 176, 45 );
        
        this.AL_atracoes = this.parque.getAtracoes();

        for ( Atracao atrac : this.AL_atracoes ){
            JButton b_atrac = new JButton( atrac.getNome() );
            b_atrac.setBackground( Estilo.vermelhinho );
            b_atrac.setForeground( Estilo.quaseBranco );
            b_atrac.setFont( Estilo.robotoButton );
            b_atrac.setHorizontalAlignment( SwingConstants.CENTER );
            b_atrac.setPreferredSize( dimension );
            b_atrac.addActionListener( this );
            this.ALJB_atracoes.add( b_atrac );
        }

        // Botões de criação e salvar
        dimension = new Dimension( 208, 72 );
        this.JB_novo_brinquedo.setPreferredSize( dimension );
        this.JB_novo_brinquedo.setForeground( Estilo.vermelhinho );
        this.JB_novo_brinquedo.setBackground( Estilo.quaseBranco );
        this.JB_novo_brinquedo.setFont( Estilo.robotoButton );
        this.JB_novo_brinquedo.setHorizontalAlignment( SwingConstants.CENTER );
        this.JB_novo_brinquedo.addActionListener( this );

        this.JB_novo_restaurante.setPreferredSize( dimension );
        this.JB_novo_restaurante.setForeground( Estilo.vermelhinho );
        this.JB_novo_restaurante.setBackground( Estilo.quaseBranco );
        this.JB_novo_restaurante.setFont( Estilo.robotoButton );
        this.JB_novo_restaurante.setHorizontalAlignment( SwingConstants.CENTER );
        this.JB_novo_restaurante.addActionListener( this );

        this.JB_salvar.setPreferredSize( dimension );
        this.JB_salvar.setForeground( Estilo.vermelhinho );
        this.JB_salvar.setBackground( Estilo.quaseBranco );
        this.JB_salvar.setFont( Estilo.robotoButton );
        this.JB_salvar.setHorizontalAlignment( SwingConstants.CENTER );
        this.JB_salvar.addActionListener( this );

        this.JB_remover.setPreferredSize( dimension );
        this.JB_remover.setForeground( Estilo.vermelhinho );
        this.JB_remover.setBackground( Estilo.quaseBranco );
        this.JB_remover.setFont( Estilo.robotoButton );
        this.JB_remover.setHorizontalAlignment( SwingConstants.CENTER );
        this.JB_remover.addActionListener( this );

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

        this.JSP_atracoes.setBackground( Estilo.quaseBranco );
        this.JSP_atracoes.setForeground( Estilo.vermelhinho );

        this.JSP_atracoes.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        this.JSP_atracoes.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );

        this.JP_atracoes.setPreferredSize( new Dimension( 176, 12 + size * 57 ) );

        this.center.add( this.JSP_atracoes );

        // Posicionando os botões de seleção da atração
        this.centerLayout.putConstraint( SpringLayout.WEST, this.JSP_atracoes, 32, SpringLayout.EAST, this.JP_detalhe_atracao );
        this.centerLayout.putConstraint( SpringLayout.VERTICAL_CENTER, this.JSP_atracoes, 0, SpringLayout.VERTICAL_CENTER, this.center );

        Atracao atual;
        if ( this.atual != null ){
            this.JTF_nome_atracao.setText( this.atual.getNome() );
            atual = this.atual;
                if ( atual instanceof Brinquedo ){
                this.initCardBrinquedo( (Brinquedo) atual );
            }
            if ( atual instanceof Restaurante ){
                this.initCardRestaurante( (Restaurante) atual );
            }
        } else {
            this.JTF_nome_atracao.setText( "Parque vazio" );
        }

        this.center.add( this.JTF_nome_atracao );
        this.center.add( this.JP_detalhe_atracao );
        this.center.add( this.JB_novo_brinquedo );
        this.center.add( this.JB_novo_restaurante );
        this.center.add( this.JB_salvar );
        this.center.add( this.JB_remover );

        // Poisicionando detalhes da atração
        this.centerLayout.putConstraint( SpringLayout.WEST, this.JP_detalhe_atracao, 64, SpringLayout.WEST, this.center );
        this.centerLayout.putConstraint( SpringLayout.SOUTH, this.JP_detalhe_atracao, -16, SpringLayout.SOUTH, this.center);

        // Poisicionando nome da atração
        this.centerLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, this.JTF_nome_atracao, 0, SpringLayout.HORIZONTAL_CENTER, this.JP_detalhe_atracao );
        this.centerLayout.putConstraint( SpringLayout.NORTH, this.JTF_nome_atracao, 16, SpringLayout.NORTH, this.center);

        // Posicionando os botões de seleção da atração
        // this.centerLayout.putConstraint( SpringLayout.WEST, this.JSP_atracoes, 32, SpringLayout.EAST, this.JP_detalhe_atracao );
        // this.centerLayout.putConstraint( SpringLayout.VERTICAL_CENTER, this.JSP_atracoes, 0, SpringLayout.VERTICAL_CENTER, this.center );

        // Posicionando o botão do novo brinquedo
        this.centerLayout.putConstraint( SpringLayout.EAST, this.JB_novo_brinquedo, -48, SpringLayout.EAST, this.center);
        this.centerLayout.putConstraint( SpringLayout.NORTH, this.JB_novo_brinquedo, 32, SpringLayout.NORTH, this.center);
        
        // Posicionando o botão do novo restaurante
        this.centerLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, this.JB_novo_restaurante, 0, SpringLayout.HORIZONTAL_CENTER, this.JB_novo_brinquedo);
        this.centerLayout.putConstraint( SpringLayout.NORTH, this.JB_novo_restaurante, 32, SpringLayout.SOUTH, this.JB_novo_brinquedo);


        // Posicionando o botão de salvar
        this.centerLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, this.JB_salvar, 0, SpringLayout.HORIZONTAL_CENTER, this.JB_novo_restaurante);
        this.centerLayout.putConstraint( SpringLayout.NORTH, this.JB_salvar, 32, SpringLayout.SOUTH, this.JB_novo_restaurante);

        // Posicionando o botão de remover
        this.centerLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, this.JB_remover, 0, SpringLayout.HORIZONTAL_CENTER, this.JB_salvar );
        this.centerLayout.putConstraint( SpringLayout.NORTH, this.JB_remover, 32, SpringLayout.SOUTH, this.JB_salvar );
    }

    private void initCardAtracao( Atracao atrac ){

        this.atracLayout = new SpringLayout();
        this.JP_detalhe_atracao.setLayout( this.atracLayout );

        this.JTF_id = new JTextField( "ID: " + atrac.getID() );
        this.JTF_preco = new JTextField( "Preço: " + atrac.getPreco() );

        this.JTA_desc = new JTextArea( atrac.getDescricao() );

        this.JTF_capacidade = new JTextField( "Capacidade: " + atrac.getCapacidade_max() );
        this.JL_ocupacao = new JLabel( "Ocupação: " + atrac.getOcupacaoAtual() );

        this.JTF_abertura = new JTextField( "Abertura: " + atrac.getTimeString( atrac.getAbertura() ) );
        this.JTF_fechamento = new JTextField( "Fechamento: " + atrac.getTimeString( atrac.getFechamento() ) );

        Dimension dimension;

        // id e preco
        dimension = new Dimension( 144, 27 );
        
        //id
        this.JTF_id.setPreferredSize( dimension );
        this.JTF_id.setBackground( Estilo.vermelhinho );
        this.JTF_id.setForeground( Estilo.quaseBranco );
        this.JTF_id.setFont( Estilo.robotoLabel );
        this.JTF_id.setHorizontalAlignment( SwingConstants.CENTER );

        //preco
        this.JTF_preco.setPreferredSize( dimension );
        this.JTF_preco.setBackground( Estilo.vermelhinho );
        this.JTF_preco.setForeground( Estilo.quaseBranco );
        this.JTF_preco.setFont( Estilo.robotoLabel );
        this.JTF_preco.setHorizontalAlignment( SwingConstants.CENTER );

        // Descrição
        dimension = new Dimension( 413, 153 );

        this.JTA_desc.setPreferredSize( dimension );
        this.JTA_desc.setBackground( Estilo.vermelhinho );
        this.JTA_desc.setForeground( Estilo.branco );
        this.JTA_desc.setFont( Estilo.robotoText );

        this.JTA_desc.setMargin( new Insets( 8, 12, 8, 12 ) ); // Colocando a margem do texto
        this.JTA_desc.setLineWrap( true );                   // Para a quebra de linha do texto
        this.JTA_desc.setWrapStyleWord( true );              // Para a quebra de linha do texto

        // 4 JTF baixo
        dimension = new Dimension( 202, 27 );

        //Capacidade
        this.JTF_capacidade.setPreferredSize( dimension );
        this.JTF_capacidade.setBackground( Estilo.vermelhinho );
        this.JTF_capacidade.setForeground( Estilo.quaseBranco );
        this.JTF_capacidade.setFont( Estilo.robotoLabelData );
        this.JTF_capacidade.setHorizontalAlignment( SwingConstants.CENTER );

        //Ocupação
        this.JL_ocupacao.setPreferredSize( dimension );
        this.JL_ocupacao.setBackground( Estilo.vermelhinho );
        this.JL_ocupacao.setForeground( Estilo.quaseBranco );
        this.JL_ocupacao.setFont( Estilo.robotoLabelData );
        this.JL_ocupacao.setHorizontalAlignment( SwingConstants.CENTER );
        this.JL_ocupacao.setOpaque( true );

        //Abertura
        this.JTF_abertura.setPreferredSize( dimension );
        this.JTF_abertura.setBackground( Estilo.vermelhinho );
        this.JTF_abertura.setForeground( Estilo.quaseBranco );
        this.JTF_abertura.setFont( Estilo.robotoLabelData );
        this.JTF_abertura.setHorizontalAlignment( SwingConstants.CENTER );

        //Fechamento
        this.JTF_fechamento.setPreferredSize( dimension );
        this.JTF_fechamento.setBackground( Estilo.vermelhinho );
        this.JTF_fechamento.setForeground( Estilo.quaseBranco );
        this.JTF_fechamento.setFont( Estilo.robotoLabelData );
        this.JTF_fechamento.setHorizontalAlignment( SwingConstants.CENTER );

        this.JP_detalhe_atracao.add( this.JTF_id );
        this.JP_detalhe_atracao.add( this.JTF_preco );

        this.JP_detalhe_atracao.add( this.JTA_desc );

        this.JSP_atracoes = new JScrollPane( this.JP_cardapio );

        this.JP_detalhe_atracao.add( this.JTF_capacidade );
        this.JP_detalhe_atracao.add( this.JL_ocupacao );
        this.JP_detalhe_atracao.add( this.JTF_abertura );
        this.JP_detalhe_atracao.add( this.JTF_fechamento );

        // Posicionando id
        this.atracLayout.putConstraint( SpringLayout.WEST, this.JTF_id, 42, SpringLayout.WEST, this.JP_detalhe_atracao );
        this.atracLayout.putConstraint( SpringLayout.NORTH, this.JTF_id, 34, SpringLayout.NORTH, this.JP_detalhe_atracao );

        // Posicionando descrição
        this.atracLayout.putConstraint( SpringLayout.WEST, this.JTA_desc, 0, SpringLayout.WEST, this.JTF_id );
        this.atracLayout.putConstraint( SpringLayout.NORTH, this.JTA_desc, 0, SpringLayout.SOUTH, this.JTF_id );

        // Posicionando preço
        this.atracLayout.putConstraint( SpringLayout.EAST, this.JTF_preco, 0, SpringLayout.EAST, this.JTA_desc );
        this.atracLayout.putConstraint( SpringLayout.SOUTH, this.JTF_preco, 0, SpringLayout.NORTH, this.JTA_desc );

        // Posicionando capacidade máxima
        this.atracLayout.putConstraint( SpringLayout.WEST, this.JTF_capacidade, 0, SpringLayout.WEST, this.JTA_desc );
        this.atracLayout.putConstraint( SpringLayout.NORTH, this.JTF_capacidade, 40, SpringLayout.SOUTH, this.JTA_desc );

        // Posicionando capacidade máxima
        this.atracLayout.putConstraint( SpringLayout.EAST, this.JL_ocupacao, 0, SpringLayout.EAST, this.JTA_desc );
        this.atracLayout.putConstraint( SpringLayout.NORTH, this.JL_ocupacao, 40, SpringLayout.SOUTH, this.JTA_desc );

        // Posicionando abertura
        this.atracLayout.putConstraint( SpringLayout.WEST, this.JTF_abertura, 0, SpringLayout.WEST, this.JTF_capacidade );
        this.atracLayout.putConstraint( SpringLayout.NORTH, this.JTF_abertura, 40, SpringLayout.SOUTH, this.JTF_capacidade );

        // Posicionando fechamento
        this.atracLayout.putConstraint( SpringLayout.EAST, this.JTF_fechamento, 0, SpringLayout.EAST, this.JL_ocupacao );
        this.atracLayout.putConstraint( SpringLayout.NORTH, this.JTF_fechamento, 40, SpringLayout.SOUTH, this.JL_ocupacao );
    }

    private void initCardBrinquedo( Brinquedo brinks ){
        this.initCardAtracao( brinks );

        this.JTF_idade_min = new JTextField( "Idade mínima: " + brinks.getIdade_min() );
        this.JTF_altura_max = new JTextField( "Altura máxima: " + brinks.getAltura_max() );
        this.JTF_altura_min = new JTextField( "Altura mínima: " + brinks.getAltura_min() );
        this.JTF_entropia = new JTextField( "Entropia: " + brinks.getEntropia() );

        Dimension dimension = new Dimension( 189, 27 );
        //Idade mínima
        this.JTF_idade_min.setPreferredSize( dimension );
        this.JTF_idade_min.setBackground( Estilo.vermelhinho );
        this.JTF_idade_min.setForeground( Estilo.quaseBranco );
        this.JTF_idade_min.setFont( Estilo.robotoLabelData );
        this.JTF_idade_min.setHorizontalAlignment( SwingConstants.CENTER );

        //Altura máxima
        this.JTF_altura_max.setPreferredSize( dimension );
        this.JTF_altura_max.setBackground( Estilo.vermelhinho );
        this.JTF_altura_max.setForeground( Estilo.quaseBranco );
        this.JTF_altura_max.setFont( Estilo.robotoLabelData );
        this.JTF_altura_max.setHorizontalAlignment( SwingConstants.CENTER );

        //Altura mínima
        this.JTF_altura_min.setPreferredSize( dimension );
        this.JTF_altura_min.setBackground( Estilo.vermelhinho );
        this.JTF_altura_min.setForeground( Estilo.quaseBranco );
        this.JTF_altura_min.setFont( Estilo.robotoLabelData );
        this.JTF_altura_min.setHorizontalAlignment( SwingConstants.CENTER );

        this.JTF_entropia.setPreferredSize( dimension );
        this.JTF_entropia.setBackground( Estilo.vermelhinho );
        this.JTF_entropia.setForeground( Estilo.quaseBranco );
        this.JTF_entropia.setFont( Estilo.robotoLabelData );
        this.JTF_entropia.setHorizontalAlignment( SwingConstants.CENTER );

        this.JP_detalhe_atracao.add( this.JTF_idade_min );
        this.JP_detalhe_atracao.add( this.JTF_altura_max );
        this.JP_detalhe_atracao.add( this.JTF_altura_min );
        this.JP_detalhe_atracao.add( this.JTF_entropia );

        // Poicionando a altura mínima
        this.atracLayout.putConstraint( SpringLayout.EAST, this.JTF_altura_max, -23, SpringLayout.EAST, this.JP_detalhe_atracao );
        this.atracLayout.putConstraint( SpringLayout.VERTICAL_CENTER, this.JTF_altura_max, 0, SpringLayout.VERTICAL_CENTER, this.JP_detalhe_atracao );

        // Poicionando a idade mínima
        this.atracLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, this.JTF_idade_min, 0, SpringLayout.HORIZONTAL_CENTER, this.JTF_altura_max );
        this.atracLayout.putConstraint( SpringLayout.SOUTH, this.JTF_idade_min, -27, SpringLayout.NORTH, this.JTF_altura_max );

        // Poicionando a idade mínima
        this.atracLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, this.JTF_altura_min, 0, SpringLayout.HORIZONTAL_CENTER, this.JTF_altura_max );
        this.atracLayout.putConstraint( SpringLayout.NORTH, this.JTF_altura_min, 27, SpringLayout.SOUTH, this.JTF_altura_max );

        // Posicionando a entropia
        this.atracLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, this.JTF_entropia, 0, SpringLayout.HORIZONTAL_CENTER, this.JTF_altura_min );
        this.atracLayout.putConstraint( SpringLayout.NORTH, this.JTF_entropia, 27, SpringLayout.SOUTH, this.JTF_altura_min );
    }

    private void initCardRestaurante( Restaurante rest ){
        this.initCardAtracao( rest );

        this.JP_cardapio = new JPanel();
        this.JL_titulo = new JLabel( "CARDÁPIO" );
        this.ALJTF_pratos = new ArrayList<JTextField>();
        this.ALJTF_precos = new ArrayList<JTextField>();
        this.JTF_add_prato = new JTextField( "Prato" );
        this.JTF_add_preco = new JTextField( "Preço" );
        this.JB_adicionar = new JButton( "Adicionar" );

        Dimension dimension;

        // JP_cardápio
        this.JP_cardapio.setBackground( Estilo.vermelhinho );

        // Título
        dimension = new Dimension( 189, 24 );

        this.JL_titulo.setPreferredSize( dimension );
        this.JL_titulo.setBackground( Estilo.vermelhinho );
        this.JL_titulo.setForeground( Estilo.quaseBranco );
        this.JL_titulo.setFont( Estilo.robotoLabelData );
        this.JL_titulo.setHorizontalAlignment( SwingConstants.CENTER );

        // Array List pratos e preços
        dimension = new Dimension( 94, 27 );

        if ( !rest.getCardapio().isEmpty() ){
            for ( String key : rest.getCardapio().keySet() ){
                JTextField n_prato = new JTextField( key );
                JTextField n_preco = new JTextField( rest.getCardapio().get( key ).toString() );

                n_prato.setPreferredSize( dimension );
                n_preco.setPreferredSize( dimension );
                
                n_prato.setBackground( Estilo.vermelho );
                n_prato.setForeground( Estilo.quaseBranco );
                n_prato.setFont( Estilo.robotoLabelData );

                n_preco.setBackground( Estilo.quaseBranco );
                n_preco.setForeground( Estilo.vermelho );
                n_preco.setFont( Estilo.robotoLabelData );

                n_prato.setHorizontalAlignment( SwingConstants.CENTER );
                n_preco.setHorizontalAlignment( SwingConstants.CENTER );

                this.ALJTF_pratos.add( n_prato );
                this.ALJTF_precos.add( n_preco );
            }
        }

        // Add prato
        this.JTF_add_prato.setPreferredSize( dimension );        
        this.JTF_add_prato.setBackground( Estilo.vermelho );
        this.JTF_add_prato.setForeground( Estilo.quaseBranco );
        this.JTF_add_prato.setFont( Estilo.robotoLabelData );
        this.JTF_add_prato.setHorizontalAlignment( SwingConstants.CENTER );

        // Add preço
        this.JTF_add_preco.setPreferredSize( dimension );        
        this.JTF_add_preco.setBackground( Estilo.vermelho );
        this.JTF_add_preco.setForeground( Estilo.quaseBranco );
        this.JTF_add_preco.setFont( Estilo.robotoLabelData );
        this.JTF_add_preco.setHorizontalAlignment( SwingConstants.CENTER );

        // Adicionar
        dimension = new Dimension( 189, 28 );

        this.JB_adicionar.setPreferredSize( dimension );        
        this.JB_adicionar.setBackground( Estilo.vermelho );
        this.JB_adicionar.setForeground( Estilo.quaseBranco );
        this.JB_adicionar.setFont( Estilo.robotoLabelData );
        this.JB_adicionar.addActionListener( this );

        // Adicionando componente no cardápio
        SpringLayout cardapioLayout = new SpringLayout();
        this.JP_cardapio.setLayout( cardapioLayout );
        this.JP_cardapio.add( this.JL_titulo );

        int size = this.ALJTF_pratos.size();

        if ( size > 0 ){
            for ( int i = 0; i < size; i++ ){
                this.JP_cardapio.add( this.ALJTF_pratos.get( i ) );
                this.JP_cardapio.add( this.ALJTF_precos.get( i ) );
            }
        }

        cardapioLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, this.JL_titulo, 0, SpringLayout.HORIZONTAL_CENTER, this.JP_cardapio);
        cardapioLayout.putConstraint( SpringLayout.NORTH, this.JL_titulo, 0, SpringLayout.NORTH, this.JP_cardapio);

        if ( size > 0 ){

            cardapioLayout.putConstraint( SpringLayout.WEST, this.ALJTF_pratos.get( 0 ) , 0, SpringLayout.WEST, this.JP_cardapio);
            cardapioLayout.putConstraint( SpringLayout.NORTH, this.ALJTF_pratos.get( 0 ) , 13, SpringLayout.SOUTH, this.JL_titulo);

            cardapioLayout.putConstraint( SpringLayout.EAST, this.ALJTF_precos.get( 0 ), 0, SpringLayout.EAST, this.JP_cardapio);
            cardapioLayout.putConstraint( SpringLayout.NORTH, this.ALJTF_precos.get( 0 ), 13, SpringLayout.SOUTH, this.JL_titulo);

            if ( size > 1 ){
                for ( int i = 1; i < size; i++ ){
                    cardapioLayout.putConstraint( SpringLayout.WEST, this.ALJTF_pratos.get( i ) , 0, SpringLayout.WEST, this.ALJTF_pratos.get( i - 1 ));
                    cardapioLayout.putConstraint( SpringLayout.NORTH, this.ALJTF_pratos.get( i ) , 6, SpringLayout.SOUTH, this.ALJTF_pratos.get( i - 1 ));

                    cardapioLayout.putConstraint( SpringLayout.EAST, this.ALJTF_precos.get( i ), 0, SpringLayout.EAST, this.ALJTF_precos.get( i - 1 ));
                    cardapioLayout.putConstraint( SpringLayout.NORTH, this.ALJTF_precos.get( i ), 6, SpringLayout.SOUTH, this.ALJTF_precos.get( i - 1 ));
                }
            }
        }

        this.JSP_cardapio = new JScrollPane( this.JP_cardapio );

        // Scroll Pane
        dimension = new Dimension( 189, 247 );

        this.JSP_cardapio.setPreferredSize( dimension );
        this.JSP_cardapio.setBackground( Estilo.vermelhinho );
        this.JSP_cardapio.setForeground( Estilo.quaseBranco );

        this.JSP_cardapio.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        this.JSP_cardapio.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );

        this.JP_cardapio.setPreferredSize( this.JP_cardapio.getPreferredSize() );

        // Colocando no this.centro
        this.JP_detalhe_atracao.add( this.JSP_cardapio );
        this.JP_detalhe_atracao.add( this.JTF_add_prato );
        this.JP_detalhe_atracao.add( this.JTF_add_preco );
        this.JP_detalhe_atracao.add( this.JB_adicionar );

        this.atracLayout.putConstraint( SpringLayout.WEST, this.JSP_cardapio, 24, SpringLayout.EAST, this.JTF_preco);
        this.atracLayout.putConstraint( SpringLayout.NORTH, this.JSP_cardapio, 0, SpringLayout.NORTH, this.JTF_preco);

        this.atracLayout.putConstraint( SpringLayout.WEST, this.JTF_add_prato, 0, SpringLayout.WEST, this.JSP_cardapio);
        this.atracLayout.putConstraint( SpringLayout.NORTH, this.JTF_add_prato, 6, SpringLayout.SOUTH, this.JSP_cardapio);

        this.atracLayout.putConstraint( SpringLayout.EAST, this.JTF_add_preco, 0, SpringLayout.EAST, this.JSP_cardapio);
        this.atracLayout.putConstraint( SpringLayout.NORTH, this.JTF_add_preco, 6, SpringLayout.SOUTH, this.JSP_cardapio);

        this.atracLayout.putConstraint( SpringLayout.WEST, this.JB_adicionar, 0, SpringLayout.WEST, this.JTF_add_prato);
        this.atracLayout.putConstraint( SpringLayout.NORTH, this.JB_adicionar, 5, SpringLayout.SOUTH, this.JTF_add_prato);
    }

    private void initFooter(){
        this.footerLayout = new SpringLayout();
        this.footer.setLayout( this.footerLayout );

        // Adicionando componentes no painel
        this.footer.add( this.visitantes );
        this.footer.add( this.qtdVisitantes );

        // Posicionando componentes no footer
        this.footerLayout.putConstraint( SpringLayout.EAST, this.visitantes, 0, SpringLayout.HORIZONTAL_CENTER, this.footer );
        this.footerLayout.putConstraint( SpringLayout.VERTICAL_CENTER, this.visitantes, 0, SpringLayout.VERTICAL_CENTER, this.footer );

        this.footerLayout.putConstraint( SpringLayout.WEST, this.qtdVisitantes, 0, SpringLayout.EAST, this.visitantes );
        this.footerLayout.putConstraint( SpringLayout.VERTICAL_CENTER, this.qtdVisitantes, 0, SpringLayout.VERTICAL_CENTER, this.footer );
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if ( e.getSource() == this.JB_comeco ){
            System.out.println( "Começo" );
            this.jan.trocarTela( "Começo" );
        }

        if ( e.getSource() == this.JB_parque ){
            System.out.println( "Parque!" );
            this.jan.trocarTela( "Aba_parque" );
        }

        if ( e.getSource() == this.JB_atracoes ){
            System.out.println( "Atrações!" );
            this.jan.trocarTela( "Aba_atrações" );
        }

        if ( e.getSource() == this.JB_cliente ){
            System.out.println( "Abrir janela cliente!" );
            ( (JGerente) this.jan ).getCliente().setParque( this.parque );
            this.jan.trocarTela( "Novo_Cliente" );
        }

        for ( JButton jb : this.ALJB_atracoes ){
            if ( e.getSource() == jb ){
                for ( Atracao a : this.AL_atracoes ){
                    System.out.println( a.getNome() );
                    if ( jb.getText() == a.getNome() ){
                        ( (JGerente)this.jan ).setIDAtrac( a.getID() );
                        break;
                    }
                }
                this.jan.trocarTela( "Aba_atrações" );
            }
        }

        if ( e.getSource() == this.JB_adicionar ){
            String prato = JTF_add_prato.getText();
            int preco =  Integer.parseInt( this.getToDigitParts( JTF_add_preco.getText() ) );

            ( ( Restaurante ) this.atual ).addComida(prato, preco);

            this.jan.trocarTela( "Aba_atrações" );
        }

        if ( e.getSource() == this.JB_novo_brinquedo ){
            Brinquedo b = new Brinquedo( "Escolher nome", "Escolha uma descrição", 20, 0, 0, 0, 0, 0, 0 );
            b.setAltura_max( 1 );
            b.setAltura_min( 1 );
            b.setIdade_min( 0 );
            b.setEntropia( 1 );
            this.parque.addAtracao( b );
            int id = this.parque.getAtracoes().indexOf( b );

            if ( this.jan instanceof JGerente ){
                ( (JGerente) this.jan ).setParque( parque );
                if ( !parque.getAtracoes().isEmpty() ){
                    ( (JGerente) this.jan ).setAtracoes( parque.getAtracoes() );
                    ( (JGerente) this.jan ).setIDAtrac( id );
                }
            }
            this.jan.trocarTela( "Aba_atrações" );
        }

        if ( e.getSource() == this.JB_novo_restaurante){
            Restaurante b = new Restaurante( "Escolher nome", "Escolha uma descrição", 20, 0 );
            this.parque.addAtracao( b );
            int id = this.parque.getAtracoes().indexOf( b );

            if ( this.jan instanceof JGerente ){
                ( (JGerente) this.jan ).setParque( parque );
                if ( !parque.getAtracoes().isEmpty() ){
                    ( (JGerente) this.jan ).setAtracoes( parque.getAtracoes() );
                    ( (JGerente) this.jan ).setIDAtrac( id );
                }
            }
            this.jan.trocarTela( "Aba_atrações" );
        }

        if ( e.getSource() == this.JB_salvar ){
            System.out.println( "Salvar mudanças!" );

            String nome = this.JTF_nome_atracao.getText();
            String id = this.JTF_id.getText();
            String preco = this.JTF_preco.getText();
            String descricao = this.JTA_desc.getText();
            String capacidade = this.JTF_capacidade.getText();
            String ocupacao_atual = this.JL_ocupacao.getText();
            String abertura = this.JTF_abertura.getText();
            String fechamento = this.JTF_fechamento.getText();
            
            id = getToDigitParts( id );
            preco = getToDigitParts( preco );
            capacidade = getToDigitParts( capacidade );
            ocupacao_atual = getToDigitParts( ocupacao_atual );
            abertura = getToDigitParts( abertura );
            fechamento = getToDigitParts( fechamento );
            
            this.atual.setNome( nome );
            this.atual.setID( Integer.parseInt( id ) );
            this.atual.setPreco( Integer.parseInt( preco ) );
            this.atual.setDescricao( descricao );
            this.atual.setCapacidade_max( Integer.parseInt( capacidade ) );
            this.atual.setOcupacaoAtual( Integer.parseInt( ocupacao_atual ) );
            this.atual.setAbertura( LocalTime.parse( abertura ) );
            this.atual.setFechamento( LocalTime.parse( fechamento ) );

            String ext = "";
                if ( this.atual instanceof Brinquedo ){
                    ext = ".brinquedo";
                }

                if ( this.atual instanceof Restaurante ){
                    ext = ".restaurante";
                }

            this.atual.setPath( "././Parques/" +parque.getNome() + "/" + this.atual.getNome() + ext );

            if ( this.atual instanceof Brinquedo ){
                String idade_min = this.JTF_idade_min.getText();
                String altura_max = this.JTF_altura_max.getText();
                String altura_min = this.JTF_altura_min.getText();
                String entropia = this.JTF_entropia.getText();
                
                System.out.println( altura_min );

                idade_min = getToDigitParts( idade_min );
                altura_max = getToDigitParts( altura_max );
                altura_min = getToDigitParts( altura_min );
                entropia = getToDigitParts( entropia );

                ( (Brinquedo) this.atual ).setIdade_min( Integer.parseInt( idade_min ) );
                ( (Brinquedo) this.atual ).setAltura_max( Float.parseFloat( altura_max ) );
                ( (Brinquedo) this.atual ).setAltura_min( Float.parseFloat( altura_min ) );

                int ent = Integer.parseInt( entropia );

                if ( ent > 0 && ent < 4 ){
                    ( (Brinquedo) this.atual ).setEntropia(ent);
                }

                FBrinquedo.escrever( (Brinquedo) this.atual );
            }

            if ( this.atual instanceof Restaurante ){
                int size = ALJTF_pratos.size();
                if ( size == ALJTF_precos.size() ){
                    for (int i = 0; i < size; i++ ){
                        String prato = ALJTF_pratos.get( i ).getText();
                        int ppreco = Integer.parseInt( this.getToDigitParts( ALJTF_precos.get( i ).getText() ) ); 
                        ( (Restaurante) this.atual ).addComida( prato, ppreco);
                    }
                }

                FRestaurante.escrever( (Restaurante) this.atual );
            }

            FPark.escrever( parque );

            this.jan.trocarTela( "Aba_atrações" );
        }

        if ( e.getSource() == this.JB_remover ){

            Atracao atrac;
            
            this.AL_atracoes.remove( this.atual );
            
            ( (JGerente) this.jan ).getAtracoes().remove( this.atual.getID() );
            this.parque.setAtracoes( AL_atracoes );
            
            if ( this.AL_atracoes.isEmpty() ){
                ( (JGerente) this.jan ).setIDAtrac( 0 );
            } else {
                atrac = this.AL_atracoes.get( 0 );
                ( (JGerente) this.jan ).setIDAtrac( atrac.getID() );
            }

            
            if ( this.atual instanceof Brinquedo ){
                FBrinquedo.remove( this.atual.getPath() );

            } else if ( this.atual instanceof Restaurante ){
                FRestaurante.remove( this.atual.getPath() );
            }

            FPark.escrever( parque );
            this.jan.trocarTela( "Aba_atrações" );
        }
    }

    private String getToDigitParts( String str ){
        int i;
        for ( i = 0; i < str.length(); i++){
                if ( Character.isDigit( str.charAt(i) )){
                    break;
                }
            }
        return str.substring( i );  
    }
}
