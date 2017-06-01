package business.model;

public class Turma {
	private int qtd_alunos;
	private Disciplina disciplina;
	private Sala sala;
	private String horario;
	
	public Turma(int qtd_alunos, Disciplina disciplina, Sala sala, String horario){
		this.qtd_alunos = qtd_alunos;
		this.disciplina = disciplina;
		this.sala = sala;
		this.horario = horario;
	}
	
}
