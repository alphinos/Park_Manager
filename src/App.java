package src;

import src.Interface.Cliente;
import src.Interface.Gerente;

public class App {

	public static void main(String args[]) {
		Atracao sorveteria = new Atracao("Sorveteria", "Bom Sabor", 001, 30, 0, 0);
		Visitante Max = new Visitante("Maxwell", 100);

		System.out.println("Canja");
		
		System.out.println("Você é demais!");
		
		sorveteria.receberVisitante(Max);
		Max.mostrarAtracoes();
		
		Max.comprarFichas(10);
		sorveteria.receberVisitante(Max);
		Max.mostrarAtracoes();

		Gerente gerente = new Gerente( 1280, 720 );
		Cliente cliente = new Cliente( 1280, 720 );
		gerente.setCliente( cliente );
	}
}
