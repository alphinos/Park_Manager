package src;

import src.Interface.Gerente;

public class App {
	public static void main(String args[]) {
		Atracao sorveteria = new Atracao("Sorveteria", "Bom Sabor", 001, 30, 0, 0);
		Visitante Max = new Visitante("Maxwell", 100);
		System.out.println("Canja");
		
		sorveteria.receberVisitante(Max);
		Max.mostrarAtracoes();
		
		Max.comprarFichas(10);
		sorveteria.receberVisitante(Max);
		Max.mostrarAtracoes();

		Gerente gerente = new Gerente( 1280, 720 );
	}
}
