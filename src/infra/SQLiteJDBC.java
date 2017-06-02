package infra;
import java.sql.*;

import org.sqlite.SQLiteException;

public class SQLiteJDBC {
	private static int unique_id;
	
	public SQLiteJDBC(){
		Connection c = null;
		try{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			
			System.out.println("Banco de dados aberto com sucesso");
			Statement stmt = null;
			stmt = c.createStatement();
			
			
			String sql = null;
			sql = "CREATE TABLE IF NOT EXISTS Disciplina " +
				   "(Codigo integer PRIMARY KEY NOT NULL," +
					"Id 	text 			NOT NULL," +
				    "Prof 	text			NOT NULL," +
					"Recurso integer 			NOT NULL," +
				    "Qtd_aulas integer 			NOT NULL)";
			stmt.executeUpdate(sql);
			System.out.println("Tabela disciplina aberta com sucesso");
			
			sql = "CREATE TABLE IF NOT EXISTS Sala " +
				  "(Id integer PRIMARY KEY NOT NULL," +
				  "Qtd_lugares integer 	  NOT NULL, " +
				  "Recurso integer  	  NOT NULL)";
			stmt.executeUpdate(sql);
			System.out.println("Tabela sala aberta com sucesso");
			
			sql = "CREATE TABLE IF NOT EXISTS Turma " +
				  "(Id integer PRIMARY KEY NOT NULL, " +
				  "Qtd_alunos integer NOT NULL," +
				  "Horario text," +
				  "Disciplina integer NOT NULL," +
				  "Sala integer," +
				  "FOREIGN KEY(Disciplina) REFERENCES Disciplina(Codigo)," +
				  "FOREIGN KEY(Sala) REFERENCES Sala(Id) )" ;
			stmt.executeUpdate(sql);
			System.out.println("Tabela Turma aberta com sucesso");
			
			stmt.close();
			c.close();	
		}catch(Exception e){
			System.err.println(e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}		
		
	}
	
	public boolean inserirDisciplina(int codigo,String id, String prof, int recurso, int qtd_aulas){
		Connection c = null;
		
		try{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:test.db");
			Statement stmt = null;
			stmt = c.createStatement();
			String sql = "INSERT INTO Disciplina (Codigo,Id,Prof,Recurso,Qtd_aulas) " +
						 "VALUES (" + Integer.toString(codigo) + ", '" + id + "', '" + prof + "', " 
						 			+ Integer.toString(recurso) + ", " + Integer.toString(qtd_aulas) + ");" ;
			stmt.executeUpdate(sql);
			System.out.println("Registro inserido com sucesso");
			stmt.close();
			c.close();
		}catch(Exception e){
			if(e instanceof SQLiteException){
				System.err.println(e.getClass().getName() + ": " + e.getMessage() );
				return false;
			}else{
				System.err.println(e.getClass().getName() + ": " + e.getMessage() );
				return false;
			}	
		}	
			return true;
	}
	
}
