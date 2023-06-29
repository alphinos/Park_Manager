package src.Telas;

import javax.swing.JLabel;
import javax.swing.SpringLayout;

import src.Interface.Estilo;
import src.Interface.Tela;

public class AbrirParque extends Tela {
    
    public AbrirParque(){
        super();
        this.start();
    }

    public void start(){
        JLabel title = new JLabel( "ABRIR PARQUE" );
        title.setFont( Estilo.robotoTitle );
        title.setForeground( Estilo.branco );

        this.headerLayout = new SpringLayout();

        this.header.setLayout( this.headerLayout );
        this.header.add(title);

        this.headerLayout.putConstraint( SpringLayout.VERTICAL_CENTER, title, 0, SpringLayout.VERTICAL_CENTER, this.header);
        this.headerLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, title, 0, SpringLayout.HORIZONTAL_CENTER, this.header);
    }
}