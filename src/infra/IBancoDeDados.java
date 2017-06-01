package infra;
import business.model.Disciplina;
import business.model.Sala;
import business.model.Turma;

public interface IBancoDeDados {
	public Sala[] pegaSalas();
	public Disciplina[] pegaDisciplinas();
	public Turma[] pegaTurmas();
	
}
