package business.model;

public class Sala {
	private int qtd_lugares;
	private int recurso;

	public Sala(int qtd_lugares, int recurso) {
		this.qtd_lugares = qtd_lugares;
		this.recurso = recurso;
	}

	public int getQtd_lugares() {
		return qtd_lugares;
	}

	public int getRecurso() {
		return recurso;
	}

}
