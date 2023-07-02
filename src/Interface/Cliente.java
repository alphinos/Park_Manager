package src.Interface;

import javax.swing.JFrame;

import src.Telas.Cliente.CarregarCliente;
import src.Telas.Cliente.InicioCliente;
import src.Telas.Cliente.NovoCliente;

public class Cliente extends Janela {

    private InicioCliente inicio;
    private NovoCliente novoCliente;
    private CarregarCliente carregarCliente;
    
    public Cliente( int width, int height){
        super( width, height );
        this.janela.setDefaultCloseOperation( JFrame.HIDE_ON_CLOSE );

        this.janela.setTitle("Simulador Cliente");

        this.initTelas();
        this.setTela( this.inicio );
    }

    public Cliente( int width, int height, Tela tela ){
        super( width, height, tela );
        this.janela.setDefaultCloseOperation( JFrame.HIDE_ON_CLOSE );

        this.janela.setTitle("Simulador Cliente");
    }

    public Cliente( int width, int height, Tela tela, String nome ){
        super( width, height, tela, nome );
        this.janela.setDefaultCloseOperation( JFrame.HIDE_ON_CLOSE );

        this.janela.setTitle("Simulador Cliente");
    }

    public void initTelas(){
        this.inicio = new InicioCliente( this.width, this.height, this );
        this.novoCliente = new NovoCliente( this.width, this.height, this );
        this.carregarCliente = new CarregarCliente( this.width, this.height, this );
    }

    public void trocarTela( String tela ){
        this.janela.remove( this.tela.body );

        switch ( tela ){
            case "inicio":
                this.inicio = new InicioCliente( this.width, this.height, this );
                this.tela = this.inicio;
                break;
            case "novo_Cliente":
                this.novoCliente = new NovoCliente( this.width, this.height, this );
                this.tela = this.novoCliente;
                break;
            case "carregar_Cliente":
                this.carregarCliente = new CarregarCliente( this.width, this.height, this );
                this.tela = this.carregarCliente;
                break;
        }

        this.janela.add( this.tela.body );
        this.janela.setVisible(true);

        if ( tela == "carregar_Cliente" ){
            this.carregarCliente.showChooser();
        }
    }
}
