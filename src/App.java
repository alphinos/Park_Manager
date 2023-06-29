package src;

import src.Interface.Janela;
import src.Interface.Tela;
import src.Telas.Inicio;

public class App {
	public static void main(String args[]) {
		Atracao sorveteria = new Atracao("Sorveteria", "Bom Sabor", 001, 30, 0, 0);
		Visitante Max = new Visitante("Maxwell", 100);
		
		
		sorveteria.receberVisitante(Max);
		Max.mostrarAtracoes();
		
		Max.comprarFichas(10);
		sorveteria.receberVisitante(Max);
		Max.mostrarAtracoes();

		Janela janela = new Janela( new Inicio() );
	}
}
