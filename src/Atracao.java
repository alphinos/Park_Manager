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
	protected LocalTime abertura;
	protected LocalTime fechamento;
	protected int preco; // Quantidade de fichas para poder entrar na atração

	private String path;

	public Atracao(){}

	public Atracao( String n, String d, int ID, int c_max ) {
		this.nome = n;
		this.descricao = d;
		this.ID = ID;
		this.capacidade_max = c_max;
		Random generator = new Random(); 
		this.ocupacao_atual = generator.nextInt(this.capacidade_max+1);
	}

	public Atracao( String n, String d, int ID, int c_max, int a_hour, int a_min, int f_hour, int f_min ) {
		this.nome = n;
		this.descricao = d;
		this.ID = ID;
		this.capacidade_max = c_max;
		Random generator = new Random(); 
		this.ocupacao_atual = generator.nextInt(this.capacidade_max+1);
		this.setAbertura( a_hour, a_min );
		this.setAbertura( f_hour, f_min );
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
	
	public int getOcupacaoAtual(){
		return this.ocupacao_atual;
	}

	public void setOcupacaoAtual( int ocupacao_atual ){
		this.ocupacao_atual = ocupacao_atual;
	}

	public int getPreco(){
		return this.preco;
	}

	public void setPreco( int preco ){
		if ( preco < 0 ){
			System.out.println( "O cliente não vai receber pra brincar, né?" );
			return;
		}
		this.preco = preco;
	}

	public LocalTime getAbertura(){
		return this.abertura;
	}

	public void setAbertura( LocalTime abertura ){
		this.abertura = abertura;
	}

	public void setAbertura( int hour, int minutes ){
		if ( hour < 0 || minutes < 0 ){
			System.out.println( "Horário inválido!" );
		}
		this.abertura = LocalTime.of(hour, minutes);
	}

	public LocalTime getFechamento(){
		return this.fechamento;
	}

	public void setFechamento( LocalTime fechamento ){
		this.fechamento = fechamento;
	}

	public void setFechamento( int hour, int minutes ){
		if ( hour < 0 || minutes < 0 ){
			System.out.println( "Horário inválido!" );
		}
		this.fechamento = LocalTime.of( hour, minutes );
	}

	public String getTimeString( LocalTime time ){
		if ( time == null ){
			return "00:00";
		}
		DateTimeFormatter format = DateTimeFormatter.ofPattern( "HH:mm" );
		return time.format( format );
	}

	public String getPath(){
        return this.path;
    }

    public void setPath( String path ){
        this.path = path;
    }

	//METODOS 
	public abstract String mostrarDetalhes();
	
	public abstract String receberVisitante(Visitante v);
	
	public void deixarVisitante(Visitante v) {
		this.ocupacao_atual--;
	}

	public boolean estaNoHorarioDeFuncionamento(){
		LocalTime now = LocalTime.now();
		if ( now.compareTo( this.abertura ) > 0 && now.compareTo( this.fechamento ) < 0 ){
			return true;
		}
		return false;
	}
}
