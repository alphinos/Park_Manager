package src.Telas.Cliente;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import src.Interface.Estilo;
import src.Interface.Janela;
import src.Interface.Tela;

public class NovoCliente extends Tela implements ActionListener {

    private JPanel novoCliente;

    private JLabel cliente;

    private JLabel nome;
    private JTextField campo_nome ;

    private JLabel descricao;
    private JTextField campo_descricao;

    private JLabel dinheiro;
    private JTextField campo_dinheiro;

    private JButton criar;
    private JButton cancelar;

    public JPanel getnovoCliente(){
        return this.novoCliente;
    }
    
    public NovoCliente( int width, int height ){
        super( width, height);
        this.start();
    }

    public NovoCliente( int width, int height, Janela jan ){
        super( width, height, jan );
        this.start();
    }

    public void start(){

        this.header.setBackground( Estilo.verdao );
        this.main.setBackground( Estilo.verdao );
        this.footer.setBackground( Estilo.verdao );

        this.north.setBackground( Estilo.verdao );
        this.center.setBackground( Estilo.verdao );
        this.south.setBackground( Estilo.verdao );
        this.west.setBackground( Estilo.verdao );
        this.east.setBackground( Estilo.verdao );

        JLabel title = new JLabel( "CLIENTE" );
        title.setFont( Estilo.robotoTitle );
        title.setForeground( Estilo.branco );

        this.headerLayout = new SpringLayout();

        this.header.setLayout( this.headerLayout );
        this.header.add(title);

        // Definição do posicionamento do título com base no painel "header" < this.header >
        this.headerLayout.putConstraint( SpringLayout.VERTICAL_CENTER, title, 0, SpringLayout.VERTICAL_CENTER, this.header);
        this.headerLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, title, 0, SpringLayout.HORIZONTAL_CENTER, this.header);

        // Painel referente ao "card" de cadastro de um novo cliente
        this.novoCliente = new JPanel();

        SpringLayout layout = new SpringLayout();

        this.novoCliente.setLayout(layout);

        this.novoCliente.setPreferredSize( new Dimension( 550, 500 ) );
        this.novoCliente.setBackground( Estilo.verdinho );

        this.body.add(this.novoCliente, 1);

