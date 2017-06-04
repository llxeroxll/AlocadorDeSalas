package business.model;

import java.util.ArrayList;

public class Turma {
	private int qtd_alunos;
	private Disciplina disciplina;
	private Sala sala;
	private String horario;

	public Turma(int qtd_alunos, Disciplina disciplina, Sala sala, String horario) {
		this.qtd_alunos = qtd_alunos;
		this.disciplina = disciplina;
		this.sala = sala;
		this.horario = horario;
	}

	public int getQtd_alunos() {
		return qtd_alunos;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public Sala getSala() {
		return sala;
	}

	public ArrayList<String> getHorario() {
		ArrayList<String> retorno = new ArrayList<String>();
		
		
		
		return retorno;
	}

}
