package src.Telas.Cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import src.Parque;
import src.Visitante;
import src.Files.FCliente;
import src.Files.FPark;
import src.Interface.Estilo;
import src.Interface.JCliente;
import src.Interface.JGerente;
import src.Interface.Janela;
import src.Interface.Tela;

public class CTCarregarCliente extends Tela implements ActionListener {

    private JFileChooser chooser;
    
    public CTCarregarCliente( int width, int height ){
        super( width, height);
        this.start();
    }

    public CTCarregarCliente( int width, int height, Janela jan ){
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

        this.chooser = new JFileChooser( "Clientes" );
        FileFilter filter = new FileNameExtensionFilter("CLIENTE file", "cliente", "CLIENTE");
        chooser.setFileFilter( filter );
        chooser.addChoosableFileFilter( filter );
    }

    public void showChooser(){
        this.chooser.setDialogTitle( "Abrir parque" );
        this.chooser.showOpenDialog( new JFrame() );
    }

    @Override
    public void actionPerformed( ActionEvent event ){
        
        if ( event.getSource() == this.chooser ){
            if ( event.getActionCommand() == JFileChooser.APPROVE_SELECTION ){

                Visitante cliente = FCliente.ler( this.chooser.getSelectedFile().getAbsolutePath() );

                if ( this.jan instanceof JCliente ){
                    ( (JCliente) this.jan ).setVisitante( cliente );
                }

                this.jan.trocarTela( "Começo" );

            } else if ( event.getActionCommand() == JFileChooser.CANCEL_SELECTION ){
                this.jan.trocarTela( "inicio" );
            }
        }
    }
}
