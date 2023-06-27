package src;
import java.util.ArrayList;

public class Visitante {
	private String nome;
	private int valor;
	private int fichas;
	private ArrayList<Atracao> atracoes;
	
	
	public Visitante(String nome, int valor) {
		this.nome = nome;
		this.valor = valor;
		this.fichas = 0;
		this.atracoes = new ArrayList<Atracao>();
	}
	

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public int getFichas() {
		return fichas;
	}
	public void setFichas(int fichas) {
		this.fichas = fichas;
	}
	public ArrayList<Atracao> getAtracoes() {
		return atracoes;
	}
	public void setAtracoes(Atracao a) {
		this.atracoes.add(a);
	}
	
	public void mostrarAtracoes() {
		for(Atracao a : atracoes) {
			System.out.println(a.mostrarDetalhes());
		}
		System.out.println("Fichas: "+this.fichas);
	}
	
	public boolean comprarFichas(int n_fichas) {
		if(n_fichas*10 <= this.valor) {
			this.valor -= n_fichas*10;
			this.fichas += n_fichas;
			return true;
		} 
		return false;
		
	}

}
