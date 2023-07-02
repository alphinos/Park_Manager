package src;

public class Brinquedo extends Atracao {
    private int idade_min;
	private float altura_min;
    private float altura_max;
    private int entropia;

    public Brinquedo( String n, String d, int ID, int c_max ){
        super( n, d, ID, c_max );
    }

    public Brinquedo( String n, String d, int ID, int c_max, float a_min, int i_min ){
        super( n, d, ID, c_max );
        this.setAltura_min( a_min );
        this.setIdade_min( i_min );
    }

    public Brinquedo( String n, String d, int ID, int c_max, float a_min, float a_max, int i_min ){
        super( n, d, ID, c_max );
        this.setAltura_min( a_min );
        this.setIdade_min( i_min );
        this.setAltura_max( a_max );
    }

    public int getIdade_min() {
		return idade_min;
	}

	public void setIdade_min(int idade_min) {
		this.idade_min = idade_min;
	}

    public float getAltura_min() {
		return altura_min;
	}

	public void setAltura_min(float altura_min) {
        if ( altura_min > 0 ){
            this.altura_min = altura_min;
        } else {
            System.out.println( "Valor inválido" );
        }
	}

    public float getAltura_max(){
        return this.altura_max;
    }

    public void setAltura_max( float altura_max ){
        if ( altura_max > 0 ){
            this.altura_max = altura_max;
        } else {
            System.out.println( "Valor inválido" );
        }
    }

    public int getEntropia(){
        return this.entropia;
    }

    public void setEntropia( int entropia ){
        if ( entropia < 1 || entropia > 3 ){
            System.out.println( "Valores de entropia inválidos!" );
            return;
        }
        this.entropia = entropia;
    }

    // MÉTODOS

    @Override
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
}
