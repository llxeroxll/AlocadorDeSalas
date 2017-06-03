package business.model;

public class Disciplina {
	private int codigo;
	private String id;
	private int qtd_aulas;
	private int recurso;

	public Disciplina(int codigo, String id, int qtd_aulas, int recurso) {
		this.codigo = codigo;
		this.id = id;
		this.qtd_aulas = qtd_aulas;
		this.recurso = recurso;
	}
	
	public String toString(){
		return "Codigo: " + Integer.toString(codigo) + "\nId: " + id + "\nQtd_aulas: " 
						  + Integer.toString(qtd_aulas) + "\nRecurso: " + Integer.toString(recurso) ;
	}

}
