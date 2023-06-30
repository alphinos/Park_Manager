package src.Telas;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.Interface.Estilo;
import src.Interface.Janela;
import src.Interface.Tela;

public class Inicio extends Tela implements ActionListener {
    
    private JButton novoParque;
    private JButton abrirParque;

    public Inicio( int width, int height ){
        super( width, height);
        this.start();
    }

    public Inicio( int width, int height, Janela jan ){
        super( width, height, jan );
        this.start();
    }

    private void start(){

        novoParque = new JButton("Novo parque");
        abrirParque = new JButton("Abrir parque");

        novoParque.addActionListener( this );
        abrirParque.addActionListener( this );

        novoParque.setFont(Estilo.robotoButton);
        abrirParque.setFont(Estilo.robotoButton);

        // Definindo as cores dos textos
        novoParque.setForeground( Estilo.branco );
        abrirParque.setForeground( Estilo.branco );

        novoParque.setBackground(Estilo.vermelhinho);
        abrirParque.setBackground(Estilo.vermelhinho);

        // Tamanho dos botões
        Dimension size = new Dimension(320, 80);

        novoParque.setPreferredSize(size);
        abrirParque.setPreferredSize(size);

        novoParque.setBorderPainted(false);
        abrirParque.setBorderPainted(false);

        this.center.add(novoParque);
        this.center.add(abrirParque);

        // Definição do posicionamento dos componentes com base no painel em que estão
        this.centerLayout.putConstraint(SpringLayout.VERTICAL_CENTER, novoParque, 0, SpringLayout.VERTICAL_CENTER, this.center);
        this.centerLayout.putConstraint(SpringLayout.WEST, novoParque, 80, SpringLayout.WEST, this.center);
        this.centerLayout.putConstraint(SpringLayout.VERTICAL_CENTER, abrirParque, 0, SpringLayout.VERTICAL_CENTER, this.center);
        this.centerLayout.putConstraint(SpringLayout.EAST, abrirParque, -80, SpringLayout.EAST, this.center);

        JLabel title = new JLabel( "GERENCIADOR" );
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
        if ( e.getSource() == this.novoParque ){
            System.out.println( "Novo parque!" );
            this.jan.trocarTela( "novo_parque" );
        }

        if ( e.getSource() == this.abrirParque ){
            System.out.println( "Abrir parque!" );
            this.jan.trocarTela( "abrir_parque" );
        }
    }
}
