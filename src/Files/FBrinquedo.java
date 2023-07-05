package src.Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.Scanner;

import src.Brinquedo;

public class FBrinquedo {

    public static boolean escrever( Brinquedo b ){
        File arquivo = new File( b.getPath() );
        
        if( arquivo.exists() ){
            try{
                if(arquivo.canWrite()){
                    PrintWriter output = new PrintWriter(arquivo);
                    String saida = "" +
                        b.getNome() + ";"+
                        b.getDescricao() + ";" +
                        b.getID() + ";" +
                        b.getCapacidade_max()+ ";" + 
                        b.getOcupacaoAtual() + ";" +
                        b.getTimeString(b.getAbertura()) + ";" +
                        b.getTimeString(b.getFechamento()) + ";" +
                        b.getPreco() + ";" +
                        b.getIdade_min() + ";" +
                        b.getAltura_min() + ";" +
                        b.getAltura_max() + ";" +
                        b.getEntropia() + ";";
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
                            b.getNome() + ";"+
                            b.getDescricao() + ";" +
                            b.getID() + ";" +
                            b.getCapacidade_max()+ ";" + 
                            b.getOcupacaoAtual() + ";" +
                            b.getTimeString(b.getAbertura()) + ";" +
                            b.getTimeString(b.getFechamento()) + ";" +
                            b.getPreco() + ";" +
                            b.getIdade_min() + ";" +
                            b.getAltura_min() + ";" +
                            b.getAltura_max() + ";" +
                            b.getEntropia() + ";";
                        output.print(saida);
                        output.close();
                    }
                }
            } catch ( IOException ex ) {
                System.out.println( ex.toString() );
            }
        }
        return false;      
    } 

    public static Brinquedo ler( String path){

        File arquivo = new File( path );
        Brinquedo b = new Brinquedo();
        
        // Scanner input;

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
                        int idade_min = input.nextInt();
                        float altura_min = input.nextFloat();
                        float altura_max = input.nextFloat();
                        int entropia = input.nextInt();

                        input.close();
            

                        b.setNome(nome);
                        b.setDescricao(descricao);
                        b.setID(ID);
                        b.setCapacidade_max(capacidade_max);
                        b.setOcupacaoAtual(ocupacao_atual);
                        b.setAbertura(abertura);
                        b.setFechamento(fechamento);
                        b.setPreco(preco);
                        b.setIdade_min(idade_min);
                        b.setAltura_min(altura_min);
                        b.setAltura_max(altura_max);
                        b.setEntropia(entropia);
                    }
        
                    b.setPath( path );

                    return b;
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
