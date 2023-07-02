package src;
import  java.util.Random;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public abstract class Atracao implements InterfaceAtrac {
	
	protected String nome;
	protected String descricao;
	protected int ID;
	protected int capacidade_max;
	protected int ocupacao_atual;
	
	public Atracao( String n, String d, int ID, int c_max ) {
		this.nome = n;
		this.descricao = d;
		this.ID = ID;
		this.capacidade_max = c_max;
		Random generator = new Random(); 
		this.ocupacao_atual = generator.nextInt(this.capacidade_max+1);
	}
	
	//GETS AND SETS
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getCapacidade_max() {
		return capacidade_max;
	}

	public void setCapacidade_max(int capacidade_max) {
		this.capacidade_max = capacidade_max;
	}
	
	//METODOS 
	public abstract String mostrarDetalhes();
	
	public void receberVisitante(Visitante v) {
		if(v.getFichas() > 0) {
			v.setFichas(v.getFichas()-1);
			v.setAtracoes(this);
			this.ocupacao_atual++;
		}
	}
	
	public void deixarVisitante(Visitante v) {
		this.ocupacao_atual--;
	}
}
