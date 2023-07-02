package src.Files;
import java.io.File;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Scanner;

import src.Parque;
import src.Restaurante;


public class FBrinquedo {

    public static boolean escreve_restaurante( Restaurante r, Parque p ){
        File arquivo = new File("././Parques/" + p.getNome() + "/restaurante.restaurante");
        if(!arquivo.exists()){
            if(arquivo.createNewFile()){
                if(arquivo.canWrite()){
                    PrintWrite output = new PrintWrite(arquivo);
                    String saida = 
                           r.getNome()+" "+
						  +r.getDescricao()+" "+
						  +r.getID()+" "+
						  +r.getCapacidade_max()+" "+ 
                          +r.getCardapioString()+" "+
						  +r.getOcupacaoAtual()"\n"
                    output.print(saida);
                    return true;
                }
            }
        
        return false;      
}
    } 

    public static Restaurante le_restaurante(Parque p){

        File arquivo = new File("././Parques/" + p.getNome() + "/restaurante.restaurante");
        Scanner input = new Scanner(arquivo).useDelimiter("\\ | \\:");
        while(input.hasNext()){
            String nome;
	        String descricao;
	        int ID;
	        int capacidade_max;
	        int ocupacao_atual;
	        LocalTime abertura;
	        LocalTime fechamento;
	        int preco;
            HashMap < String, Integer > cardapio; 


            
        }


    }

    
    
}
