package src.Telas;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import src.Atracao;
import src.Brinquedo;
import src.LC_Atracoes;
import src.Parque;
import src.Restaurante;
import src.Interface.Estilo;
import src.Interface.Janela;
import src.Interface.Tela;

public class TAtracoes extends Tela implements ActionListener {

    private Parque parque;
    private LC_Atracoes atracoes;

    // Header
    private JLabel nomeParque;
    private JButton JB_comeco;
    private JButton JB_parque;
    private JButton JB_atracoes;
    private JButton JB_cliente;

    // Main
    private JLabel JL_nome_atracao;     // Depende da atração
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

    // Restaurante

    private JButton JB_prev;            // Navegar entre atrações
    private JButton JB_next;            // Navegar entre atrações

    private JButton JB_novo_brinquedo;      // Nova janela para criação de atração
    private JButton JB_novo_restaurante;    // Nova janela para criação de restaurante
    private JButton JB_salvar;              // Salvar criações

    // Footer
    private JLabel visitantes;
    private JLabel qtdVisitantes;
    
    public TAtracoes( int width, int height ){
        super( width, height);
    }

    public TAtracoes( int width, int height, Janela jan ){
        super( width, height, jan );
    }

    public TAtracoes( int width, int height, Janela jan, Parque parque ){
        super( width, height, jan );
        this.parque = parque;
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

        this.atracoes = new LC_Atracoes( this.parque.getAtracoes() );

        this.JL_nome_atracao = new JLabel(  );     // Depende da atração
        this.JP_detalhe_atracao = new JPanel(  );  // Depende da atração

        this.JB_prev = new JButton( "<" );            // Navegar entre atrações
        this.JB_next = new JButton( ">" );            // Navegar entre atrações

        this.JB_novo_brinquedo = new JButton( "Brinquedo" );      // Nova janela para criação de atração
        this.JB_novo_restaurante = new JButton( "Restaurante" );    // Nova janela para criação de restaurante
        this.JB_salvar = new JButton( "Salvar" );              // Salvar criações

        Dimension dimension;
        
        // Nome da atração
        dimension = new Dimension( 688, 72 );
        this.JL_nome_atracao.setPreferredSize( dimension );
        this.JL_nome_atracao.setForeground( Estilo.vermelhinho );
        this.JL_nome_atracao.setBackground( Estilo.quaseBranco );
        this.JL_nome_atracao.setFont( Estilo.robotoTitle );
        this.JL_nome_atracao.setHorizontalAlignment( SwingConstants.CENTER );
        this.JL_nome_atracao.setOpaque( true );

        // Area detalhes
        dimension = new Dimension( 688, 360 );
        this.JP_detalhe_atracao.setPreferredSize( dimension );
        this.JP_detalhe_atracao.setBackground( Estilo.quaseBranco );

        // Botões navegação
        dimension = new Dimension( 72, 208 );
        
        // Prev
        this.JB_prev.setPreferredSize( dimension );
        this.JB_prev.setForeground( Estilo.vermelhinho );
        this.JB_prev.setBackground( Estilo.quaseBranco );
        this.JB_prev.setFont( Estilo.robotoTitle );

        // Next
        this.JB_next.setPreferredSize( dimension );
        this.JB_next.setForeground( Estilo.vermelhinho );
        this.JB_next.setBackground( Estilo.quaseBranco );
        this.JB_next.setFont( Estilo.robotoTitle );

        // Botões de criação e salvar
        dimension = new Dimension( 208, 90 );
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

        if ( !this.atracoes.getAtracoes().isEmpty() ){

            Atracao atual = this.atracoes.getAtual();
            this.JL_nome_atracao.setText( atual.getNome() );

            if ( atual instanceof Brinquedo ){
                this.initCardBrinquedo( (Brinquedo) atual );
            }
            if ( atual instanceof Restaurante ){
                this.initCardRestaurante( (Restaurante) atual );
            }
        } else {
            this.JL_nome_atracao.setText( "Parque vazio" );
        }

        this.center.add( this.JL_nome_atracao );
        this.center.add( this.JB_prev );
        this.center.add( this.JP_detalhe_atracao );
        this.center.add( this.JB_next );
        this.center.add( this.JB_novo_brinquedo );
        this.center.add( this.JB_novo_restaurante );
        this.center.add( this.JB_salvar );

        // Posicionando prev
        this.centerLayout.putConstraint( SpringLayout.WEST, this.JB_prev, 28, SpringLayout.WEST, this.center);
        this.centerLayout.putConstraint( SpringLayout.VERTICAL_CENTER, this.JB_prev, 0, SpringLayout.VERTICAL_CENTER, this.center);

        // Poisicionando detalhes da atração
        this.centerLayout.putConstraint( SpringLayout.WEST, this.JP_detalhe_atracao, 64, SpringLayout.EAST, this.JB_prev );
        this.centerLayout.putConstraint( SpringLayout.SOUTH, this.JP_detalhe_atracao, -16, SpringLayout.SOUTH, this.center);

        // Poisicionando nome da atração
        this.centerLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, this.JL_nome_atracao, 0, SpringLayout.HORIZONTAL_CENTER, this.JP_detalhe_atracao );
        this.centerLayout.putConstraint( SpringLayout.NORTH, this.JL_nome_atracao, 16, SpringLayout.NORTH, this.center);

