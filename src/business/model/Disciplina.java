package business.model;

public class Disciplina {
	private String id;
	private String professor;
	private int qtd_aulas;
	private int recurso;
	
	public Disciplina(String id, String professor, int qtd_aulas, int recurso){
		this.id = id;
		this.professor = professor;
		this.qtd_aulas = qtd_aulas;
		this.recurso = recurso;	
	}
}