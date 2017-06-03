package business.model;

public class Sala {
	private int id;
	private int qtd_lugares;
	private int recurso;

	public Sala(int id, int qtd_lugares, int recurso) {
		this.id = id;
		this.qtd_lugares = qtd_lugares;
		this.recurso = recurso;
	}
	
	public String toString(){
		return "Id: " + Integer.toString(id) + "\nQtd_lugares:  " + Integer.toString(qtd_lugares) + "\nRecurso: " + Integer.toString(recurso);
	}

}
