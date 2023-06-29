package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class conexao {

	public static final String DRIVER = "mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost/test";
	public static final String USER = "root";
	public static final String PASS = "";
	
	public static void main(String[] args) throws SQLException {
	
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASS);
			ResultSet tabela = conn.createStatement().executeQuery("SELECT * FROM tabela");
			while (tabela.next()) {
				String nome = tabela.getString("nome");
				int idade = tabela.getInt("idade");
				System.out.println("Nome: " + nome);
				System.out.println("Idade: " + idade);
				System.out.println("________________");
			}
		} catch (Exception e) {
			System.out.println("Falha na conexão!" + e);
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		
		System.out.println("Final dos resultados!");
				
	}
		
}
