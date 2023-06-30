package src.Interface;

public class Cliente extends Janela {
    
    public Cliente( int width, int height){
        super( width, height );
    }

    public Cliente( int width, int height, Tela tela ){
        super( width, height, tela );
    }

    public Cliente( int width, int height, Tela tela, String nome ){
        super( width, height, tela, nome );
    }

    public void initTelas(){

    }

    public void trocarTela( String tela ){

    }
}
