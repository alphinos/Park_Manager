package src.Telas;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import java.awt.Dimension;

import src.Interface.Estilo;
import src.Interface.Tela;

public class Inicio extends Tela {
    
    private JButton novoParque;
    private JButton abrirParque;

    public Inicio(){
        super();
        this.start();
    }

    private void start(){

        SpringLayout layout = new SpringLayout();

        this.center.setLayout( layout );

        novoParque = new JButton("Novo parque", null);
        abrirParque = new JButton("Abrir parque", null);

        novoParque.paint(null);

        novoParque.setFont(Estilo.robotoButton);
        abrirParque.setFont(Estilo.robotoButton);

        novoParque.setForeground( Estilo.branco );
        abrirParque.setForeground( Estilo.branco );

        novoParque.setBackground(Estilo.vermelhinho);
        abrirParque.setBackground(Estilo.vermelhinho);

        Dimension size = new Dimension(320, 80);

        novoParque.setPreferredSize(size);
        abrirParque.setPreferredSize(size);

        novoParque.setBorderPainted(false);
        abrirParque.setBorderPainted(false);

        this.center.add(novoParque);
        this.center.add(abrirParque);

        layout.putConstraint(SpringLayout.VERTICAL_CENTER, novoParque, 0, SpringLayout.VERTICAL_CENTER, this.center);
        layout.putConstraint(SpringLayout.WEST, novoParque, 80, SpringLayout.WEST, this.center);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, abrirParque, 0, SpringLayout.VERTICAL_CENTER, this.center);
        layout.putConstraint(SpringLayout.EAST, abrirParque, -80, SpringLayout.EAST, this.center);

        JLabel title = new JLabel( "GERENCIADOR" );
        title.setFont( Estilo.robotoTitle );
        title.setForeground( Estilo.branco );

        layout = new SpringLayout();

        this.header.setLayout( layout );
        this.header.add(title);

        layout.putConstraint( SpringLayout.VERTICAL_CENTER, title, 0, SpringLayout.VERTICAL_CENTER, this.header);
        layout.putConstraint( SpringLayout.HORIZONTAL_CENTER, title, 0, SpringLayout.HORIZONTAL_CENTER, this.header);
    }

}
