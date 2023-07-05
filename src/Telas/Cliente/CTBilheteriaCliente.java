package src.Telas.Cliente;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import src.Parque;
import src.Visitante;
import src.Files.FCliente;
import src.Interface.Estilo;
import src.Interface.JCliente;
import src.Interface.Janela;
import src.Interface.Tela;

public class CTBilheteriaCliente extends Tela implements ActionListener {

    private JLabel nomeCliente;

    // Botões do header - basicamente, um menu
    private JButton JB_comeco;
    private JButton JB_bilheteria;
    private JButton JB_atracoes;

    private JLabel JL_preco_ficha;

    private JLabel JL_quantidade;
    private JTextField JTF_fichas;
    private JLabel JL_dinheiro;
    private JButton JB_comprar;

    private Parque parque; //Para carregar os dados do parque
    private Visitante cliente;

    public CTBilheteriaCliente( int width, int height ){
        super( width, height);
    }

    public CTBilheteriaCliente( int width, int height, Janela jan ){
        super( width, height, jan );
    }

    public CTBilheteriaCliente( int width, int height, Janela jan, Visitante cliente, Parque parque ){
        super( width, height, jan );
        this.cliente = cliente;
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
        String dinheiro = Float.toString( this.cliente.getAltura() );
        String preco = this.parque.getPrecoFichaFormat();

        this.nomeCliente = new JLabel( nomeCliente, SwingConstants.CENTER );    
        this.JL_preco_ficha = new JLabel( "Preço da ficha: " + preco );
        this.JL_quantidade = new JLabel( "Quantidade:", SwingConstants.CENTER );    
        this.JTF_fichas = new JTextField( "0" );
        this.JL_dinheiro = new JLabel( "Dinheiro: " + dinheiro, SwingConstants.CENTER );    
        this.JB_comprar = new JButton( "Comprar" );    

        this.nomeCliente.setForeground( Estilo.branco );
        this.nomeCliente.setFont( Estilo.robotoTitle );

        this.JL_preco_ficha.setBackground( Estilo.verdinho );
        this.JL_preco_ficha.setForeground( Estilo.preto );
        this.JL_preco_ficha.setFont( Estilo.robotoTitle );
        this.JL_preco_ficha.setOpaque( true );

        this.JL_quantidade.setBackground( Estilo.verdinho );
        this.JL_quantidade.setForeground( Estilo.preto );
        this.JL_quantidade.setFont( Estilo.robotoTitle );
        this.JL_quantidade.setOpaque( true );

        this.JTF_fichas.setBackground( Estilo.verdinho );
        this.JTF_fichas.setForeground( Estilo.preto );
        this.JTF_fichas.setFont( Estilo.robotoTitle );
        this.JTF_fichas.setHorizontalAlignment( SwingConstants.CENTER );

        this.JL_dinheiro.setBackground( Estilo.verdinho );
        this.JL_dinheiro.setForeground( Estilo.preto );
        this.JL_dinheiro.setFont( Estilo.robotoTitle );
        this.JL_dinheiro.setOpaque( true );

        this.JB_comprar.setBackground( Estilo.verdinho );
        this.JB_comprar.setForeground( Estilo.preto );
        this.JB_comprar.setFont( Estilo.robotoTitle );
        this.JB_comprar.addActionListener( this );

        // Configurante tamanhos
        Dimension dim;

        dim = new Dimension( 480, 80 );
        this.JL_preco_ficha.setPreferredSize( dim );

        dim = new Dimension( 360, 80 );
        
        this.JL_quantidade.setPreferredSize( dim );
        this.JTF_fichas.setPreferredSize( dim );

        dim = new Dimension( 304, 80 );
        this.JL_dinheiro.setPreferredSize( dim );
        this.JB_comprar.setPreferredSize( dim );
    }

    private void initBotoes(){
        this.JB_comeco = new JButton( "Começo" );
        this.JB_bilheteria = new JButton( "Bilheteria" );
        this.JB_atracoes = new JButton( "Atrações" );

        // Configurando o fundo, fonte e cor dos textos
        this.JB_comeco.setBackground( Estilo.verdaozao );
        this.JB_comeco.setForeground( Estilo.quaseBranco );
        this.JB_comeco.setFont( Estilo.robotoButton );

        this.JB_bilheteria.setBackground( Estilo.quaseBranco );
        this.JB_bilheteria.setForeground( Estilo.verdaozao );
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

        // Adicionando componentes no painel da main
        this.center.add( this.JL_preco_ficha );
        this.center.add( this.JL_quantidade );
        this.center.add( this.JTF_fichas );
        this.center.add( this.JL_dinheiro );
        this.center.add( this.JB_comprar );


        //Preço ficha
        this.centerLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, this.JL_preco_ficha, 0, SpringLayout.HORIZONTAL_CENTER, this.center );
        this.centerLayout.putConstraint( SpringLayout.VERTICAL_CENTER, this.JL_preco_ficha, -96, SpringLayout.VERTICAL_CENTER, this.center );

        //Quantidade
        this.centerLayout.putConstraint( SpringLayout.EAST, this.JL_quantidade, -16, SpringLayout.HORIZONTAL_CENTER, this.center );
        this.centerLayout.putConstraint( SpringLayout.VERTICAL_CENTER, this.JL_quantidade, 0, SpringLayout.VERTICAL_CENTER, this.center );

        //Fichas
        this.centerLayout.putConstraint( SpringLayout.WEST, this.JTF_fichas, 16, SpringLayout.HORIZONTAL_CENTER, this.center );
        this.centerLayout.putConstraint( SpringLayout.VERTICAL_CENTER, this.JTF_fichas, 0, SpringLayout.VERTICAL_CENTER, this.center );

        //Dinnheiro
        this.centerLayout.putConstraint( SpringLayout.WEST, this.JL_dinheiro, 0, SpringLayout.WEST, this.JL_quantidade );
        this.centerLayout.putConstraint( SpringLayout.VERTICAL_CENTER, this.JL_dinheiro, 96, SpringLayout.VERTICAL_CENTER, this.center );

        //Comprar
        this.centerLayout.putConstraint( SpringLayout.EAST, this.JB_comprar, 0, SpringLayout.EAST, this.JTF_fichas );
        this.centerLayout.putConstraint( SpringLayout.VERTICAL_CENTER, this.JB_comprar, 96, SpringLayout.VERTICAL_CENTER, this.center );

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

        if ( e.getSource() == this.JB_comprar ){
            int qtd_fichas = Integer.parseInt( this.getToDigitParts( this.JTF_fichas.getText() ) );
            this.parque.venderFichas( this.cliente, qtd_fichas, parque.getPrecoFicha() );
            ( (JCliente) this.jan ).setVisitante( this.cliente );
            FCliente.escrever( this.cliente );
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
