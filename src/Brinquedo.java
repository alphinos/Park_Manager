package src;

public class Brinquedo extends Atracao {
    private int idade_min;
	private float altura_min;
    private float altura_max;
    private int entropia;

    // Regras de entropia:
    // Para que um visitante vá a um brinquedo de entropia 3,
    // Deve ter ido em um de entropia 2 ou 2 de entropia 1
    // Um visitante não pode ir a um brinquedo de entropia 3 se tiver acabdo de ir a um restaurante
    // Para que um visitante vá a um brinquedo de entropia 2,
    // Deve ter ido em ao menos um de entropia 1

    public Brinquedo(){
        super();
    }

    public Brinquedo( String n, String d, int ID, int c_max, float al_min, float al_max, int i_min, int ent ){
        super( n, d, ID, c_max );
        this.setAltura_min( al_min );
        this.setAltura_max( al_max );
        this.setIdade_min( i_min );
        this.setEntropia( ent );
    }

    public Brinquedo( String n, String d, int ID, int c_max, int a_hour, int a_min, int f_hour, int f_min, int ent ){
        super( n, d, ID, c_max, a_hour, a_min, f_hour, f_min );
        this.setEntropia( ent );
    }

    public Brinquedo( String n, String d, int ID, int c_max, int a_hour, int a_min, int f_hour, int f_min, float al_min, int i_min, int ent ){
        super( n, d, ID, c_max, a_hour, a_min, f_hour, f_min );
        this.setAltura_min( al_min );
        this.setIdade_min( i_min );
        this.setEntropia( ent );
    }

    public Brinquedo( String n, String d, int ID, int c_max, int a_hour, int a_min, int f_hour, int f_min, float al_min, float al_max, int i_min, int ent ){
        super( n, d, ID, c_max, a_hour, a_min, f_hour, f_min );
        this.setAltura_min( al_min );
        this.setIdade_min( i_min );
        this.setEntropia( ent );
        this.setAltura_max( al_max );
    }

    public int getIdade_min() {
		return idade_min;
	}

	public void setIdade_min(int idade_min) {
        if ( idade_min > 0)
    		this.idade_min = idade_min;
	}

    public float getAltura_min() {
		return altura_min;
	}

	public void setAltura_min(float altura_min) {
        if ( altura_min >= 0 ){
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
		String resposta = "Nome: " + this.nome + "\n" +
						  "Descrição: " + this.descricao + "\n" +
						  "ID: " + this.ID + "\n" +
						  "Capacidade Máx: " + this.capacidade_max+"\n" +
						  "Altura Mín: " + this.altura_min+"\n" +
						  "Idade Mín: " + this.idade_min + "\n" +
						  "Ocupação Atual: " + this.ocupacao_atual + "\n" +
                          "Preço: " + this.preco;
		return resposta;
	}

    @Override
    public String receberVisitante(Visitante v){

        if ( !this.estaNoHorarioDeFuncionamento() ){
            return "O brinquedo está fora do seu horário de funcionamento!";
        }

        if ( v.getIdade() < this.idade_min ){
            return "Você não possui a idade mínima para entrar no brinquedo!" + "\n";
        }

        if ( v.getAltura() < this.altura_min ){
            return "Você é muito pequeno para entrar nesse brinquedo!" + "\n";
        }

        if ( v.getAltura() > this.altura_max ){
            return "Você é muito grande para entrar nesse brinquedo!" + "\n";
        }

        if ( v.getFichas() < this.preco ){
            return "Você não tem fichas o suficiente para entrar nesse brinquedo!" + "\n";
        }

        boolean foiEntropia2 = false;
        boolean foi2Entropia1 = false;
        boolean foi1Entropia1 = false;;
        int vezesEntropia1 = 0;
        Brinquedo brinquedo;

        if ( v.getAtracoes() != null ){
            for ( Atracao atrac : v.getAtracoes() ){
                if ( atrac instanceof Brinquedo ){
                    brinquedo = ( Brinquedo )atrac;

                    switch ( brinquedo.getEntropia() ){
                        case 1:
                            vezesEntropia1++;
                            foi1Entropia1 = true;
                            break;
                        case 2:
                            foiEntropia2 = true;
                            break;
                    }
                }
            }
        }
        
        if ( vezesEntropia1 >= 2 ){
            foi2Entropia1 = true;
        } //Pequena redundância, mas facilita a compreensão

        if ( v.getAtracoes() != null && this.entropia == 3 ){
            if ( v.getUltimAtracao() instanceof Restaurante ){
                return "Você acabou de ir a um restaurante!" + "\n"
                    + "Vá a um brinquedo mais leve!" + "\n";
            }

            if ( foiEntropia2 || foi2Entropia1 ){
                v.entregarFichas( this.preco );
                v.addAtracao( this );
                return "Acesso garantido!" + "\n"
                    + "Divirta-se!" + "\n";
            } else {
                return "Talvez você não esteja preparada para este brinquedo ainda!" + "\n"
                    + "Vá a um mais leve antes!" + "\n";
            }
        }

        if ( this.entropia == 2 ){
            if ( foi1Entropia1 ){
                v.entregarFichas( this.preco );
                v.addAtracao( this );
                return "Acesso garantido!" + "\n"
                        + "Divirta-se!" + "\n";
            } else {
                return "Talvez você não esteja preparada para este brinquedo ainda!" + "\n"
                        + "Vá a um mais leve antes!" + "\n";
            }
        }

        if ( this.entropia == 1 ){
            v.entregarFichas( this.preco );
            v.addAtracao( this );
            return "Acesso garantido!" + "\n"
                + "Divirta-se!" + "\n";
        } else {
            return "Algo de errado aconteceu!" + "\n";
        }

    }
}