        // Centralizando o "card" de novo cliente na tela
        this.bodyLayout.putConstraint( SpringLayout.VERTICAL_CENTER, this.novoCliente, 0, SpringLayout.VERTICAL_CENTER, this.body);
        this.bodyLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, this.novoCliente, 0, SpringLayout.HORIZONTAL_CENTER, this.body);

        // Título do card
        this.cliente = new JLabel( "Novo cliente" );

        this.nome = new JLabel( "Nome" );
        this.campo_nome = new JTextField();

        this.descricao = new JLabel( "Descrição" );
        this.campo_descricao = new JTextField();

        this.dinheiro = new JLabel( "Dinheiro" );
        this.campo_dinheiro = new JTextField();

        this.criar = new JButton( "Criar" );
        this.cancelar = new JButton( "Cancelar" );

        // Configurando estilos de fonte, cor de texto
        cliente.setFont( Estilo.robotoTitle );
        cliente.setForeground( Estilo.preto );

        nome.setFont( Estilo.robotoLabel );
        nome.setForeground( Estilo.preto );

        descricao.setFont( Estilo.robotoLabel );
        descricao.setForeground( Estilo.preto );

        dinheiro.setFont( Estilo.robotoLabel );
        dinheiro.setForeground( Estilo.preto );

        criar.setFont( Estilo.robotoLabel );
        criar.setForeground( Estilo.verdinho );

        cancelar.setFont( Estilo.robotoLabel );
        cancelar.setForeground( Estilo.verdinho );

        criar.setBorderPainted(false);
        cancelar.setBorderPainted(false);

        // Configurando tamanhos
        Dimension dim = new Dimension( 144, 27 );

        criar.setPreferredSize(dim);
        cancelar.setPreferredSize(dim);

        criar.setBackground( Estilo.preto );
        cancelar.setBackground( Estilo.preto );

        dim = new Dimension( 400, 27 );

        campo_nome.setPreferredSize(dim);
        campo_descricao.setPreferredSize(dim);
        campo_dinheiro.setPreferredSize(dim);

        // Configurando estilo dos campos de texto
        campo_nome.setFont( Estilo.robotoText );
        campo_nome.setBackground( Estilo.preto );
        campo_nome.setForeground( Estilo.branco );

        campo_descricao.setFont( Estilo.robotoText );
        campo_descricao.setBackground( Estilo.preto );
        campo_descricao.setForeground( Estilo.branco );

        campo_dinheiro.setFont( Estilo.robotoText );
        campo_dinheiro.setBackground( Estilo.preto );
        campo_dinheiro.setForeground( Estilo.branco );

        // Adicionando componentes do painel principal desta tela
        this.novoCliente.add(cliente);

        this.novoCliente.add(nome);
        this.novoCliente.add(campo_nome);

        this.novoCliente.add(descricao);
        this.novoCliente.add(campo_descricao);

        this.novoCliente.add(dinheiro);
        this.novoCliente.add(campo_dinheiro);

        this.novoCliente.add(criar);
        this.novoCliente.add(cancelar);

        this.criar.addActionListener( this );
        this.cancelar.addActionListener( this );

        // Posicionando os componentes dentro do painel de criação de novo cliente

        // Título
        layout.putConstraint( SpringLayout.HORIZONTAL_CENTER, cliente, 0, SpringLayout.HORIZONTAL_CENTER, this.novoCliente );
        layout.putConstraint( SpringLayout.NORTH, cliente, 16, SpringLayout.NORTH, this.novoCliente );

        // Nome        
        layout.putConstraint( SpringLayout.WEST, nome, 75, SpringLayout.WEST, this.novoCliente );
        layout.putConstraint( SpringLayout.NORTH, nome, 32, SpringLayout.SOUTH, cliente );

        layout.putConstraint( SpringLayout.WEST, campo_nome, 0, SpringLayout.WEST, nome );
        layout.putConstraint( SpringLayout.NORTH, campo_nome, 4, SpringLayout.SOUTH, nome );

        //Descrição
        layout.putConstraint( SpringLayout.WEST, descricao, 0, SpringLayout.WEST, campo_nome );
        layout.putConstraint( SpringLayout.NORTH, descricao, 32, SpringLayout.SOUTH, campo_nome );

        layout.putConstraint( SpringLayout.WEST, campo_descricao, 0, SpringLayout.WEST, descricao );
        layout.putConstraint( SpringLayout.NORTH, campo_descricao, 4, SpringLayout.SOUTH, descricao );

        //Dinheiro
        layout.putConstraint( SpringLayout.WEST, dinheiro, 0, SpringLayout.WEST, campo_descricao );
        layout.putConstraint( SpringLayout.NORTH, dinheiro, 32, SpringLayout.SOUTH, campo_descricao );

        layout.putConstraint( SpringLayout.WEST, campo_dinheiro, 0, SpringLayout.WEST, dinheiro );
        layout.putConstraint( SpringLayout.NORTH, campo_dinheiro, 4, SpringLayout.SOUTH, dinheiro );

        //Criar
        layout.putConstraint( SpringLayout.WEST, criar, 0, SpringLayout.WEST, campo_dinheiro );
        layout.putConstraint( SpringLayout.NORTH, criar, 48, SpringLayout.SOUTH, campo_dinheiro );

        //Cancelar
        layout.putConstraint( SpringLayout.EAST, cancelar, 0, SpringLayout.EAST, campo_dinheiro );
        layout.putConstraint( SpringLayout.NORTH, cancelar, 48, SpringLayout.SOUTH, campo_dinheiro );
    }

    @Override
    public void actionPerformed(ActionEvent event){
        if ( event.getSource() == this.criar ){
            System.out.println( "Novo cliente criado!" );

            String nome = this.campo_nome.getText();
            String desc = this.campo_descricao.getText();
            String dinheiro = this.campo_dinheiro.getText();

            System.out.println("Nome: " + nome);
            System.out.println("Descrição: " + desc);
            System.out.println("Dinheiro: " + dinheiro);

            this.jan.trocarTela( "novo_cliente" );
        }

        if ( event.getSource() == this.cancelar ){
            System.out.println( "Criação do cliente cancelada!" );
            this.jan.trocarTela( "inicio" );
        }
    }
}
