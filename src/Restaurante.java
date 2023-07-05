package src;

import java.util.HashMap;

public class Restaurante extends Atracao {

    private HashMap < String, Integer > cardapio;

    // Regras de entropia:
    // Um visitante não pode ir a um restaurante se acabou de ir a um brinquedo de entropia 3
    
    public Restaurante(){
        super();
    }

    public Restaurante( String n, String d, int ID, int c_max ){
        super( n, d, ID, c_max );
        this.cardapio = new HashMap < String, Integer >();
    }

    public Restaurante( String n, String d, int ID, int c_max, int a_hour, int a_min, int f_hour, int f_min ){
        super( n, d, ID, c_max, a_hour, a_min, f_hour, f_min );
        this.cardapio = new HashMap < String, Integer >();
    }

    public HashMap < String, Integer > getCardapio(){
        return this.cardapio;
    }

    public void setCardapio( HashMap < String, Integer > cardapio ){
        this.cardapio = cardapio;
    }

    public void addComida( String prato, int preco ){
        cardapio.put( prato, preco );
    }

    public String getCardapioString(){
        String pratos = "";

        for ( String prato : this.cardapio.keySet() ){
            pratos += prato + ";" + this.cardapio.get( prato ) + ";";
        }

        return pratos;
    }

    //METODOS 
    @Override
	public String mostrarDetalhes(){

        String resposta = "Nome:"+ this.nome+"\n"+
						  "Descrição:"+this.descricao+"\n"+
						  "ID:"+this.ID+"\n"+
						  "Capacidade Máx:"+this.capacidade_max+"\n"+
						  this.getCardapioString() +
						  "Ocupação Atual:"+this.ocupacao_atual;
		return resposta;
    }
	
    @Override
	public String receberVisitante(Visitante v){

        if ( !this.estaNoHorarioDeFuncionamento() ){
            return "O brinquedo está fora do seu horário de funcionamento!";
        }

        Brinquedo brinquedo;

        if ( v.getUltimAtracao() instanceof Brinquedo ){
            brinquedo = (Brinquedo) v.getUltimAtracao();
            if ( brinquedo.getEntropia() == 3 ){
                return "Você acabou de ir a um restaurante!" + "\n"
                    + "Vá a um brinquedo mais leve!" + "\n";
            }
        }
        return "Acesso garantido!" + "\n"
                        + "Deleite-se!" + "\n";
    }

    public boolean venderPrato( Visitante v, String prato ){
        if ( this.cardapio.containsKey( prato ) ){
            if ( v.getFichas() >= this.cardapio.get( prato ) ){
                v.setFichas( v.getFichas() - this.cardapio.get( prato ) );
                return true;
            }
        }
        return false;
    }
}
