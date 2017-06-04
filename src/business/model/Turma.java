package business.model;

public class Turma {
	private int id;
	private int qtd_alunos;
	private Disciplina disciplina;
	private Sala sala;
	private String prof;
	private String horario;

	public Turma(int id, int qtd_alunos, Disciplina disciplina, String prof) {
		this.id = id;
		this.qtd_alunos = qtd_alunos;
		this.disciplina = disciplina;
		this.prof = prof;
		sala = null;
		horario = null;
	}
	
	public String toString(){
		return "Id: " + Integer.toString(id) + "\nQtd_alunos: " + Integer.toString(qtd_alunos) + "\nDisciplina: " + disciplina.getId() + 
				"\nProfessor: " + prof + "\n";
	}

}
