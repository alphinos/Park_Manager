package src.Telas;

import javax.swing.JLabel;
import javax.swing.SpringLayout;

import src.Interface.Estilo;
import src.Interface.Janela;
import src.Interface.Tela;

public class AbrirParque extends Tela {
    
    public AbrirParque(){
        super();
        this.start();
    }

    public AbrirParque( Janela jan){
        super( jan );
        this.start();
    }

    public void start(){
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
}
