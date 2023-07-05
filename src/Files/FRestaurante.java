package src.Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import src.Restaurante;

public class FRestaurante {

    public static boolean escrever( Restaurante r ){
        File arquivo = new File( r.getPath() );

        if( arquivo.exists() ){
            try{
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
            } catch ( FileNotFoundException ex ){
                System.out.println( ex.toString() );
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

    public static Restaurante ler( String path ){

        File arquivo = new File( path );
        Restaurante r = new Restaurante();

        if ( arquivo.exists() ){
            try {
                if ( arquivo.canRead() ){
                    try (Scanner input = new Scanner(arquivo).useDelimiter("\\;")) {
                        String nome = input.next();
                        String descricao = input.next();
                        int ID = input.nextInt();
                        int capacidade_max = input.nextInt();
                        int ocupacao_atual = input.nextInt();
                        LocalTime abertura = LocalTime.parse(input.next());
                        LocalTime fechamento = LocalTime.parse(input.next());
                        int preco = input.nextInt();
                        
                        HashMap < String, Integer > cardapio = new HashMap < String, Integer >();

                        String chave;
                        int valor;
                        
                        ArrayList<String> card = new ArrayList< String >();

                        while( input.hasNext() ){
                            card.add( input.next() );
                        }
                        
                        if ( card.size() >= 2 && ( card.size() - 1 ) % 2 == 0 ){
                            for ( int i = 0; i < card.size(); i += 2 ){
                                chave = card.get(i);
                                valor = Integer.parseInt( card.get( i + 1) );
                                cardapio.put(chave, valor);
                            }
                        }

                        input.close();
            
                        r.setNome(nome);
                        r.setDescricao(descricao);
                        r.setID(ID);
                        r.setCapacidade_max(capacidade_max);
                        r.setOcupacaoAtual(ocupacao_atual);
                        r.setAbertura(abertura);
                        r.setFechamento(fechamento);
                        r.setPreco(preco);
                        r.setCardapio(cardapio);
                    }
        
                    r.setPath( path );

                    return r;
                }
            } catch ( FileNotFoundException ex ){
                System.out.println( ex.toString() );
            }
        }
        return null;
    }

    public static boolean remove( String path ){
        File r = new File( path );

        if ( r.exists() ){
            if ( r.delete() ){
                return true;
            }
        }
        return false;
    }
    
}
