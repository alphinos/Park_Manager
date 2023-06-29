package src.Interface;

import javax.swing.JFrame;

public class Janela {

    private JFrame janela;
    private Tela tela;
    private Tela inicio;
    private Tela NovoParque;
    private Tela AbrirParque;
    // private Tela Gerenciar;
    // private Tela Cliente;

    public Janela(){
        this.janela = new JFrame("Gerenciador");
        this.janela.setSize(1280, 720);
        this.janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.initTelas();


        this.tela = new Tela();
        this.tela.setJanela( this );

        this.janela.add( this.tela.body );

        this.janela.setVisible(true);
    }

    public Janela( Tela tela ){
        this.janela = new JFrame("Gerenciador");
        this.janela.setSize(1280, 720);
        this.janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.initTelas();

        this.tela = tela;
        this.tela.setJanela( this );

        this.janela.add( this.tela.body );

        this.janela.setVisible(true);
    }

    public void initTelas(){
        this.inicio = new src.Telas.Inicio();
        this.NovoParque = new src.Telas.NovoParque();
        this.AbrirParque = new src.Telas.AbrirParque();
    }

    public void trocarTela( String tela ){
        switch ( tela ){
            case "inicio":
                this.janela.remove( this.tela.body );
                this.tela = this.inicio;
                this.tela.setJanela( this );
                this.janela.add(this.tela.body);
                this.janela.setVisible(true);
                break;
            case "novo_parque":
                this.janela.remove( this.tela.body );
                this.tela = this.NovoParque;
                this.tela.setJanela( this );
                this.janela.add(this.tela.body);
                this.janela.setVisible(true);
                break;
            case "abrir_parque":
                this.janela.remove( this.tela.body );
                this.tela = this.AbrirParque;
                this.tela.setJanela( this );
                this.janela.add(this.tela.body);
                this.janela.setVisible(true);
                break;
        }
    }
}
