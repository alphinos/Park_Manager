package src.Telas.Cliente;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import src.Parque;
import src.Visitante;
import src.Interface.Estilo;
import src.Interface.Janela;
import src.Interface.Tela;

public class CTComecoCliente extends Tela implements ActionListener {

    private JLabel nomeCliente;

    // Botões do header - basicamente, um menu
    private JButton JB_comeco;
    private JButton JB_bilheteria;
    private JButton JB_atracoes;

    private JLabel JL_idade;
    private JLabel JL_altura;
    private JLabel JL_dinheiro;
    private JLabel JL_fichas;

    private Parque parque; //Para carregar os dados do parque
    private Visitante cliente;

    public CTComecoCliente( int width, int height ){
        super( width, height);
    }

    public CTComecoCliente( int width, int height, Janela jan ){
        super( width, height, jan );
    }

    public CTComecoCliente( int width, int height, Janela jan, Visitante cliente ){
        super( width, height, jan );
        this.cliente = cliente;
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
        this.initHeader();
        this.initMain();
        this.initFooter();

        System.out.println( this.cliente.getNome() );
        System.out.println( this.cliente.getIdade() );
        System.out.println( this.cliente.getAltura() );
        System.out.println( this.cliente.getDinheiro() );
        System.out.println( this.cliente.getFichas() );
    }

    private void initLabelsTextos(){        
        String nomeCliente = this.cliente.getNome();
        String idade = Integer.toString( this.cliente.getIdade() );
        String altura = Float.toString( this.cliente.getAltura() );
        String dinheiro = Float.toString( this.cliente.getDinheiro() );
        String fichas = Integer.toString( this.cliente.getFichas() );

        this.nomeCliente = new JLabel( nomeCliente, SwingConstants.CENTER );    
        this.JL_idade = new JLabel( "Idade: " + idade, SwingConstants.CENTER );    
        this.JL_altura = new JLabel( "Altura: " + altura, SwingConstants.CENTER );    
        this.JL_dinheiro = new JLabel( "Dinheiro: " + dinheiro, SwingConstants.CENTER );    
        this.JL_fichas = new JLabel( "Fichas: " + fichas, SwingConstants.CENTER );    

        this.nomeCliente.setForeground( Estilo.branco );
        this.nomeCliente.setFont( Estilo.robotoTitle );

        this.JL_idade.setBackground( Estilo.verdinho );
        this.JL_idade.setForeground( Estilo.preto );
        this.JL_idade.setFont( Estilo.robotoTitle );
        this.JL_idade.setOpaque( true );

        this.JL_altura.setBackground( Estilo.verdinho );
        this.JL_altura.setForeground( Estilo.preto );
        this.JL_altura.setFont( Estilo.robotoTitle );
        this.JL_altura.setOpaque( true );

        this.JL_dinheiro.setBackground( Estilo.verdinho );
        this.JL_dinheiro.setForeground( Estilo.preto );
        this.JL_dinheiro.setFont( Estilo.robotoTitle );
        this.JL_dinheiro.setOpaque( true );

        this.JL_fichas.setBackground( Estilo.verdinho );
        this.JL_fichas.setForeground( Estilo.preto );
        this.JL_fichas.setFont( Estilo.robotoTitle );
        this.JL_fichas.setOpaque( true );

        // Configurante tamanhos
        Dimension dim = new Dimension( 366, 80 );
        
        this.JL_idade.setPreferredSize( dim );
        this.JL_altura.setPreferredSize( dim );
        this.JL_dinheiro.setPreferredSize( dim );
        this.JL_fichas.setPreferredSize( dim );

    }

    private void initBotoes(){
        this.JB_comeco = new JButton( "Começo" );
        this.JB_bilheteria = new JButton( "Bilheteria" );
        this.JB_atracoes = new JButton( "Atrações" );

        // Configurando o fundo, fonte e cor dos textos
        this.JB_comeco.setBackground( Estilo.quaseBranco );
        this.JB_comeco.setForeground( Estilo.verdaozao );
        this.JB_comeco.setFont( Estilo.robotoButton );

        this.JB_bilheteria.setBackground( Estilo.verdaozao );
        this.JB_bilheteria.setForeground( Estilo.quaseBranco );
        this.JB_bilheteria.setFont( Estilo.robotoButton );

        this.JB_atracoes.setBackground( Estilo.verdaozao );
        this.JB_atracoes.setForeground( Estilo.quaseBranco );
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

        // Inicializando painel de imagem


        // Adicionando componentes no painel da main
        this.center.add( this.JL_idade );
        this.center.add( this.JL_altura );
        this.center.add( this.JL_dinheiro );
        this.center.add( this.JL_fichas );

        //Idade
        this.centerLayout.putConstraint( SpringLayout.EAST, this.JL_idade, -16, SpringLayout.HORIZONTAL_CENTER, this.center );
        this.centerLayout.putConstraint( SpringLayout.NORTH, this.JL_idade, 48, SpringLayout.NORTH, this.center );

        //Altura
        this.centerLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, this.JL_altura, 0, SpringLayout.HORIZONTAL_CENTER, this.JL_idade );
        this.centerLayout.putConstraint( SpringLayout.NORTH, this.JL_altura, 16, SpringLayout.SOUTH, this.JL_idade );

        //Dinnheiro
        this.centerLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, this.JL_dinheiro, 0, SpringLayout.HORIZONTAL_CENTER, this.JL_altura );
        this.centerLayout.putConstraint( SpringLayout.NORTH, this.JL_dinheiro, 16, SpringLayout.SOUTH, this.JL_altura );

        //Fichas
        this.centerLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, this.JL_fichas, 0, SpringLayout.HORIZONTAL_CENTER, this.JL_dinheiro );
        this.centerLayout.putConstraint( SpringLayout.NORTH, this.JL_fichas, 16, SpringLayout.SOUTH, this.JL_dinheiro );

    }

    private void initFooter(){
        this.footer.setBackground( Estilo.verdao );
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
    }
}
