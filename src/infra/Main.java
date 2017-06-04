package infra;

import java.util.ArrayList;

import business.model.Disciplina;
import business.model.Sala;
import business.model.Turma;

public class Main {

	public static void main(String[] args) {
		SQLiteJDBC bd = new SQLiteJDBC("test");
		ArrayList<Disciplina> disciplinas = bd.pegarDisciplinas();
		
		/*
		ArrayList<Sala> salas = bd.pegarSalas();
		for(Sala sala: salas){
			System.out.println(sala);
		}
		
		
		
		for(Disciplina disciplina: disciplinas){
			System.out.println(disciplina);
		}
		*/
		
		ArrayList<Turma> turmas = bd.pegarTurmas(disciplinas);
		for(Turma turma: turmas){
			System.out.println(turma);
		}
	}
	

}
