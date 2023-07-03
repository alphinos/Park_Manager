package src.Telas;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
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

        this.JB_novo_restaurante.setPreferredSize( dimension );
        this.JB_novo_restaurante.setForeground( Estilo.vermelhinho );
        this.JB_novo_restaurante.setBackground( Estilo.quaseBranco );
        this.JB_novo_restaurante.setFont( Estilo.robotoButton );
        this.JB_novo_restaurante.setHorizontalAlignment( SwingConstants.CENTER );

        this.JB_salvar.setPreferredSize( dimension );
        this.JB_salvar.setForeground( Estilo.vermelhinho );
        this.JB_salvar.setBackground( Estilo.quaseBranco );
        this.JB_salvar.setFont( Estilo.robotoButton );
        this.JB_salvar.setHorizontalAlignment( SwingConstants.CENTER );

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

    private void initCardBrinquedo( Brinquedo brinks ){

    }

    private void initCardRestaurante( Restaurante rest ){

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

        // if ( e.getSource() == this.JB_salvar ){
        //     System.out.println( "Salvar mudanças!" );

        //     String nome = this.nomeParque.getText();
        //     String desc = this.DescTxt.getText();
        //     String preco = this.precoValor.getText();
            
        //     int i;
        //     for ( i = 0; i < preco.length(); i++){
        //         if ( Character.isDigit( preco.charAt(i) )){
        //             break;
        //         }
        //     }

        //     preco = preco.substring( i );

        //     System.out.println("Nome: " + nome);
        //     System.out.println("Descrição: " + desc);
        //     System.out.println("Preço: " + preco);

        //     Parque parque = new Parque( nome, desc, Float.parseFloat(preco), 100);

        //     if ( this.jan instanceof Gerente ){
        //         ( (Gerente) this.jan ).setParque( parque );
        //     }

        //     this.jan.trocarTela( "Aba_parque" );
        // }
    }
}
