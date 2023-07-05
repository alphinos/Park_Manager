package src;

import src.Interface.JCliente;
import src.Interface.JGerente;

public class App {

	public static void main(String args[]) {
		JGerente gerente = new JGerente( 1280, 720 );
		JCliente cliente = new JCliente( 1280, 720 );
		gerente.setCliente( cliente );
	}
}
