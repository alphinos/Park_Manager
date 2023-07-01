package src.Telas.Cliente;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import src.Interface.Estilo;
import src.Interface.Janela;
import src.Interface.Tela;

public class CarregarCliente extends Tela {

    private JFileChooser chooser;
    
    public CarregarCliente( int width, int height ){
        super( width, height);
        this.start();
    }

    public CarregarCliente( int width, int height, Janela jan ){
        super( width, height, jan );
        this.start();
    }

    public void start(){

        this.header.setBackground( Estilo.verdao );
        this.main.setBackground( Estilo.verdao );
        this.footer.setBackground( Estilo.verdao );

        JLabel title = new JLabel( "CLIENTE" );
        title.setFont( Estilo.robotoTitle );
        title.setForeground( Estilo.branco );

        this.headerLayout = new SpringLayout();

        this.header.setLayout( this.headerLayout );
        this.header.add(title);

        // Definição do posicionamento do título com base no painel "header" < this.header >
        this.headerLayout.putConstraint( SpringLayout.VERTICAL_CENTER, title, 0, SpringLayout.VERTICAL_CENTER, this.header);
        this.headerLayout.putConstraint( SpringLayout.HORIZONTAL_CENTER, title, 0, SpringLayout.HORIZONTAL_CENTER, this.header);

        this.chooser = new JFileChooser( "Parques" );
        FileFilter filter = new FileNameExtensionFilter("CLIENTE file", "cliente", "CLIENTE");
        chooser.setFileFilter( filter );
        chooser.addChoosableFileFilter( filter );
    }

    public void showChooser(){
        this.chooser.setDialogTitle( "Abrir parque" );
        this.chooser.showOpenDialog( new JFrame() );
    }
}
