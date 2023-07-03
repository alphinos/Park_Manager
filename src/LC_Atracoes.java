package src;

import java.util.ArrayList;

public class LC_Atracoes {

    private ArrayList< Atracao > al_atracoes;

    private Atracao atual;

    private int i_atual;

    private Atracao first;
    private Atracao last;

    public LC_Atracoes(){
        al_atracoes = new ArrayList< Atracao >();
    }
    
    public LC_Atracoes( ArrayList< Atracao > al_atracoes ){
        this.setAtracoes( al_atracoes );
        this.setFirst();
        this.setLast();
        this.setAtualPrimeiro();
    }

    public ArrayList< Atracao > getAtracoes(){
        return this.al_atracoes;
    }

    public Atracao getAtual(){
        return this.atual;
    }

    public void setAtracoes( ArrayList< Atracao > atracoes ){
        this.al_atracoes = atracoes;
    }

    public void setFirst(  ){
        if ( this.al_atracoes.isEmpty() ){
            System.out.println( "Lista vazia!" );
            return;
        }
        this.first = this.al_atracoes.get( 0 );
    }

    public void setLast(  ){
        if ( this.al_atracoes.isEmpty() ){
            System.out.println( "Lista vazia!" );
            return;
        }
        this.last = this.al_atracoes.get( this.al_atracoes.size() - 1 );
    }

    public void setAtualPrimeiro(){
        this.atual = this.first;
        this.i_atual = 0;
    }

    public void setAtualUltimo(){
        this.atual = this.last;
        this.i_atual = this.al_atracoes.size() - 1;
    }

    public Atracao gotoNext(){
        if ( this.al_atracoes.isEmpty() ){
            System.out.println( "Lista vazia!" );
            return null;
        }
        
        if ( this.atual == this.last ){
            this.setAtualPrimeiro();
            return this.atual;
        }
        i_atual++;
        this.atual = this.al_atracoes.get( i_atual );
        return this.atual;
    }

    public Atracao gotoPrev(){
        if ( this.al_atracoes.isEmpty() ){
            System.out.println( "Lista vazia!" );
            return null;
        }

        if ( this.atual == this.first ){
            this.setAtualUltimo();
            return this.atual;
        }
        i_atual--;
        this.atual = this.al_atracoes.get( i_atual );
        return this.atual;
    }
}
