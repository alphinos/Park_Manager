package src.Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import src.Atracao;
import src.Brinquedo;
import src.Parque;
import src.Restaurante;

import java.util.ArrayList;
import java.util.Scanner;

public class FPark {

    public static Parque ler( String parque_path ){
        File arq_parque = new File( parque_path );

        String nome;
        String descricao;
        float precoFicha;
        int capacidade;
        int qtdVisitantes;

        ArrayList< String > path_atracoes = new ArrayList< String >();
        ArrayList< Atracao > atracoes = new ArrayList< Atracao >();

        if ( arq_parque.exists() ){
            try{
                if ( arq_parque.canRead() ){
                    Scanner input = new Scanner( arq_parque ).useDelimiter( "\\;" );
                    nome = input.next();
                    descricao = input.next();
                    precoFicha = input.nextFloat();
                    capacidade = input.nextInt();
                    qtdVisitantes = input.nextInt();
                    while ( input.hasNext() ){
                        path_atracoes.add( input.next() );
                    }
                    input.close();

                    Parque parque = new Parque();
                    parque.setNome( nome );
                    parque.setDescricao( descricao );
                    parque.setPrecoFicha( precoFicha );
                    parque.setCapacidade( capacidade );
                    parque.setQtdVisitantes( qtdVisitantes );

                    for ( String path : path_atracoes ){
                        if ( path.contains( ".brinquedo") ){
                            atracoes.add( FBrinquedo.ler( path ) );
                        }

                        if ( path.contains( ".restaurante") ){
                            atracoes.add( FRestaurante.ler( path ) );
                        }
                    }
                    parque.setAtracoes( atracoes );
                    return parque;
                }
            } catch ( FileNotFoundException ex ){
                System.out.println( ex.toString() );
            }
        }
        return null;
    }

    public static boolean escrever( Parque parque ){
        File arq_parque = new File( "././Parques/" + parque.getNome() + ".park" );
        File dir_parque = new File( "././Parques/" +parque.getNome() );

        String nome = parque.getNome() ;
        String descricao = parque.getDescricao() ;
        float precoFicha = parque.getPrecoFicha() ;
        int capacidade = parque.getCapacidade() ;
        int qtdVisitantes = parque.getQtdVisitantes() ;

        ArrayList< String > atracoes = new ArrayList< String >();

        for ( Atracao a : parque.getAtracoes() ){
            if ( a.getPath() != null ){
                atracoes.add( a.getPath() );
            } else {
                String ext = "";
                if ( a instanceof Brinquedo ){
                    ext = ".brinquedo";
                }

                if ( a instanceof Restaurante ){
                    ext = ".restaurante";
                }

                a.setPath( "././Parques/" +parque.getNome() + "/" + a.getNome() + ext );
            }
        }

        if ( arq_parque.exists() ){
            try{
                if ( arq_parque.canWrite() ){
                    PrintWriter output = new PrintWriter( arq_parque );

                    output.print( nome + ";" );
                    output.print( descricao + ";" );
                    output.print( precoFicha + ";" );
                    output.print( capacidade + ";" );
                    output.print( qtdVisitantes + ";" );

                    for ( String pathA : atracoes ){
                        output.print( pathA + ";" );
                    }
                    output.close();
                }
            } catch ( FileNotFoundException ex ){
                System.out.println( ex.toString() );
                return false;
            }
        } else {
            try{
                if ( arq_parque.createNewFile() ){

                    if ( arq_parque.canWrite() ){
                        PrintWriter output = new PrintWriter( arq_parque );

                        output.print( nome + ";" );
                        output.print( descricao + ";" );
                        output.print( precoFicha + ";" );
                        output.print( capacidade + ";" );
                        output.print( qtdVisitantes + ";" );

                        for ( String pathA : atracoes ){
                            output.print( pathA + ";" );
                        }
                        output.close();
                    }    
                }
            } catch ( IOException ex ){
                System.out.println( ex.toString() );
                return false;
            }
        }

        if ( dir_parque.exists() ){
            System.out.println("O diretório já existe!");

            for ( Atracao a : parque.getAtracoes() ){
                if ( a instanceof Brinquedo ){
                    FBrinquedo.escrever( ( Brinquedo) a );
                }

                if ( a instanceof Restaurante ){
                    FRestaurante.escrever( ( Brinquedo) a );
                }
            }

            return true;
        } else {
            try{
                if( dir_parque.mkdir() ){
                    System.out.println( "Diretório criado!" );
                    for ( Atracao a : parque.getAtracoes() ){
                        if ( a instanceof Brinquedo ){
                            FBrinquedo.escrever( a );
                        }

                        if ( a instanceof Restaurante ){
                            FRestaurante.escrever( a );
                        }
                    }
                    return true;
                }
            } catch ( Exception ex ){
                System.out.println( ex.toString() );
                return false;
            }
        }

        return false;
    }
}
