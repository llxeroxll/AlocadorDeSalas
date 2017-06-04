/**
 * 
 */
package heuristica;

import java.util.ArrayList;

import business.model.Sala;
import business.model.Turma;

/**
 * @author José
 *
 */
public class AlocadorSimplex implements IHeuristica {
	int quantidadeSalas;
	int quantidadeTurmas;
	int[] recursosSala;
	int[] recursosTurma;
	int[] quantidadeLugaresSala;
	int[] quantidadeLugaresTurma;
	int[][] horarioDasTurmas;

	@Override
	public void carregaDados(ArrayList<Turma> turmas, ArrayList<Sala> salas) {
		this.quantidadeSalas = salas.size();
		this.quantidadeTurmas = turmas.size();

		recursosSala = new int[quantidadeTurmas];
		quantidadeLugaresSala = new int[quantidadeTurmas];

		recursosTurma = new int[quantidadeTurmas];
		quantidadeLugaresTurma = new int[quantidadeTurmas];

		for (int i = 0; i < quantidadeSalas; i++) {
			recursosSala[i] = salas.get(i).getRecurso();
			quantidadeLugaresSala[i] = salas.get(i).getQtd_lugares();
		}
		
		for (int i = 0; i < quantidadeTurmas; i++) {
			recursosTurma[i] = turmas.get(i).getDisciplina().getRecurso();
			quantidadeLugaresSala[i] = turmas.get(i).getQtd_alunos();
		}

	}

	@Override
	public ArrayList<SalaResposta> executarHeuristica() {
		// TODO Auto-generated method stub
		return null;
	}

}
