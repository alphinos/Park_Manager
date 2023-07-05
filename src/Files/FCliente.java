package src.Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import src.Visitante;

import java.util.Scanner;

public class FCliente {

    public static Visitante ler( String parque_path ){
        File arq_cliente = new File( parque_path );
        Visitante cliente = new Visitante();

        String nome;
        float dinheiro;
        int idade;
        float altura;

        if ( arq_cliente.exists() ){
            try{
                if ( arq_cliente.canRead() ){
                    try (Scanner input = new Scanner( arq_cliente ).useDelimiter( "\\;" )) {
                        nome = input.next();
                        dinheiro = input.nextFloat();
                        idade = input.nextInt();
                        altura = input.nextFloat();
                        cliente.setNome( nome );
                        cliente.setDinheiro( dinheiro );
                        cliente.setIdade( idade );
                        cliente.setAltura( altura );
                    }
                    return cliente;
                }
            } catch ( FileNotFoundException ex ){
                System.out.println( ex.toString() );
            }
        }
        return null;
    }

    public static boolean escrever( Visitante cliente ){
        File arq_cliente = new File( "././Clientes/" + cliente.getNome() + ".cliente" );

        String nome = cliente.getNome();
        float dinheiro = cliente.getDinheiro();
        int idade = cliente.getIdade();
        float altura = cliente.getAltura();

        if ( arq_cliente.exists() ){
            try{
                if ( arq_cliente.canWrite() ){
                    PrintWriter output = new PrintWriter( arq_cliente );

                    output.print( nome + ";" );
                    output.print( dinheiro + ";" );
                    output.print( idade + ";" );
                    output.print( altura + ";" );

                    output.close();
                    return true;
                }
            } catch ( FileNotFoundException ex ){
                System.out.println( ex.toString() );
                return false;
            }
        } else {
            try{
                if ( arq_cliente.createNewFile() ){

                    if ( arq_cliente.canWrite() ){
                        PrintWriter output = new PrintWriter( arq_cliente );

                        output.print( nome + ";" );
                        output.print( dinheiro + ";" );
                        output.print( idade + ";" );
                        output.print( altura + ";" );

                        output.close();
                        return true;
                    }
                }
            } catch ( IOException ex ){
                System.out.println( ex.toString() );
                return false;
            }
        }

        return false;
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
