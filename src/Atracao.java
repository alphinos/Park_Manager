package src;
import  java.util.Random;

public class Atracao {
	private String nome;
	private String descricao;
	private int ID;
	private int capacidade_max;
	private int ocupacao_atual;
	private int idade_min;
	private float altura_min;
	
	public Atracao(String n, String d, int ID, int c_max, float a_min, int i_min) {
		this.nome = n;
		this.descricao = d;
		this.ID = ID;
		this.capacidade_max = c_max;
		this.altura_min = a_min;
		this.idade_min = i_min;
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

	public float getAltura_min() {
		return altura_min;
	}

	public void setAltura_min(int altura_min) {
		this.altura_min = altura_min;
	}

	public int getIdade_min() {
		return idade_min;
	}

	public void setIdade_min(int idade_min) {
		this.idade_min = idade_min;
	}
	
	//METODOS 
	public String mostrarDetalhes() {
		String resposta = "Nome: "+ this.nome+"\n"+
						  "Descrição: "+this.descricao+"\n"+
						  "ID: "+this.ID+"\n"+
						  "Capacidade Máx: "+this.capacidade_max+"\n"+
						  "Altura Mín: "+this.altura_min+"\n"+
						  "Idade Mín: "+this.idade_min+"\n"+
						  "Ocupação Atual: "+this.ocupacao_atual;
		
		return resposta;
	}
	
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
