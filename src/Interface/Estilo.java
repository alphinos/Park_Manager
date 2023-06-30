package src.Interface;

import java.awt.Color;
import java.awt.Font;

// Aqui, estão todas as informações de cores, fontes e detalhes relevantes para as estilização
// de cada tela.

public class Estilo {
    public final static Color vermelhao = new Color( 168, 6, 0, 255 );
    public final static Color vermelhinho = new Color( 255, 33, 25, 255 );
    public final static Color vermelho = new Color( 245, 8, 1, 255 );

    public final static Color verdao = new Color( 0, 168, 59, 255 );
    public final static Color verdinho = new Color( 0, 245, 85, 255 );

    public final static Color branco = new Color( 255, 255, 255, 255 );
    public final static Color quaseBranco = new Color( 243, 243, 243, 255 );

    public final static Color preto = new Color( 0, 0, 0, 255 );

    public final static Color preto_transparente = new Color( 0, 0, 0, 102 ); // 102 -> 40% de 255

    public final static Font robotoTitle = new Font( "roboto" , Font.BOLD, 36);
    public final static Font robotoButton = new Font( "roboto" , Font.BOLD, 24);
    public final static Font robotoLabel = new Font( "roboto" , Font.BOLD, 24);
    public final static Font robotoText = new Font( "roboto" , Font.PLAIN, 14);
}
