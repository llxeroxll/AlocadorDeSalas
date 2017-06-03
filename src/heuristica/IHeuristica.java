/**
 * 
 */
package heuristica;

import java.util.ArrayList;

import business.model.Sala;
import business.model.Turma;

/**
 * @author José Alves Monteiro Neto
 *
 */
public interface IHeuristica {
	public void carregaDados(ArrayList<Turma> turmas, ArrayList<Sala> salas);
	public ArrayList<SalaResposta> executarHeuristica();
}
