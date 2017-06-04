package infra;
import java.sql.*;
import java.util.ArrayList;

import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteException;

import business.model.Disciplina;
import business.model.Sala;
import business.model.Turma;

public class SQLiteJDBC implements IBancoDeDados {
	private String nome;
	
	public SQLiteJDBC(String nome){
		this.nome = nome;
		Connection c = null;
		try{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + nome + ".db");
			
			System.out.println("Banco de dados aberto com sucesso");
			Statement stmt = null;
			stmt = c.createStatement();
			
			
			String sql = null;
			sql = "CREATE TABLE IF NOT EXISTS Disciplina " +
				   "(Codigo integer PRIMARY KEY NOT NULL," +
					"Id 	text 			NOT NULL," +
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
				  "Prof    text		  NOT NULL," +
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
	
	public boolean inserirDisciplina(int codigo,String id, int recurso, int qtd_aulas){
		Connection c = null;
		
		try{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + nome + ".db");
			Statement stmt = null;
			stmt = c.createStatement();
			String sql = "INSERT INTO Disciplina (Codigo,Id,Recurso,Qtd_aulas) " +
						 "VALUES (" + Integer.toString(codigo) + ", '" + id + "', " 
						 			+ Integer.toString(recurso) + ", " + Integer.toString(qtd_aulas) + ");" ;
			stmt.executeUpdate(sql);
			
			
			System.out.println("Disciplina inserido com sucesso");
			
			
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
	
	public boolean inserirSala(int id, int qtd_lugar, int recurso){
		Connection c = null;
		
		try{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + nome + ".db");
			Statement stmt = null;
			stmt = c.createStatement();
			String sql = "INSERT INTO Sala (Id,Qtd_lugares,Recurso) " +
						 "VALUES (" + Integer.toString(id) + ", " + Integer.toString(qtd_lugar) + ", " + Integer.toString(recurso) + ");";
			stmt.executeUpdate(sql);
			
			
			System.out.println("Sala inserida com sucesso");
			
				
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
	
	public boolean inserirTurma(int id, int qtd_alunos, String prof, int disciplina){
		Connection c = null;
		
		try{
			Class.forName("org.sqlite.JDBC");
			SQLiteConfig config = new SQLiteConfig();
			config.enforceForeignKeys(true);
			c = DriverManager.getConnection("jdbc:sqlite:" + nome + ".db", config.toProperties());
			
			Statement stmt = null;
			stmt = c.createStatement();
			String sql = "INSERT INTO Turma (Id,Qtd_alunos,Horario, Prof, Disciplina,Sala) " +
						 "VALUES (" + Integer.toString(id) + ", " + Integer.toString(qtd_alunos) + ", NULL, '" +
						 prof + "', " +
						 Integer.toString(disciplina) + ", NULL);";
			stmt.executeUpdate(sql);
			
			System.out.println("Turma inserida com sucesso");
			
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
	
	public ArrayList<Sala> pegarSalas(){
		Connection c = null;
		Statement stmt = null;
		
		try{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + nome + ".db");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Sala");
			ArrayList<Sala> resultado = null;
			Sala sala = null;
			int id, qtd_lugar, recurso;

			while(rs.next()){
				if(resultado == null){
					resultado = new ArrayList<Sala>();
				}
				
				id = rs.getInt("Id");
				qtd_lugar = rs.getInt("Qtd_lugares");
				recurso = rs.getInt("Recurso");
				sala = new Sala(id, qtd_lugar, recurso);
				resultado.add(sala);
			}
			return resultado;	
			
		}catch(Exception e){
			System.err.println(e.getClass().getName() + ": " + e.getMessage() );
			return null;
		}
	}
	
	public ArrayList<Disciplina> pegarDisciplinas(){
		Connection c = null;
		Statement stmt = null;
		
		try{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + nome + ".db");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Disciplina");
			ArrayList<Disciplina> resultado = null;
			Disciplina disciplina = null;
			int codigo, qtd_aulas, recurso;
			String id ;
			
			while(rs.next()){
				if(resultado == null){
					resultado = new ArrayList<Disciplina>();
				}
				
				codigo = rs.getInt("Codigo");
				id = rs.getString("Id");
				qtd_aulas = rs.getInt("Qtd_aulas");
				recurso = rs.getInt("Recurso");
				
				disciplina = new Disciplina(codigo, id, qtd_aulas, recurso);
				resultado.add(disciplina);
			}
			return resultado;			
			
		}catch(Exception e){
			System.err.println(e.getClass().getName() + ": " + e.getMessage() );
			return null;
		}
	}
	
	public ArrayList<Turma> pegarTurmas(ArrayList<Disciplina> disciplinas){
		Connection c = null;
		Statement stmt = null;
		
		try{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + nome + ".db");
			c.setAutoCommit(false);
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Turma");
			ArrayList<Turma> resultado = null;
			Turma turma = null;
			int id, qtd_alunos, disciplinaCod;
			String prof = null;
			Disciplina disciplina = null;

			while(rs.next()){
				if(resultado == null){
					resultado = new ArrayList<Turma>();
				}
				
				id = rs.getInt("Id");
				qtd_alunos = rs.getInt("Qtd_alunos");
				disciplinaCod = rs.getInt("Disciplina");
				prof = rs.getString("Prof");
				
				for(Disciplina disc: disciplinas){				
					if(disc.getCodigo() == disciplinaCod){
						disciplina = disc;
						break;
					}
				}
				
				turma = new Turma( id, qtd_alunos, disciplina, prof);
				resultado.add(turma);
			}
			return resultado;			
			
		}catch(Exception e){
			System.err.println(e.getClass().getName() + ": " + e.getMessage() );
			return null;
		}
	}
	
	
}
