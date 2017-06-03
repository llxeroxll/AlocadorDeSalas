package infra;

import java.util.ArrayList;

import business.model.Disciplina;
import business.model.Sala;

public class Main {

	public static void main(String[] args) {
		SQLiteJDBC bd = new SQLiteJDBC("test");
		
		bd.inserirDisciplina(1, "Calc I", 0, 50);
		bd.inserirDisciplina(2, "Calc II", 0, 40);
		bd.inserirDisciplina(3, "Calc III", 0, 30);
		bd.inserirDisciplina(4, "IP", 1, 30);
		bd.inserirDisciplina(5, "CG", 1, 30);
		bd.inserirDisciplina(6, "LP II", 1, 30);
		
		ArrayList<Sala> salas = bd.pegarSalas();
		for(Sala sala: salas){
			System.out.println(sala);
		}
		
		ArrayList<Disciplina> disciplinas = bd.pegarDisciplinas();
		for(Disciplina disciplina: disciplinas){
			System.out.println(disciplina);
		}
	}

}
