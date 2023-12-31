package src;

import java.text.DecimalFormat;
import java.util.ArrayList;
import  java.util.Random;

public class Parque {

    private String nome;
    private String descricao;
    private float precoFicha;
    private int capacidade;
    private int qtdVisitantes;

    private String path;

    private ArrayList<Atracao> atracoes;

    public Parque(){
        this.atracoes = new ArrayList<Atracao>();
    }

    public Parque( String nome, String descricao, float precoFicha, int capacidade){
        this.nome = nome;
        this.descricao = descricao;
        this.precoFicha = precoFicha;
        this.capacidade = capacidade;
        this.qtdVisitantes = 0;
        this.atracoes = new ArrayList<Atracao>();
    }

    public Parque( String nome, String descricao, float precoFicha, int capacidade, ArrayList<Atracao> atracoes ){
        this.nome = nome;
        this.descricao = descricao;
        this.precoFicha = precoFicha;
        this.capacidade = capacidade;
        this.qtdVisitantes = 0;
        this.atracoes = new ArrayList<Atracao>();
    }

    public String getNome(){
        return this.nome;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public float getPrecoFicha(){
        return this.precoFicha;
    }

    public String getPrecoFichaFormat(){
        DecimalFormat fmt = new DecimalFormat("#,###.00");
        return "R$ " + fmt.format( this.precoFicha );
    }

    public ArrayList<Atracao> getAtracoes(){
        return this.atracoes;
    }

    public int getCapacidade(){
        return this.capacidade;
    }

    public int getQtdVisitantes(){
        return this.qtdVisitantes;
    }

    public void setNome( String nome ){
        this.nome = nome;
    }

    public void setDescricao( String descricao ){
        this.descricao = descricao;
    }

    public void setPrecoFicha( float preco ){
        this.precoFicha = preco;
    }

    public void setAtracoes( ArrayList<Atracao> atracoes ){
        this.atracoes = atracoes;
        this.setAllQtdVisitante();
    }

    public void addAtracao( Atracao atracao ){
        this.atracoes.add( atracao );
        this.setAllQtdVisitante();
    }

    public void removeAtracao( Atracao atracao ){
        this.atracoes.remove(atracao);
    }

    public String getPath(){
        return this.path;
    }

    public void setPath( String path ){
        this.path = path;
    }

    public void setCapacidade( int capacidade ){
        if ( capacidade < 1 ){
            System.out.println( "A capacidade deve ser positiva" );
            return;
        }
        if ( capacidade < this.qtdVisitantes ){
            this.qtdVisitantes = capacidade;
        }
        this.capacidade = capacidade;
    }

    public void setQtdVisitantes( int qtdVisitantes ){
        if ( qtdVisitantes < 0 ){
            System.out.println( "A quantidade deve ser maior ou igual a zero" );
            return;
        }

        this.qtdVisitantes = qtdVisitantes;
    }

    public void setAllQtdVisitante(  ){
        if ( !this.atracoes.isEmpty() ){
            int soma = 0;
            for ( Atracao a : this.atracoes ){
                soma += a.getOcupacaoAtual();
            }
            this.qtdVisitantes = soma;
        }
    }

    public void randomQtdVisitantes(){
        Random gen = new Random();
        this.qtdVisitantes = gen.nextInt( this.capacidade + 1 );
    }

    public boolean venderFichas( Visitante cliente, int n_fichas, float preco ){
        return cliente.comprarFichas(n_fichas, preco);
    }
}
