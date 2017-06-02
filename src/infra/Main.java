package infra;

public class Main {

	public static void main(String[] args) {
		SQLiteJDBC bd = new SQLiteJDBC();
		bd.inserirDisciplina(1, "CalcI", "Bosco Nogueira", 3, 50);
		bd.inserirSala(103, 20, 3);
		bd.inserirTurma(1, 30, 1);
		bd.inserirTurma(2, 30, 2);
	}

}