        // Posicionando next
        this.centerLayout.putConstraint( SpringLayout.WEST, this.JB_next, 64, SpringLayout.EAST, this.JP_detalhe_atracao);
        this.centerLayout.putConstraint( SpringLayout.VERTICAL_CENTER, this.JB_next, 0, SpringLayout.VERTICAL_CENTER, this.center);

        // Posicionando o botão do novo restaurante
        this.centerLayout.putConstraint( SpringLayout.EAST, this.JB_novo_restaurante, -40, SpringLayout.EAST, this.center);
        this.centerLayout.putConstraint( SpringLayout.VERTICAL_CENTER, this.JB_novo_restaurante, 0, SpringLayout.VERTICAL_CENTER, this.center);

        // Posicionando o botão do novo brinquedo
        this.centerLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, this.JB_novo_brinquedo, 0, SpringLayout.HORIZONTAL_CENTER, this.JB_novo_restaurante);
        this.centerLayout.putConstraint( SpringLayout.SOUTH, this.JB_novo_brinquedo, -48, SpringLayout.NORTH, this.JB_novo_restaurante);

        // Posicionando o botão de salvar
        this.centerLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, this.JB_salvar, 0, SpringLayout.HORIZONTAL_CENTER, this.JB_novo_restaurante);
        this.centerLayout.putConstraint( SpringLayout.NORTH, this.JB_salvar, 48, SpringLayout.SOUTH, this.JB_novo_restaurante);
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

        //preco
        this.JTF_preco.setPreferredSize( dimension );
        this.JTF_preco.setBackground( Estilo.vermelhinho );
        this.JTF_preco.setForeground( Estilo.quaseBranco );
        this.JTF_preco.setFont( Estilo.robotoLabel );

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

        //Ocupação
        this.JL_ocupacao.setPreferredSize( dimension );
        this.JL_ocupacao.setBackground( Estilo.vermelhinho );
        this.JL_ocupacao.setForeground( Estilo.quaseBranco );
        this.JL_ocupacao.setFont( Estilo.robotoLabelData );
        this.JL_ocupacao.setOpaque( true );

        //Abertura
        this.JTF_abertura.setPreferredSize( dimension );
        this.JTF_abertura.setBackground( Estilo.vermelhinho );
        this.JTF_abertura.setForeground( Estilo.quaseBranco );
        this.JTF_abertura.setFont( Estilo.robotoLabelData );

        //Fechamento
        this.JTF_fechamento.setPreferredSize( dimension );
        this.JTF_fechamento.setBackground( Estilo.vermelhinho );
        this.JTF_fechamento.setForeground( Estilo.quaseBranco );
        this.JTF_fechamento.setFont( Estilo.robotoLabelData );

        this.JP_detalhe_atracao.add( this.JTF_id );
        this.JP_detalhe_atracao.add( this.JTF_preco );

        this.JP_detalhe_atracao.add( this.JTA_desc );

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

        Dimension dimension = new Dimension( 189, 27 );
        //Idade mínima
        this.JTF_idade_min.setPreferredSize( dimension );
        this.JTF_idade_min.setBackground( Estilo.vermelhinho );
        this.JTF_idade_min.setForeground( Estilo.quaseBranco );
        this.JTF_idade_min.setFont( Estilo.robotoLabelData );

        //Altura máxima
        this.JTF_altura_max.setPreferredSize( dimension );
        this.JTF_altura_max.setBackground( Estilo.vermelhinho );
        this.JTF_altura_max.setForeground( Estilo.quaseBranco );
        this.JTF_altura_max.setFont( Estilo.robotoLabelData );

        //Altura mínima
        this.JTF_altura_min.setPreferredSize( dimension );
        this.JTF_altura_min.setBackground( Estilo.vermelhinho );
        this.JTF_altura_min.setForeground( Estilo.quaseBranco );
        this.JTF_altura_min.setFont( Estilo.robotoLabelData );

        this.JP_detalhe_atracao.add( this.JTF_idade_min );
        this.JP_detalhe_atracao.add( this.JTF_altura_max );
        this.JP_detalhe_atracao.add( this.JTF_altura_min );

        // Poicionando a altura mínima
        this.atracLayout.putConstraint( SpringLayout.EAST, this.JTF_altura_max, -23, SpringLayout.EAST, this.JP_detalhe_atracao );
        this.atracLayout.putConstraint( SpringLayout.VERTICAL_CENTER, this.JTF_altura_max, 0, SpringLayout.VERTICAL_CENTER, this.JP_detalhe_atracao );

        // Poicionando a idade mínima
        this.atracLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, this.JTF_idade_min, 0, SpringLayout.HORIZONTAL_CENTER, this.JTF_altura_max );
        this.atracLayout.putConstraint( SpringLayout.SOUTH, this.JTF_idade_min, -27, SpringLayout.NORTH, this.JTF_altura_max );

        // Poicionando a idade mínima
        this.atracLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, this.JTF_altura_min, 0, SpringLayout.HORIZONTAL_CENTER, this.JTF_altura_max );
        this.atracLayout.putConstraint( SpringLayout.NORTH, this.JTF_altura_min, 27, SpringLayout.SOUTH, this.JTF_altura_max );

    }

    private void initCardRestaurante( Restaurante rest ){
        this.initCardAtracao( rest );
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
            this.jan.trocarTela( "Novo_Cliente" );
        }

        if ( e.getSource() == this.JB_prev ){
            System.out.println( "Próxima atração" );
            this.atracoes.gotoPrev();
            this.jan.trocarTela( "Aba_atrações" );
        }

        if ( e.getSource() == this.JB_next ){
            System.out.println( "Atração anterior" );
            this.atracoes.gotoNext();
            this.jan.trocarTela( "Aba_atrações" );
        }

        if ( e.getSource() == this.JB_salvar ){
            System.out.println( "Salvar mudanças!" );

            String nome = this.JL_nome_atracao.getText();
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
            
            this.atracoes.getAtual().setNome( nome );
            this.atracoes.getAtual().setID( Integer.parseInt( id ) );
            this.atracoes.getAtual().setPreco( Integer.parseInt( preco ) );
            this.atracoes.getAtual().setDescricao( descricao );
            this.atracoes.getAtual().setCapacidade_max( Integer.parseInt( capacidade ) );
            this.atracoes.getAtual().setOcupacaoAtual( Integer.parseInt( ocupacao_atual ) );
            this.atracoes.getAtual().setAbertura( LocalTime.parse( abertura ) );
            this.atracoes.getAtual().setFechamento( LocalTime.parse( fechamento ) );

            if ( this.atracoes.getAtual() instanceof Brinquedo ){
                String idade_min = this.JTF_idade_min.getText();
                String altura_max = this.JTF_altura_max.getText();
                String altura_min = this.JTF_altura_min.getText();

                idade_min = getToDigitParts( idade_min );
                altura_max = getToDigitParts( altura_max );
                altura_min = getToDigitParts( altura_min );

                ( (Brinquedo) this.atracoes.getAtual() ).setIdade_min( Integer.parseInt( idade_min ) );
                ( (Brinquedo) this.atracoes.getAtual() ).setAltura_max( Float.parseFloat( altura_max ) );
                ( (Brinquedo) this.atracoes.getAtual() ).setAltura_min( Float.parseFloat( altura_min ) );
            }

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
