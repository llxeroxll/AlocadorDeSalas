package infra;

public class Main {

	public static void main(String[] args) {
		SQLiteJDBC bd = new SQLiteJDBC();
		bd.inserirDisciplina(1, "CalcI", "Bosco Nogueira", 3, 50);

	}

}
