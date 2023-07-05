package src;
import java.util.ArrayList;

public class Visitante {

	private String nome;
	private float dinheiro;
	private int fichas;
	private int idade;
	private float altura;	
	private ArrayList<Atracao> atracoes;
	
	public Visitante(  ) {}
	
	public Visitante( String nome, int idade, int altura, int dinheiro ) {
		this.nome = nome;
		this.setAltura( altura );
		this.setAltura( altura );
		this.dinheiro = dinheiro;
		this.fichas = 0;
		this.atracoes = new ArrayList<Atracao>();
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getDinheiro() {
		return dinheiro;
	}
	public void setDinheiro( float dinheiro) {
		if ( dinheiro < 0 ){
			System.out.println( "Não existe dinheiro negativo!!!" );
			System.out.println( "Dívidas são um conceito além do dinheiro :D " );
			return;
		}
		this.dinheiro = dinheiro;
	}
	public int getFichas() {
		return fichas;
	}
	public void setFichas(int fichas) {
		this.fichas = fichas;
	}

	public int getIdade(){
		return this.idade;
	}

	public void setIdade( int idade ){
		if ( idade < 0 ){
			System.out.println( "Não existe idade negativa!!!" );
			System.out.println( "Benjamin Button é só uma personagem :D " );
			return;
		}
		this.idade = idade;
	}

	public float getAltura(){
		return this.altura;
	}

	public void setAltura( float altura ){
		this.altura = altura;
	}

	public ArrayList<Atracao> getAtracoes() {
		return atracoes;
	}

	public void setAtracoes( ArrayList<Atracao> a ) {
		this.atracoes = a;
	}

	public void addAtracao( Atracao a ) {
		this.atracoes.add( a );
	}

	public Atracao getUltimAtracao(){
		return this.atracoes.get( this.atracoes.size() - 1 );
	}
	
	public void mostrarAtracoes() {
		for( Atracao a : atracoes ) {
			System.out.println( a.mostrarDetalhes() );
		}
		System.out.println( "Fichas: "+this.fichas );
	}
	
	public boolean comprarFichas( int n_fichas, float preco ) {
		if( n_fichas * preco <= this.dinheiro ) {
			this.dinheiro -= n_fichas * preco;
			this.fichas += n_fichas;
			return true;
		} 
		return false;
	}

}
