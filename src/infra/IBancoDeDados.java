package infra;
import java.util.ArrayList;

import business.model.Disciplina;
import business.model.Sala;
import business.model.Turma;

public interface IBancoDeDados {
	public ArrayList<Sala> pegarSalas();
	public Turma[] pegarTurmas();
	public boolean inserirDisciplina(int codigo, String id, String prof, int recurso, int qtd_aula);
	public boolean inserirTurma(int id, int qtd_alunos, String prof, int disciplina);
	public boolean inserirSala(int id, int qtd_lugar, int recurso);
	
}
