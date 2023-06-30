package src.Telas;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import src.Interface.Estilo;
import src.Interface.Janela;
import src.Interface.Tela;

public class AbrirParque extends Tela {

    private JFileChooser chooser;
    
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

        this.chooser = new JFileChooser( "Parques" );
        FileFilter filter = new FileNameExtensionFilter("PARK file", "park", "PARK");
        chooser.setFileFilter( filter );
        chooser.addChoosableFileFilter( filter );
    }

    public void showChooser(){
        this.chooser.setDialogTitle( "Abrir parque" );
        this.chooser.showOpenDialog( new JFrame() );
    }
}
