package src.Files;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Scanner;

import src.Parque;
import src.Restaurante;

public class FRestaurante {

    public static boolean escrever( Restaurante r ){
        File arquivo = new File( r.getPath() );
        
        if( arquivo.exists() ){
            if(arquivo.canWrite()){
                PrintWriter output = new PrintWriter(arquivo);
                String saida = "" +
                    r.getNome() + ";"+
                    r.getDescricao() + ";" +
                    r.getID() + ";" +
                    r.getCapacidade_max()+ ";" + 
                    r.getOcupacaoAtual() + ";" +
                    r.getTimeString(r.getAbertura()) + ";" +
                    r.getTimeString(r.getFechamento()) + ";" +
                    r.getPreco() + ";" +
                    r.getCardapioString() + ";";
                output.print(saida);
                output.close();
                return true;
            }
        } else {
            try {
                if( arquivo.createNewFile() ){
                    if(arquivo.canWrite()){
                        PrintWriter output = new PrintWriter(arquivo);
                        String saida = "" +
                            r.getNome() + ";"+
                            r.getDescricao() + ";" +
                            r.getID() + ";" +
                            r.getCapacidade_max()+ ";" + 
                            r.getOcupacaoAtual() + ";" +
                            r.getTimeString(r.getAbertura()) + ";" +
                            r.getTimeString(r.getFechamento()) + ";" +
                            r.getPreco() + ";" +
                            r.getCardapioString() + ";";
                        output.print(saida);
                        output.close();
                        return true;
                    }
                }
            } catch ( IOException ex ) {
                System.out.println( ex.toString() );
            }
        }
        return false;      
    } 

    public static Restaurante ler(Parque p){

        File arquivo = new File("././Parques/" + p.getNome() + "/restaurante.restaurante");

        Scanner input = new Scanner(arquivo).useDelimiter("\\ ");
        
        String nome = input.next();
        String descricao = input.next();
        int ID = input.nextInt();
        int capacidade_max = input.nextInt();
        int ocupacao_atual = input.nextInt();
        LocalTime abertura = LocalTime.parse(input.next());
        LocalTime fechamento = LocalTime.parse(input.next());
        int preco = input.nextInt();
        HashMap < String, Integer > cardapio = new HashMap < String, Integer >();
        while(input.hasNext()){
            String chave = input.next();
            int valor = input.nextInt();
            cardapio.put(chave, valor);
        }
    
        Restaurante r = new Restaurante();
        r.setNome(nome);
        r.setDescricao(descricao);
        r.setID(ID);
        r.setCapacidade_max(capacidade_max);
        r.setOcupacaoAtual(ocupacao_atual);
        r.setAbertura(abertura);
        r.setFechamento(fechamento);
        r.setPreco(preco);
        r.setCardapio(cardapio);

        return r;
    }
    
}
