package src.Telas.Cliente;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.Interface.Estilo;
import src.Interface.Janela;
import src.Interface.Tela;

public class CTInicioCliente extends Tela implements ActionListener {
    
    private JButton novoCliente;
    private JButton carregarCliente;

    public CTInicioCliente( int width, int height ){
        super( width, height);
        this.start();
    }

    public CTInicioCliente( int width, int height, Janela jan ){
        super( width, height, jan );
        this.start();
    }

    private void start(){

        this.header.setBackground( Estilo.verdao );
        this.main.setBackground( Estilo.verdao );
        this.footer.setBackground( Estilo.verdao );

        this.north.setBackground( Estilo.verdao );
        this.center.setBackground( Estilo.verdao );
        this.south.setBackground( Estilo.verdao );
        this.west.setBackground( Estilo.verdao );
        this.east.setBackground( Estilo.verdao );

        novoCliente = new JButton("Novo Cliente");
        carregarCliente = new JButton("Carregar Cliente");

        novoCliente.addActionListener( this );
        carregarCliente.addActionListener( this );

        novoCliente.setFont(Estilo.robotoButton);
        carregarCliente.setFont(Estilo.robotoButton);

        // Definindo as cores dos textos
        novoCliente.setForeground( Estilo.preto );
        carregarCliente.setForeground( Estilo.preto );

        novoCliente.setBackground(Estilo.verdinho);
        carregarCliente.setBackground(Estilo.verdinho);

        // Tamanho dos botões
        Dimension size = new Dimension(320, 80);

        novoCliente.setPreferredSize(size);
        carregarCliente.setPreferredSize(size);

        novoCliente.setBorderPainted(false);
        carregarCliente.setBorderPainted(false);

        this.center.add(novoCliente);
        this.center.add(carregarCliente);

        // Definição do posicionamento dos componentes com base no painel em que estão
        this.centerLayout.putConstraint(SpringLayout.VERTICAL_CENTER, novoCliente, 0, SpringLayout.VERTICAL_CENTER, this.center);
        this.centerLayout.putConstraint(SpringLayout.WEST, novoCliente, 80, SpringLayout.WEST, this.center);
        this.centerLayout.putConstraint(SpringLayout.VERTICAL_CENTER, carregarCliente, 0, SpringLayout.VERTICAL_CENTER, this.center);
        this.centerLayout.putConstraint(SpringLayout.EAST, carregarCliente, -80, SpringLayout.EAST, this.center);

        JLabel title = new JLabel( "CLIENTE" );
        title.setFont( Estilo.robotoTitle );
        title.setForeground( Estilo.branco );

        this.headerLayout = new SpringLayout();

        this.header.setLayout( this.headerLayout );
        this.header.add(title);

        // Definição do posicionamento do título com base no painel "header" < this.header >
        this.headerLayout.putConstraint( SpringLayout.VERTICAL_CENTER, title, 0, SpringLayout.VERTICAL_CENTER, this.header);
        this.headerLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, title, 0, SpringLayout.HORIZONTAL_CENTER, this.header);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if ( e.getSource() == this.novoCliente ){
            System.out.println( "Novo Cliente!" );
            this.jan.trocarTela( "novo_Cliente" );
        }

        if ( e.getSource() == this.carregarCliente ){
            System.out.println( "Carregar Cliente!" );
            this.jan.trocarTela( "carregar_Cliente" );
        }
    }
}