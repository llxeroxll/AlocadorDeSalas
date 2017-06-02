package infra;
import business.model.Disciplina;
import business.model.Sala;
import business.model.Turma;

public interface IBancoDeDados {
	public Sala[] pegaSalas();
	public Disciplina[] pegaDisciplinas();
	public Turma[] pegaTurmas();
	public boolean inserirDisciplina(int codigo, String id, String prof, int recurso, int qtd_aula);
	
}
