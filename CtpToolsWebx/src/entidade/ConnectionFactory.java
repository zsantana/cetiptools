package entidade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 * 
 * Classe responsável por conter os metodos criar e fechar o banco de dados.
 *
 * @author Reinaldo Santana <reinaldojsantana@gmail.com>
 * @since 01/02/2016
 * @version 1.0
 */

public class ConnectionFactory {

	// Caminho do banco de dados.
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/";
	private static final String USUARIO = "sisfat";
	private static final String SENHA = "sisfat";
	

	/**
	 * 
	 * Método responsável por criar uma conexao com o banco 
	 *
	 * @return
	 * @author Reinaldo Santana <reinaldojsantana@gmail.com>
	 * @since 01/02/2016
	 * @version 1.0
	 */
	public Connection criarConexao(String database){
		
		Connection conexao = null;
		
		try {
			
			Class.forName(DRIVER);
			conexao = DriverManager.getConnection(URL + database, USUARIO, SENHA);
			
		} catch (Exception e) {
			System.out.println("Erro ao criar conexão com o banco: " + URL);
			e.printStackTrace();
		}
		return conexao;
	}
	
	
	public void fecharConexao(Connection conexao, PreparedStatement pstmt, ResultSet rs){
		
		try {
			
			if(conexao != null){
				conexao.close();
			}
			if(pstmt != null){
				pstmt.close();
			}
			if(rs != null){
				rs.close();
			}
					
		} catch (Exception e) {
			System.out.println("Erro ao fechar conexão com o banco: " + URL);
		}
	}
}

