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

public class TInicio extends Tela implements ActionListener {
    
    private JButton novoParque;
    private JButton abrirParque;
    private JLabel title;

    public TInicio( int width, int height ){
        super( width, height);
        this.start();
    }

    public TInicio( int width, int height, Janela jan ){
        super( width, height, jan );
        this.start();
    }

    private void start(){

        this.novoParque = new JButton("Novo parque");
        this.abrirParque = new JButton("Abrir parque");

        this.novoParque.addActionListener( this );
        this.abrirParque.addActionListener( this );

        this.novoParque.setFont(Estilo.robotoButton);
        this.abrirParque.setFont(Estilo.robotoButton);

        // Definindo as cores dos textos
        this.novoParque.setForeground( Estilo.branco );
        this.abrirParque.setForeground( Estilo.branco );

        this.novoParque.setBackground(Estilo.vermelhinho);
        this.abrirParque.setBackground(Estilo.vermelhinho);

        // Tamanho dos botões
        Dimension size = new Dimension(320, 80);

        this.novoParque.setPreferredSize(size);
        this.abrirParque.setPreferredSize(size);

        this.novoParque.setBorderPainted(false);
        this.abrirParque.setBorderPainted(false);

        this.center.add(this.novoParque);
        this.center.add(this.abrirParque);

        // Definição do posicionamento dos componentes com base no painel em que estão
        this.centerLayout.putConstraint(SpringLayout.VERTICAL_CENTER, this.novoParque, 0, SpringLayout.VERTICAL_CENTER, this.center);
        this.centerLayout.putConstraint(SpringLayout.WEST, this.novoParque, 80, SpringLayout.WEST, this.center);
        this.centerLayout.putConstraint(SpringLayout.VERTICAL_CENTER, this.abrirParque, 0, SpringLayout.VERTICAL_CENTER, this.center);
        this.centerLayout.putConstraint(SpringLayout.EAST, this.abrirParque, -80, SpringLayout.EAST, this.center);

        this.title = new JLabel( "GERENCIADOR" );
        this.title.setFont( Estilo.robotoTitle );
        this.title.setForeground( Estilo.branco );

        this.headerLayout = new SpringLayout();

        this.header.setLayout( this.headerLayout );
        this.header.add( this.title );

        // Definição do posicionamento do título com base no painel "header" < this.header >
        this.headerLayout.putConstraint( SpringLayout.VERTICAL_CENTER, this.title, 0, SpringLayout.VERTICAL_CENTER, this.header);
        this.headerLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, this.title, 0, SpringLayout.HORIZONTAL_CENTER, this.header);
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
