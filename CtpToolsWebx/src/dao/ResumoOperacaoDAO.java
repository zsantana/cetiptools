package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entidade.ConnectionFactory;


/**
 * 
 * Classe responsável por conter os metodos do CRUD
 *
 * @author Reinaldo Santana <reinaldojsantana@gmail.com>
 * @since 13/01/2016
 * @version 1.0
 */
public class ResumoOperacaoDAO extends ConnectionFactory {

	private static ResumoOperacaoDAO instance;
	
	
	/**
	 * 
	 * Método responsável por criar uma instancia da classe MensagemDAO (Singleton)
	 *
	 * @return
	 * @author Reinaldo Santana <reinaldojsantana@gmail.com>
	 * @since 13/01/2016
	 * @version 1.0
	 */
	public static ResumoOperacaoDAO getInstance(){
		if(instance == null)
			instance = new ResumoOperacaoDAO();
		return instance;
	}
	
		
	
	/**
	 * 
	 * @return
	 */
	public String obterTotMensagem(String dataBase){
		Connection conexao = criarConexao(dataBase);
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String listResult = "";
		
		try {

			StringBuffer str = new StringBuffer();
			str.append("select ro.tot_mensagem "); 
			str.append("  from resumo_operacao ro  ");
			
			pstmt = conexao.prepareStatement(str.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				listResult =  (rs.getString("tot_mensagem"));
				
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao listar as resumo_operacao : " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		
		return listResult;
		
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String obterTotTela(String dataBase){
		Connection conexao = criarConexao(dataBase);
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String listResult = "";
		
		try {

			StringBuffer str = new StringBuffer();
			str.append("select ro.tot_tela "); 
			str.append("  from resumo_operacao ro  ");
			
			pstmt = conexao.prepareStatement(str.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				listResult =  (rs.getString("tot_tela"));
				
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao listar as resumo_operacao : " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		
		return listResult;
		
	}

	
	/**
	 * 
	 * @return
	 */
	public String obterTotArquivo(String dataBase){
		Connection conexao = criarConexao(dataBase);
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String listResult = "";
		
		try {

			StringBuffer str = new StringBuffer();
			str.append("select ro.tot_arquivo "); 
			str.append("  from resumo_operacao ro  ");
			
			pstmt = conexao.prepareStatement(str.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				listResult =  (rs.getString("tot_arquivo"));
				
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao listar as resumo_operacao : " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		
		return listResult;
		
	}

	
	/**
	 * 
	 * @return
	 */
	public String obterTotDeadLetter(String dataBase){
		Connection conexao = criarConexao(dataBase);
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String listResult = "";
		
		try {

			StringBuffer str = new StringBuffer();
			str.append("select ro.tot_dead_letter "); 
			str.append("  from resumo_operacao ro  ");
			
			pstmt = conexao.prepareStatement(str.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				listResult =  (rs.getString("tot_dead_letter"));
				
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao listar as resumo_operacao : " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		
		return listResult;
		
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String obterTotCampo(String dataBase, String campo){
		Connection conexao = criarConexao(dataBase);
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String listResult = "";
		
		try {

			StringBuffer str = new StringBuffer();
			str.append("select * "); 
			str.append("  from resumo_operacao ro  ");
			
			pstmt = conexao.prepareStatement(str.toString());
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				listResult =  (rs.getString( campo ));
				
			}
			
		} catch (Exception e) {
			System.out.println("Erro ao listar as resumo_operacao : " + e);
			e.printStackTrace();
		} finally {
			fecharConexao(conexao, pstmt, rs);
		}
		
		return listResult;
		
	}

		
}
