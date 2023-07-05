package src.Telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import src.Parque;
import src.Files.FPark;
import src.Interface.Estilo;
import src.Interface.JGerente;
import src.Interface.Janela;
import src.Interface.Tela;

public class TAbrirParque extends Tela implements ActionListener {

    private JFileChooser chooser;
    
    public TAbrirParque( int width, int height ){
        super( width, height);
        this.start();
    }

    public TAbrirParque( int width, int height, Janela jan ){
        super( width, height, jan );
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
        this.chooser.setFileFilter( filter );
        this.chooser.addChoosableFileFilter( filter );
        this.chooser.addActionListener( this );
    }

    public void showChooser(){
        this.chooser.setDialogTitle( "Abrir parque" );
        this.chooser.showOpenDialog( new JFrame() );
    }

     @Override
    public void actionPerformed( ActionEvent event ){
        
        if ( event.getSource() == this.chooser ){
            if ( event.getActionCommand() == JFileChooser.APPROVE_SELECTION ){

                Parque parque = FPark.ler( this.chooser.getSelectedFile().getAbsolutePath() );

                if ( this.jan instanceof JGerente ){
                    ( (JGerente) this.jan ).setParque( parque );
                    if ( !parque.getAtracoes().isEmpty() ){
                        ( (JGerente) this.jan ).setAtracoes( parque.getAtracoes() );
                        ( (JGerente) this.jan ).setIDAtrac( parque.getAtracoes().get( 0 ).getID() );
                    }
                }

                this.jan.trocarTela( "Começo" );

            } else if ( event.getActionCommand() == JFileChooser.CANCEL_SELECTION ){
                this.jan.trocarTela( "inicio" );
            }
        }
    }
}
