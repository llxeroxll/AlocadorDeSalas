/**
 * 
 */
package heuristica;

import business.model.Turma;

/**
 * @author José
 *
 */
public class SalaResposta {
	private Turma[][] horario;
	
	public void setTurma(int dia, int hora, Turma turma){
		this.horario[dia][hora] = turma;
	}
	
	public Turma getTurma(int dia, int hora){
		return horario[dia][hora];
	}
}
