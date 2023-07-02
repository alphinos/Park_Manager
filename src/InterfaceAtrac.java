package src;

public interface InterfaceAtrac {
    public String mostrarDetalhes();
	
	public String receberVisitante(Visitante v);
	
	public void deixarVisitante(Visitante v);

	public boolean estaNoHorarioDeFuncionamento();
}
